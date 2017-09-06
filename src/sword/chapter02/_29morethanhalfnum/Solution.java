package sword.chapter02._29morethanhalfnum;

public class Solution {
	public static void main(String[] args) {
		int[] test = { 1, 3, 2, 3, 2, 2, 7, 2, 2 };
		//System.out.println(MoreThanHalfNum(test));
		System.out.println(MoreThanHalfNum2(test));
	}

	public static int MoreThanHalfNum(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		int middle = num.length >> 2;
		int start = 0;
		int end = num.length - 1;
		int index = partition(num, start, end);
		while (index != middle) {
			if (index > middle) {
				end = index - 1;
				index = partition(num, start, end);
			} else {
				start = index + 1;
				index = partition(num, start, end);
			}
		}
		int result = num[middle];
		// 判断是否是超过一半
		int count = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == result) {
				count++;
			}
		}
		if (count * 2 <= num.length) {
			return 0;
		}
		// 返回结果
		return result;
	}

	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[low];// 初始值
		while (low < high) {
			while (low < high && arr[high] >= pivot)
				--high;
			arr[low] = arr[high];
			while (low < high && arr[low] <= pivot)
				++low;
			arr[high] = arr[low];
		}
		arr[low] = pivot;
		return low;
	}

	public static int MoreThanHalfNum2(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		int result = 0;
		int times = 0;
		for (int i = 0; i < num.length; i++) {
			if (times == 0) {
				result = num[i];
				times++;
			} else if (num[i] == result) {
				times++;
			} else {
				times--;
			}
		}
		// 判断是否是超过一半
		int count = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == result) {
				count++;
			}
		}
		if (count * 2 <= num.length) {
			return 0;
		}
		return result;
	}
}

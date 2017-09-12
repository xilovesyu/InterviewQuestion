package sword.chapter02._38numscountinlist;

public class Solution {
	public static void main(String[] args) {
		int[] test = { 1, 2, 2, 3, 3, 3, 4, 4, 5 };
		System.out.println(GetNumbersOfK(test, 55));
	}

	/*
	 * 递归形式
	 */
	public static int FirstK(int[] array, int k, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		int midData = array[mid];
		if (midData == k) {
			// 如果左边还有那么还要继续找
			if ((mid > 0 && array[mid - 1] != k) || mid == 0) {
				return mid;
			} else {
				end = mid - 1;
			}
		} else if (midData > k) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}
		return FirstK(array, k, start, end);
	}

	/*
	 * 非递归形式
	 */
	public static int LastK(int[] array, int k) {
		int start = 0;
		int end = array.length;
		while ((start <= end)) {
			int mid = (start + end) / 2;
			if (mid < array.length) {
				if (array[mid] == k) {
					if ((mid < array.length - 1 && array[mid + 1] != k) || mid == array.length - 1) {
						return mid;
					} else {
						start = mid + 1;
					}
				} else if (array[mid] > k) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				return -1;
			}
		}
		return -1;
	}
	
	public static int GetNumbersOfK(int[] array,int k){
		if(array==null||array.length==0){
			return -1;
		}
		int indexOfFirstK=FirstK(array, k, 0, array.length-1);
		int indexOfLastK=LastK(array, k);
		
		if((indexOfFirstK<=indexOfLastK)&&(indexOfFirstK!=-1||indexOfLastK!=-1)){
			return indexOfLastK-indexOfFirstK+1;
		}else{
			return -1;
		}
	}
	
}

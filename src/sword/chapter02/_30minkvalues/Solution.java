package sword.chapter02._30minkvalues;

import sword.util.datastructure.MaxHeap;

public class Solution {
	public static void main(String[] args) {
		int[] test = { 4, 5, 1, 6, 2, 7, 3, 8 };
		int k = 4;
		// KthMinValueWithPartition(test, k);
		KthMinValueWithMaxHeap(test, k);
	}

	public static void KthMinValueWithPartition(int[] array, int k) {
		if (array == null || array.length == 0 || k <= 0) {
			return;
		}
		int start = 0;
		int end = array.length - 1;
		int index = partition(array, start, end);
		while (index != k - 1) {
			if (index > k - 1) {
				end = index - 1;
				partition(array, start, end);
			} else {
				start = index + 1;
				partition(array, start, end);
			}
		}
		for (int i = 0; i < k; i++) {
			System.out.println(array[i]);
		}
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

	public static void KthMinValueWithMaxHeap(int[] array, int k) {
		if (array == null || array.length == 0 || k <= 0) {
			return;
		}
		MaxHeap<Integer> maxHeap = new MaxHeap<>(k);
		for (int i = 0; i < array.length; i++) {
			if (maxHeap.size() != k) {
				maxHeap.add(array[i]);
			} else {
				if (array[i] <= maxHeap.first()) {
					maxHeap.deleteTop();
					maxHeap.add(array[i]);
				}
			}
		}
		while (maxHeap.hasNext()) {
			System.out.println(maxHeap.next());
			;
		}
	}
}

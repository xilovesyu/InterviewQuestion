package sword.chapter02._14reorderoddeven;

import java.util.Arrays;

import swordjava.chapter04.MyLinkList;

public class Solution {
	public static void main(String[] args) {
		int[] test = { 1, 3, 2, 4, 5, 6 };
		// ReorderOddEven(test);
		System.out.println(Arrays.toString(test));

		GeneralReorder(test, new Solution().new IsEvenInterface());
		System.out.println(Arrays.toString(test));
		
		int[] test2 = { 1, -3, 2, -4, -5, 6 };
		GeneralReorder(test2, new Solution().new IsLower0Interface());
		System.out.println(Arrays.toString(test2));
	}

	public static void ReorderOddEven(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		int startPos = 0;
		int endPos = (array.length - 1);
		while (startPos < endPos) {
			while (startPos < endPos && array[startPos] % 2 != 0) {
				startPos++;
			}
			while (startPos < endPos && array[endPos] % 2 == 0) {
				endPos--;
			}

			// change
			if (startPos < endPos) {
				int temp = array[startPos];
				array[startPos] = array[endPos];
				array[endPos] = temp;
			}
		}
	}

	static void GeneralReorder(int[] data, functionInterface func) {
		if (data == null || data.length == 0) {
			return;
		}
		int startPos = 0;
		int endPos = data.length - 1;

		while (startPos < endPos) {
			while (startPos < endPos && !func.judge(data[startPos])) {
				startPos++;
			}
			while (startPos < endPos && func.judge(data[endPos])) {
				endPos--;
			}
			if (startPos < endPos) {
				int temp = data[startPos];
				data[startPos] = data[endPos];
				data[endPos] = temp;
			}
		}
	}

	interface functionInterface {
		boolean judge(int n);
	}

	class IsEvenInterface implements functionInterface {

		@Override
		public boolean judge(int n) {
			// TODO Auto-generated method stub
			if (n % 2 == 0) {
				return true;
			} else
				return false;
		}

	}

	class IsLower0Interface implements functionInterface {

		@Override
		public boolean judge(int n) {
			// TODO Auto-generated method stub
			if (n > 0) {
				return false;
			} else {
				return true;
			}
		}

	}
}

package sword.chapter02._06constructbinarytree;

import java.util.Arrays;

import sword.util.datastructure.TreeNode;

public class Solution {
	public static void main(String[] args) {
		int[] preOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] midOrder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode root = Construct(preOrder, midOrder);
		AfterOrder(root);
	}

	public static void AfterOrder(TreeNode root) {
		if (root != null) {
			AfterOrder(root.left);
			AfterOrder(root.right);
			System.out.println(root.value);
		}
	}

	public static TreeNode Construct(int[] preOrder, int[] midOrder) {
		TreeNode root = new TreeNode();
		root.value = preOrder[0];
		//
		if (preOrder.length == 1 && midOrder.length == 1) {
			return root;
		}

		int valueIndexInMidOrder = -1;
		for (int j = 0; j < midOrder.length; j++) {
			if (root.value == midOrder[j]) {
				valueIndexInMidOrder = j;
			}
		}
		if (valueIndexInMidOrder == -1) {
			return null;
		}

		int leftTreeLength = valueIndexInMidOrder;
		int[] tempPreOrder1 = new int[leftTreeLength];
		for (int i = 0; i < leftTreeLength; i++) {
			tempPreOrder1[i] = preOrder[i + 1];
		}
		int[] tempPreOrder2 = new int[preOrder.length - leftTreeLength - 1];
		for (int i = 0; i < tempPreOrder2.length; i++) {
			tempPreOrder2[i] = preOrder[leftTreeLength + 1 + i];
		}
		int[] tempMidOrder1 = new int[leftTreeLength];
		for (int i = 0; i < tempMidOrder1.length; i++) {
			tempMidOrder1[i] = midOrder[i];
		}
		int[] tempMidOrder2 = new int[tempPreOrder2.length];
		for (int i = 0; i < tempMidOrder2.length; i++) {
			tempMidOrder2[i] = midOrder[valueIndexInMidOrder + 1 + i];
		}
		System.out.println("-----------------");
		System.out.println("root:"+root.value);
		System.out.println(Arrays.toString(tempPreOrder1) + "," + Arrays.toString(tempPreOrder2));
		System.out.println(Arrays.toString(tempMidOrder1) + "," + Arrays.toString(tempMidOrder2));
		System.out.println("");
		System.out.println("-------------------");
		if (tempPreOrder1.length > 0)
			root.left = Construct(tempPreOrder1, tempMidOrder1);
		if (tempPreOrder2.length > 0)
			root.right = Construct(tempPreOrder2, tempMidOrder2);

		return root;
	}
}

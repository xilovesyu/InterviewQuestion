package sword.chapter02._27BST2list;

import sword.util.datastructure.TreeNode;

public class Solution {
	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.value = 10;
		TreeNode temp1 = new TreeNode();
		temp1.value = 6;
		TreeNode temp2 = new TreeNode();
		temp2.value = 14;
		TreeNode temp3 = new TreeNode();
		temp3.value = 4;
		TreeNode temp4 = new TreeNode();
		temp4.value = 8;
		TreeNode temp5 = new TreeNode();
		temp5.value = 12;
		TreeNode temp6 = new TreeNode();
		temp6.value = 16;
		root.left = temp1;
		root.right = temp2;
		temp1.left = temp3;
		temp1.right = temp4;
		temp2.left = temp5;
		temp2.right = temp6;
		
		Convert(root);
		
		System.out.println("aaa");
	}

	public static TreeNode Convert(TreeNode root) {
		TreeNode[] pLastNodeInList = new TreeNode[1];

		BST2List(root, pLastNodeInList);

		TreeNode head = pLastNodeInList[0];
		while (head != null && head.left != null) {
			System.out.println(head.value);
			head = head.left;
		}
		return head;
	}

	public static void BST2List(TreeNode root, TreeNode[] pLastNodeInList) {
		if (root == null) {
			return;
		}
		TreeNode current = root;
		/////
		if (current.left != null)
			BST2List(current.left, pLastNodeInList);

		current.left = pLastNodeInList[0];
		if (pLastNodeInList[0] != null) {
			pLastNodeInList[0].right = current;
		}

		pLastNodeInList[0] = current;

		//////
		if (current.right != null)
			BST2List(current.right, pLastNodeInList);
	}
}

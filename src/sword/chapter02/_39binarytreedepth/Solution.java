package sword.chapter02._39binarytreedepth;

import sword.util.datastructure.TreeNode;

public class Solution {
	public static void main(String[] args) {
		TreeNode root1=new TreeNode();
		root1.value=10;
		TreeNode temp1=new TreeNode();
		temp1.value=5;
		root1.left=temp1;
		TreeNode temp11=new TreeNode();
		temp11.value=12;
		root1.right=temp11;
		TreeNode temp2=new TreeNode();
		temp2.value=4;
		temp1.left=temp2;
		TreeNode temp3=new TreeNode();
		temp3.value=7;
		temp1.right=temp3;
		TreeNode temp4=new TreeNode();
		temp4.value=7;
		temp3.right=temp4;
		
		System.out.println(depth(root1));
		System.out.println(isBalance(root1));
	}
	public static boolean isBalance(TreeNode root){
		if(root==null){
			return true;
		}
		int leftDepth=depth(root.left);
		int rightDepth=depth(root.right);
		if(Math.abs(leftDepth-rightDepth)>1){
			return false;
		}
		return isBalance(root.left)&&isBalance(root.right);
	}
	public static int depth(TreeNode root) {
		if(root==null){
			return 0;
		}
		int leftDepth=depth(root.left);
		int rightDepth=depth(root.right);
		
		return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
	}
	
}

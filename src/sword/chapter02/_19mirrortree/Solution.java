package sword.chapter02._19mirrortree;

import sword.util.datastructure.TreeNode;

public class Solution {
	public static void main(String[] args) {
		TreeNode root1=new TreeNode();
		root1.value=9;
		TreeNode temp1=new TreeNode();
		temp1.value=9;
		root1.left=temp1;
		TreeNode temp2=new TreeNode();
		temp2.value=8;
		temp1.left=temp2;
		TreeNode temp3=new TreeNode();
		temp3.value=3;
		temp1.right=temp3;
		TreeNode temp4=new TreeNode();
		temp4.value=6;
		temp2.left=temp4;
		MirrorTree(root1);
		
		printMidOrderTree(root1);
		
	}
	public static void printMidOrderTree(TreeNode root){
		if(root!=null){
			printMidOrderTree(root.left);
			System.out.println(root.value);
			printMidOrderTree(root.right);
		}
	}
	public static void MirrorTree(TreeNode root){
		if(root==null){
			return;
		}
		if(root.left==null&&root.right==null){
			return;
		}
		
		//交换左右
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		
		if(root.left!=null){
			MirrorTree(root.left);
		}
		if(root.right!=null){
			MirrorTree(root.right);
		}
	}
}

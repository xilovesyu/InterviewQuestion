package sword.chapter02._23printtreefromtoptoend;

import java.util.ArrayList;

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
		
		PrintTreeFromTop2End(root1);
	}
	public static  void PrintTreeFromTop2End(TreeNode root){
		ArrayList<TreeNode> queue=new ArrayList<>();
		queue.add(root);
		while(queue.size()!=0){
			System.out.println(queue.get(0).value);
			TreeNode temp=queue.remove(0);
			//添加
			if(temp.left!=null){
				queue.add(temp.left);
			}
			if(temp.right!=null){
				queue.add(temp.right);
			}
		}
	}
}

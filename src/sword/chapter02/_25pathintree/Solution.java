package sword.chapter02._25pathintree;

import java.util.ArrayList;
import java.util.Iterator;

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
		
		path(root1, 22, 0,new ArrayList<>());
		
	}
	public static void path(TreeNode root,int expectedSum,int currentSum,ArrayList<TreeNode> list){
		currentSum+=root.value;
		list.add(root);
		boolean isLeaf=root.left==null&&root.right==null;
		if(currentSum==expectedSum&&isLeaf){
			System.out.println("find one");
			Iterator<TreeNode> it=list.iterator();
			while(it.hasNext()){
				TreeNode temp=it.next();
				System.out.println(temp.value+",");
			}
		}
		if(root.left!=null)
			path(root.left, expectedSum, currentSum,list);
		if(root.right!=null)
			path(root.right, expectedSum, currentSum,list);
		
		list.remove(list.size()-1);
	}
}

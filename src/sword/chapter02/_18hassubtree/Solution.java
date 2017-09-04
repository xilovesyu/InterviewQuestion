package sword.chapter02._18hassubtree;

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
		
		TreeNode root2=new TreeNode();
		root2.value=9;
		TreeNode temp5=new TreeNode();
		temp5.value=8;
		root2.left=temp5;
		TreeNode temp6=new TreeNode();
		temp6.value=3;
		root2.right=temp6;
		
		System.out.println(hasSubTree(root1, root2));;
	}
	public static boolean hasSubTree(TreeNode root1,TreeNode root2){
		boolean result=false;
		
		if(root1!=null&&root2!=null){
			if(root1.value==root2.value){
				result=hasSubTree2(root1,root2);
			}
			if(!result){
				result=hasSubTree(root1.left, root2);
			}
			if(!result){
				result=hasSubTree(root1.right, root2);
			}
		}
		return result;
	}
	public static boolean hasSubTree2(TreeNode root1,TreeNode root2){
		if(root2==null){
			return true;
		}
		if(root1==null){
			return false;
		}
		if(root1.value!=root2.value){
			return false;
		}
		return hasSubTree2(root1.left, root2.left)&&hasSubTree2(root1.right, root2.right);
	}
}

package sword.chapter02._37firstchildnode;

import sword.util.datastructure.ListNode;

public class Solution {
	public static void main(String[] args) {
		/*
		 * 找到第一个公共子节点
		 * 1-2-3-4-5
		 *           \
		 *            8-9-10 
		 *           / 
		 *       6-7
		 * 思路：先求两个长度，长的为m，短的为n，设置两个指针，那么长的先走m-n，然后一起走，最后到公共的就停     
		 */
		ListNode head1=new ListNode();
		head1.value=1;
		ListNode first1=new ListNode();
		first1.value=2;
		ListNode first2=new ListNode();
		first2.value=3;
		ListNode first3=new ListNode();
		first3.value=4;
		ListNode first4=new ListNode();
		first4.value=5;
		ListNode common1=new ListNode();
		common1.value=8;
		ListNode common2=new ListNode();
		common2.value=9;
		ListNode head2=new ListNode();
		head2.value=6;
		ListNode second1=new ListNode();
		second1.value=7;
		head1.next=first1;first1.next=first2;first2.next=first3;first3.next=first4;
		first4.next=common1;common1.next=common2;
		
		head2.next=second1;second1.next=common1;
		
		System.out.println(FirstChildNode(head1, head2).value);
		
	}
	public static ListNode FirstChildNode(ListNode head1,ListNode head2){
		if(head1==null||head2==null){
			return null;
		}
		int m=0;
		ListNode temp1=head1;
		while(temp1!=null){
			m++;
			temp1=temp1.next;
		}
		int n=0;
		ListNode temp2=head2;
		while(temp2!=null){
			n++;
			temp2=temp2.next;
		}
		temp1=head1;
		temp2=head2;
		int forward=m>n?m-n:n-m;
		int count=0;
		while(count<forward){
			temp1=temp1.next;
			count++;
		}
		while((temp1.next!=null)&&(temp2.next!=null)&&(temp1.next!=temp2.next)){
			temp1=temp1.next;
			temp2=temp2.next;
		}
		return temp1.next;
	}
}

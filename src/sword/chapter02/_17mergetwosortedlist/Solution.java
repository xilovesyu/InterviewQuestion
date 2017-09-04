package sword.chapter02._17mergetwosortedlist;

import sword.util.ListGenerator;
import sword.util.datastructure.ListNode;

public class Solution {
	public static void main(String[] args) {
		ListNode head1=ListGenerator.gen(new int[]{1,3,5,7,9,10});
		ListNode head2=ListGenerator.gen(new int[]{2,4,6,8});
		ListNode mergeHead=mergeTwoSortedList(head1,head2);
		while(mergeHead!=null){
			System.out.println(mergeHead.value);
			mergeHead=mergeHead.next;
		}
	}
	
	public static ListNode mergeTwoSortedList(ListNode head1,ListNode head2){
		if(head1==null){
			return head2;
		}
		if(head2==null){
			return head1;
		}
		ListNode mergeHead=null;
		if(head1.value<head2.value){
			mergeHead=head1;
			mergeHead.next=mergeTwoSortedList(head1.next, head2);
		}else{
			mergeHead=head2;
			mergeHead.next=mergeTwoSortedList(head1, head2.next);
		}
		return mergeHead;
	}
}

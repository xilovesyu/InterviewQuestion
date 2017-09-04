package sword.chapter02._16reverselist;

import sword.util.ListGenerator;
import sword.util.datastructure.ListNode;

public class Solution {
	public static void main(String[] args) {
		ListNode head=ListGenerator.gen(new int[]{1,2,3,4,5});
		ListNode reverseHead=ReverseList(head);
		while(reverseHead!=null){
			System.out.println(reverseHead.value);
			reverseHead=reverseHead.next;
		}
	}
	public static ListNode ReverseList(ListNode head){
		ListNode reverseHead=null;
		ListNode currentNode=head;
		ListNode preNode=null;
		while(currentNode!=null){
			ListNode nextNode=currentNode.next;
			if(nextNode==null){
				reverseHead=currentNode;
			}
			//翻转
			currentNode.next=preNode;
			
			//下一个
			preNode=currentNode;
			currentNode=nextNode;
		}
		return reverseHead;
	}
}

package sword.chapter02._05reverseprintlist;

import sword.util.ListGenerator;
import sword.util.datastructure.ListNode;
import sword.util.datastructure.Stack;

public class Solution {
	public static void main(String[] args) {
		ListNode head=ListGenerator.gen(new int[]{1,3,4,6,7});
		//
		reversePrint(head);
		reversePrintByStack(head);
	}

	public static void reversePrint(ListNode head) {
		if(head.next!=null)
			reversePrint(head.next);
		if (head != null) {
			System.out.println(head.value);
		}
	}
	public static void reversePrintByStack(ListNode head){
		Stack<Integer> myStack=new Stack<>();
		while(head!=null){
			myStack.push(head.value);
			head=head.next;
		}
		while(!myStack.isEmpty()){
			System.out.println(myStack.pop());
		}
	}
}

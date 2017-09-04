package sword.util;

import sword.util.datastructure.ListNode;

public class ListGenerator {
	public static ListNode gen(int [] data){
		ListNode head = new ListNode();
		head.value = data[0];
		ListNode pre = head;
		for (int i = 1; i < data.length; i++) {
			ListNode temp = new ListNode();
			temp.value = data[i];
			pre.next = temp;
			pre = temp;
		}
		return head;
	}
}

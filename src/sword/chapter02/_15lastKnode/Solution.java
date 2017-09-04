package sword.chapter02._15lastKnode;

import sword.util.datastructure.ListNode;

public class Solution {
	public static void main(String[] args) {
		ListNode head = new ListNode();

		int[] values = { 1,2,3, 5, 6, 7 };
		head.value = values[0];
		ListNode pre = head;
		for (int i = 1; i < values.length; i++) {
			ListNode temp = new ListNode();
			temp.value = values[i];
			pre.next = temp;
			pre = temp;
		}
		ListNode result=findLastKNode(head, 6);
		System.out.println(result.value);
	}
	public static ListNode findLastKNode(ListNode head,int k){
		//k的值为正数并且head不为空
		if(k<=0||head==null){
			return null;
		}
		ListNode preNode=head;
		ListNode afterNode=head;
		//k-1  1,2,3,4,5,6 倒数第三个是4，所以应该是4,5,6，顺序是0,1，所以小于2
		for(int i=0;i<k-1;i++){
			if(preNode.next!=null){
				preNode=preNode.next;
			}else{
				return null;//k超过了链表的长度
			}
		}
		while(preNode.next!=null){
			preNode=preNode.next;
			afterNode=afterNode.next;
		}
		return afterNode;
	}
}

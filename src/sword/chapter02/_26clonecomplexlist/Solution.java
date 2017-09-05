package sword.chapter02._26clonecomplexlist;

import sword.util.datastructure.ComplexList;

public class Solution {
	public static void main(String[] args) {
		ComplexList head = new ComplexList();
		head.value = 5;
		ComplexList second = new ComplexList();
		second.value = 3;
		ComplexList third = new ComplexList();
		third.value = 4;
		ComplexList fourth = new ComplexList();
		fourth.value = 6;
		head.next = second;
		head.random = third;
		second.next = third;
		second.random = head;
		third.next = fourth;
		third.random = fourth;
		fourth.random = second;

		ComplexList newHead = Clone(head);
		while (newHead != null) {
			System.out.println("-------------");
			System.out.println(newHead.value);
			if (newHead.next != null) {
				System.out.println(newHead.next.value);
			}
			System.out.println(newHead.random.value);
			newHead = newHead.next;
		}
		
		Clone(null);
	}

	public static ComplexList Clone(ComplexList head) {
		// 1.在每个Node后面复制新node
		CopyNode(head);
		// 2.Copy Random point
		CopyRandomPoint(head);
		// 3.Create New List
		return ConstructNewList(head);
	}

	public static void CopyNode(ComplexList head) {
		ComplexList temp = head;
		while (temp != null) {
			ComplexList tempCopy = new ComplexList();
			tempCopy.value = temp.value;

			tempCopy.next = temp.next;
			temp.next = tempCopy;

			temp = tempCopy.next;
		}
	}

	public static void CopyRandomPoint(ComplexList head) {
		ComplexList temp = head;
		while (temp != null) {
			temp.next.random = temp.random.next;
			temp = temp.next.next;
		}
	}

	public static ComplexList ConstructNewList(ComplexList head) {
		if (head == null) {
			return null;
		}
		ComplexList newHead = head.next;
		ComplexList temp = head;
		while (temp != null) {
			temp.next = temp.next.next;
			temp = temp.next;
		}
		return newHead;
	}
}

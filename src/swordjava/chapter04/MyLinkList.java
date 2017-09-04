package swordjava.chapter04;

import java.util.HashSet;

public class MyLinkList {
	Node<Integer> head = null;

	public void addNode(int data) {
		Node<Integer> newNode = new Node<Integer>(data);
		if (head == null) {
			head = newNode;
		} else {
			// 尾插法或头插法
			Node<Integer> temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
	}

	/*
	 * @param index:删除指定位置的元素
	 * 
	 * @ return :返回该Node，如果删除失败，返回空
	 */
	public Node<Integer> deleteNode(int index) {
		if (index < 0) {
			return null;
		}
		Node<Integer> cur = head;
		Node<Integer> pre = cur;// 前一个元素
		Node<Integer> result = null;
		int count = 0;
		while (cur != null) {
			if (count == index) {
				// shanchu
				result = cur;
				pre.setNext(cur.getNext());
			}
			count++;
			pre = cur;
			cur = cur.getNext();

		}
		return result;
	}

	/*
	 * @param index:指定位置的元素
	 * 
	 * @ return :返回该Node，如果失败，返回空
	 */
	public Node<Integer> findNode(int index) {

		Node<Integer> temp = head;
		int count = 0;
		while (temp != null) {

			if (count == index) {
				break;
			}
			temp = temp.getNext();
			count++;
		}
		if (count == index) {
			return temp;
		} else {
			return null;
		}
	}
	public Node<Integer> findKNode(int k){
		Node<Integer> temp=head;
		Node<Integer> temp2=head;
		for(int i=0;i<k;i++){
			temp=temp.getNext();
		}
		while(temp!=null){
			temp=temp.getNext();
			temp2=temp2.getNext();
		}
		return temp2;
	}
	public int length() {
		Node<Integer> temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}

	public void printList() {
		Node<Integer> temp = head;
		int count = 0;
		System.out.println("----StartPrintList----");
		while (temp != null) {
			count++;
			if (count % 5 == 0) {
				System.out.println(temp.getData() + " ");
			} else {
				System.out.print(temp.getData() + " ");
			}
			if (temp.getNext() != null) {
				temp = temp.getNext();
			} else {
				temp = null;
			}
		}
		System.out.println();
		System.out.println("----EndPrintList----");
	}

	public void deleteDuplecateBySet() {
		Node<Integer> temp = head;
		Node<Integer> pre=temp;
		HashSet<Integer> set = new HashSet<>();
		while (temp != null) {
			if (set.contains(temp.getData())) {
				pre.setNext(temp.getNext());
			} else {
				set.add(temp.getData());
				pre=temp;
			}
			
			temp=temp.getNext();
		}
	}
	public void deleteDuplecate(){
		//采用双重循环
		Node<Integer> temp=head;
		while(temp!=null){
			Node<Integer> temp2=temp.getNext();
			Node<Integer> temp2pre=temp;
			while(temp2!=null){
				if(temp.getData()==temp2.getData()){
					//
					temp2pre.setNext(temp2.getNext());
				}else{
					temp2pre=temp2;
				}
				temp2=temp2.getNext();
			}
			temp=temp.getNext();
		}
	} 
	public static void main(String[] args) {
		MyLinkList list = new MyLinkList();
		list.addNode(5);
		list.addNode(3);
		list.addNode(1);
		list.addNode(2);
		list.addNode(5);
		list.addNode(1);
		list.addNode(2);
		list.addNode(2);
		//System.out.println(list.deleteNode(3).getData());
		// list.de
		list.printList();
		System.out.println(list.findKNode(3).getData());
	}
}

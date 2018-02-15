package Chapter2.Question2;

import java.util.ArrayList;
import java.util.Scanner;

import CodeLibrary.LinkedListNode;

class Index {
	public int value=0;
}

public class Interview3 {

	public static void main(String[] args) {
		Interview3 interview = new Interview3();
		
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		interview.kSearch(head,k);

	}
	

	LinkedListNode kSearch(LinkedListNode head, int k) {
		Index idx = new Index();
		return kSearch(head,k,idx);
	}
	
	LinkedListNode kSearch(LinkedListNode head, int k, Index idx) {
		if(head == null) {
			return null;
		}
		LinkedListNode node = kSearch(head.next,k,idx);
		idx.value = idx.value +1;
		if(idx.value == k) {
			return head;
		}
		return node;
		
	}
	
	
	
	
	
	
	
	
	

}

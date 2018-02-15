package Chapter2.Question2;

import java.util.ArrayList;
import java.util.Scanner;

import CodeLibrary.LinkedListNode;

public class Interview1 {

	public static void main(String[] args) {
		Interview1 interview = new Interview1();
		
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
	
	// It's not best solution. Just easy.
	void kSearch(LinkedListNode head, int k) {
		if(head.next == null) {
			System.out.println("size = 1 , 1 number : " + head.data);
			return;
		}
		
		ArrayList<Object> list = new ArrayList<Object>();
		LinkedListNode current = head;
		list.add(current.data);
		
		int size=1;
		// measure size
		while(current != null) {
			if(current.next != null) {
				current = current.next;
				list.add(current.data);
				size++;
			} else {
				break;
			}
		}
		System.out.println("Size : " + list.size());
		System.out.println("Back k : " + list.get(size - k));		
	}
	
	
	
	
	
	
	
	
	

}

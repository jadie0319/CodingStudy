package Chapter2.Question2;

import java.util.ArrayList;
import java.util.Scanner;

import CodeLibrary.LinkedListNode;


// Using two points

public class Interview4 {

	public static void main(String[] args) {
		Interview4 interview = new Interview4();
		
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
		System.out.println(interview.kSearch(head,k).data);

	}

	LinkedListNode kSearch(LinkedListNode head, int k) {
		
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		/*  p1 --> k move	*/
		for(int i=0; i < k ; i++) {
			if(p1==null) return null;
			p1 = p1.next;
		}
		
		/* p1, p2 move */
		/* p1 arrive end, p2 move length-k(end-k) */
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
		
	}
	
	
	
	
	
	
	

}

package Chapter2.Question2;

import java.util.ArrayList;
import java.util.Scanner;

import CodeLibrary.LinkedListNode;

public class Interview2 {

	public static void main(String[] args) {
		Interview2 interview = new Interview2();
		
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
	

	int kSearch(LinkedListNode head, int k) {
		if(head == null) {
			return 0;
		}
		int index = kSearch(head.next , k) +1;
		if(index == k) {
			System.out.println(k + "th to last node is " + head.data);
		}
		return index;
		
	}
	
	
	
	
	
	
	
	
	

}

package test;

import java.io.IOException;
import java.util.Scanner;

import CodeLibrary.LinkedListNode;


public class Interview1 {
	
	public static void main(String[] args) throws IOException{
		
		int pivot=0;
		
		LinkedListNode<Integer> first = new LinkedListNode<Integer>(1, null, null);
		LinkedListNode<Integer> head = first;
		LinkedListNode<Integer> second = first;
		
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode<Integer>(((int)(Math.random()*10)), null, null);
			first.setNext(second);
			second.setPrevious(first);
			if(i==4) {
				pivot = second.data;
			}
			first = second;
		}
		LinkedListNode<Integer> head2 = head;
		while(head2 != null) {
			System.out.print(head2.data + " << ");
			head2 = head2.next;
		}
		
		Scanner sc = new Scanner(System.in);
		pivot = sc.nextInt();
		
		// pivot is 5th number.
		System.out.println("pivot : " + pivot);
		
		System.out.println();
		head = divided(head,pivot);
		
		while(head != null) {
			System.out.print(head.data + " << ");
			head = head.next;
			
		}
		
		
		
	}
	
	static LinkedListNode<Integer> divided(LinkedListNode<Integer> node, int pivot) {
		
		LinkedListNode<Integer> head = node;
		LinkedListNode<Integer> tail = node;
		
		while (node != null) {
			LinkedListNode<Integer> next = node.next;
			if(node.data < pivot) {
//				System.out.println("node : "+node.data + "   head : " + head.data);
				
				node.next = head;
				head = node;
//				System.out.println("node2 : "+node.data + "   head2 : " + head.data);
			} 
			else {
//				System.out.println("node : "+node.data + "   tail : " + tail.data);
				tail.next = node;
				tail = node;
			}
			node = next;
			
		}
		tail.next = null;
		

		return head;
		
	}
	

	
	

}

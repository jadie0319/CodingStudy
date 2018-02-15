package Chapter2.Question4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import CodeLibrary.LinkedListNode;

/*
 * 2-4 분할 : 값 x가 주어졌을때 x보다 작은 노드들을 x보다 크거나 같은 노드들보다
 * 앞에 오도록 하는 코드를 작성하라. 만약  x가 리스트에 있다면 x는 그보다 작은
 * 원소들보다 뒤에 나오기만 하면 된다. 즉 원소 x는 '오른쪽 그룹' 어딘가에만
 * 존재하면 된다. 왼쪽과 오른쪽 그룹 사이에 있을 필요는 없다.
 * 
 */


public class Interview1 {
	
	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int pivot = Integer.parseInt(br.readLine());
		
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
				node.next = head;
				head = node;
				
			} 
			else {
				tail.next = node;
				tail = node;
			}
			node = next;
			
		}
		tail.next = null;
		

		return head;
		
	}
	
	

}

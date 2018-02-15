package Chapter2.Question8;


import CodeLibrary.AssortedMethods;
import CodeLibrary.LinkedListNode;

/*
 * 2-8 루프발견 : 순환 연결리스트가 주어졌을 때, 순환되는 부분의 첫째 노드를
 * 반환하는 알고리즘을 작성하라. 순환 연결리스트란 노드의 next포인터가 앞선 노드들
 * 가운데 어느 하나를 가리키도록 설정되어 있는, 엄밀히 말해서는 변질된 방식의
 * 연결리스트를 의미한다.
 * 
 */


public class Interview1 {

	public static void main(String[] args) {
		Interview1 interview = new Interview1();
		
		LinkedListNode<Character> first = new LinkedListNode<Character>('a', null, null);
		LinkedListNode<Character> second = new LinkedListNode<Character>('b',null,first);
		LinkedListNode<Character> third = new LinkedListNode<Character>('c',null,second);
		LinkedListNode<Character> forth = new LinkedListNode<Character>('d',null,third);
		
		LinkedListNode<Character> fifth = third;
		forth.next = fifth;
		// a -> b -> c -> d -> c
		
		LinkedListNode head = first;
		
		for(int i=0 ; i < 5 ; i++) {
			if(i==4) {
				System.out.print(head.data);
			}else {
				System.out.print(head.data + " -> ");
			}
			head=head.next;
		}
		System.out.println();
		System.out.println("Loop point : " + interview.findBeginning(first).data);
	}
	
	
	LinkedListNode<Character> findBeginning(LinkedListNode<Character> head) {
		LinkedListNode<Character> slow= head;
		LinkedListNode<Character> fast= head;
		
		// search meeting point
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				break;
			}
		}
		
		// check error
		if(fast == null || fast.next == null) {
			return null;
		}
		
		// slow moves head, fast stay.
		// slow and fast stay away k length from meeting point.
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
		
		
	}
	

}

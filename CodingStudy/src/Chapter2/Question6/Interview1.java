package Chapter2.Question6;

import CodeLibrary.LinkedListNode;

/*
 * 2-6 회문 : 주어진 연결리스트가 회문(palindrome)인지 검사하는 함수를 작성하라.
 * 
 */

public class Interview1 {
	static int length(LinkedListNode<Character> head) {
		int size = 0;
		if(head == null) {
			return 0; 
		} else {
			return 1 + length(head.next);
		}
	}
	

	public static void main(String[] args) {
		Interview1 interview = new Interview1();
		
		LinkedListNode<Character> first = new LinkedListNode<Character>('a', null, null);
		LinkedListNode<Character> second = new LinkedListNode<Character>('c',null,first);
		LinkedListNode<Character> third = new LinkedListNode<Character>('c',null,second);
		LinkedListNode<Character> forth = new LinkedListNode<Character>('a',null,third);
		
		System.out.println(interview.isPalindrome(first,forth));

	}
	
	boolean isPalindrome(LinkedListNode<Character> head,LinkedListNode<Character> tail) {
		int size = length(head);
		for(int i=0 ; i < size / 2 ; i++) {
		
			if(head.data == tail.data) {
				head = head.next;
				tail = tail.prev;
			}else {
				return false;
			}
		}
		return true;

	}

}

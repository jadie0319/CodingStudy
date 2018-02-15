package Chapter2.Question3;

import CodeLibrary.LinkedListNode;

/*
 * 2-3 중간 노드 삭제 : 단방향 연결리스트가 주어졌을 때 중간(정확히 가운데 노드일
 * 필요는 없고 처음과 끝 노드만 아니면 된다)에 있는 노드 하나를 삭제하는 알고리즘을
 * 구현하라.
 * 
 * input : a->b->c->d->e 에서 노드 c
 * result : 반환할 필요는 없지만, 결과로 a->b->d->e 가 되어 있어야 한다.
 */


public class Interview1 {

	public static void main(String[] args) {
		LinkedListNode<Character> first = new LinkedListNode<Character>('a', null, null);
		LinkedListNode<Character> head = first;
		LinkedListNode<Character> second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode<Character>((char)('a'+i), null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		
		System.out.println(head.next.next.next.data + " delete");
		
		deleteNode(head.next.next.next);
		System.out.println(head.printForward());
		

	}
	
	
	static void deleteNode(LinkedListNode<Character> node) {
		if(node == null || node.next == null) {
			return;
		}
		
		LinkedListNode<Character> next = node.next;
		node.data = next.data;
		node.next = next.next;
	}
	
	
	
	
	
	

}

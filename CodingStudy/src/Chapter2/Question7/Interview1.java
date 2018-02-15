package Chapter2.Question7;

import CodeLibrary.AssortedMethods;
import CodeLibrary.LinkedListNode;

/*
 * 2-7 교집합 : 단방향 연결리스트 두 개가 주어졌을 때 이 두 리스트의 교집합
 * 노드를 찾은 뒤 반환하는 코드를 작성하라. 여기서 교집합이란 노드의 값이 아니라
 * 노드의 주소가 완전히 같은 경우를 말한다. 즉 첫 번째 리스트에 있는 k번째 노드와
 * 두 번째 리스트에 있는 j번째 노드가 주소까지 완전히 같다면 이 노드는 교집합의 
 * 원소가 된다.
 */

class Result {
	public LinkedListNode tail;
	public int size;
	public Result(LinkedListNode tail, int size) {
		this.tail = tail;
		this.size = size;
	}
}



public class Interview1 {
	
	LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
		if(list1 == null || list2 == null) {
			return null;
		}
		
		// find tail and size
		Result result1 = getTailAndSize(list1);
		Result result2 = getTailAndSize(list2);
		
		// last nodes are different -> no intersection
		if(result1.tail != result2.tail) {
			return null;
		}
		
		// set start point
		LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
		LinkedListNode longer = result1.size < result2.size ? list2 : list1;
		
		// moving longer start point between gap
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));
		
		while(shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		
		return longer;
	}
	
	Result getTailAndSize(LinkedListNode list) {
		if(list == null) return null;
		
		int size = 1;
		LinkedListNode current = list;
		while(current.next != null) {
			size++;
			current = current.next;
		}
		return new Result(current, size);
	}
	
	LinkedListNode getKthNode(LinkedListNode head, int k) {
		LinkedListNode current = head;
		while(k > 0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
	}
	
	
	
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
		LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);
		
		int[] vals2 = {12, 14, 15};
		LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);
		
		list2.next.next = list1.next.next.next.next;
		
		System.out.println(list1.printForward());
		System.out.println(list2.printForward());
		
		Interview1 interview = new Interview1();
		
		LinkedListNode intersection = interview.findIntersection(list1, list2);
		
		System.out.println(intersection.printForward());
		
		
	}

}

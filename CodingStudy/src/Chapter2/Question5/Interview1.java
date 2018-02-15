package Chapter2.Question5;

/*
 * 2-5 리스트의 합 : 연결리스트로 숫자를 표현할 때 각 노드가 자릿수 하나를 가리키는
 * 방식으로 표현할 수 있다. 각 숫자는 역순으로 배열되어 있는데, 첫 번째 자릿수가
 * 리스트의 맨 앞에 위치하도록 배열된다는 뜻이다. 이와 같은 방식으로 표현된 숫자 
 * 두 개가 있을 때, 이 두 수를 더하여 그 합을 연결리스트로 반환하는 함수를 작성하라.
 */

import CodeLibrary.LinkedListNode;

public class Interview1 {
	public static void main(String[] args) {
		
		Interview1 interview = new Interview1();
		
		int nums1[] = {7,1,6};
		int nums2[] = {5,9,2};
		
		
		LinkedListNode<Integer> num1 = interview.createNodes(nums1);
		LinkedListNode<Integer> num2 = interview.createNodes(nums2);
		LinkedListNode<Integer> head = num1;
		LinkedListNode<Integer> head2 = num2;
		LinkedListNode<Integer> list = addLists(head,head2,0);
		
		System.out.println(" " + num1.printForward() );
		System.out.println(" " + num2.printForward() );
		System.out.println(" " + list.printForward() );
		
		int l1 = linkedListToInt(num1);
		int l2 = linkedListToInt(num2);
		int l3 = linkedListToInt(list);
		
		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
//		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));	
		
		
	}
	
	LinkedListNode<Integer> createNodes(int[] nums) {
		
		LinkedListNode<Integer> first = new LinkedListNode<Integer>(nums[0], null, null);
		LinkedListNode<Integer> head = first;
		LinkedListNode<Integer> second = first;
		
		for(int i=1; i < 3 ; i++) {
			second = new LinkedListNode<Integer>(nums[i], null,null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		
		return head;
	}
	
	// same depth l1,l2
	private static LinkedListNode<Integer> addLists(LinkedListNode<Integer> l1,
			LinkedListNode<Integer> l2, int carry) {
		if(l1 == null && l2 == null && carry == 0 ) {
			return null;
		}
		
		LinkedListNode<Integer> result = new LinkedListNode<Integer>();
		int value = carry;
		if(l1 != null ) {
			value += l1.data;
		}
		
		if(l2 != null) {
			value += l2.data;
		}
		
		result.data = value % 10;
		
		if(l1 != null || l2 != null) {
			LinkedListNode<Integer> more = addLists(l1==null ? null : l1.next ,
					l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
			result.setNext(more);
		}
		
		
		return result;
	}
	
	
	public static int linkedListToInt(LinkedListNode<Integer> node) {
		int value = 0;
		if (node.next != null) {
			value = 10 * linkedListToInt(node.next);
		}
		return value + node.data;
	}

}

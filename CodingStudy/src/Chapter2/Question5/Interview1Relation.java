package Chapter2.Question5;

import CodeLibrary.LinkedListNode;

/*
 * 2-5 연관문제 : 각 자릿수가 정상적으로 배열된다고 가정하고 같은 문제를 풀어보자.
 */

// Book Solution
class PartialSum {
	public LinkedListNode<Integer> sum = null;
	public int carry = 0;
}

public class Interview1Relation {	
	LinkedListNode<Integer> createNodes(int[] nums) {
		
		LinkedListNode<Integer> first = new LinkedListNode<Integer>(nums[0], null, null);
		LinkedListNode<Integer> head = first;
		LinkedListNode<Integer> second = first;
		
		for(int i=1; i < nums.length ; i++) {
			second = new LinkedListNode<Integer>(nums[i], null,null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		
		return head;
	}
	
	LinkedListNode<Integer> addLists(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
		int len1 = length(l1);
		int len2 = length(l2);
		
		// 짧은 리스트에 0을 붙인다. 
		if(len1 < len2) {
			l1 = padList(l1,len2-len1);
		} else {
			l2 = padList(l2,len1-len2);
		}
		
		// 두 리스트를 더한다.
		PartialSum sum = addListsHelper(l1,l2);
		
		// 넘김수 (carry)가 존재한다면 리스트의 앞쪽에 삽입한다.
		// 그렇지 않다면 연결리스트만을 반환한다.
		if(sum.carry == 0 ) {
			return sum.sum;
		} else {
			LinkedListNode<Integer> result = insertBefore(sum.sum, sum.carry);
			return result;
		}
		
		
	}
	
	PartialSum addListsHelper(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
		if(l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		
		// 작은 자릿수를 재귀적으로 더한다.
		PartialSum sum = addListsHelper(l1.next, l2.next);
		
		// 현재 값에 넘김수를 더한다.
		int val = sum.carry + l1.data + l2.data;
		
		// 현재 자릿수를 합한 결과를 삽입한다.
		LinkedListNode<Integer> full_result = insertBefore(sum.sum, val % 10);
		
		// 지금까지의 합과 넘김수를 반환한다.
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}
	
	int length(LinkedListNode<Integer> list) {
		if(list == null) {
			return 0;
		} else {
			return 1 + length(list.next);
		}
	}
	
	LinkedListNode<Integer> padList(LinkedListNode<Integer> l, int padding) {
		LinkedListNode<Integer> head = l;
		for(int i=0; i < padding; i++) {
			head = insertBefore(head,0);
		}
		return head;
	}
	LinkedListNode<Integer> insertBefore(LinkedListNode<Integer> list, int data) {
		LinkedListNode<Integer> node = new LinkedListNode<Integer>(data);
		if(list != null) {
			node.next = list;
		}
		return node;
	}
	public static int linkedListToInt(LinkedListNode<Integer> node) {
		int value = 0;
		while(node != null) {
			value = value * 10 + node.data;
			node = node.next;
		}
		return value;
	}

	public static void main(String[] args) {

		
		Interview1Relation interview = new Interview1Relation();
		
		int nums1[] = {6,1};
		int nums2[] = {2,9,5};
		
		
		LinkedListNode<Integer> num1 = interview.createNodes(nums1);
		LinkedListNode<Integer> num2 = interview.createNodes(nums2);
		LinkedListNode<Integer> head = num1;
		LinkedListNode<Integer> head2 = num2;
		//LinkedListNode<Integer><Integer> list = addLists(head,head2,0);
		
		LinkedListNode<Integer> result = interview.addLists(num1,num2);
		
		System.out.println(" " + num1.printForward() );
		System.out.println(" " + num2.printForward() );
		System.out.println(" " + result.printForward() );
		
		int l1 = linkedListToInt(num1);
		int l2 = linkedListToInt(num2);
		int l3 = linkedListToInt(result);
		
		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		
	}

}

package Chapter2.Question1;

import java.util.HashSet;
import java.util.LinkedList;

import CodeLibrary.LinkedListNode;

/*
 *  2-1 중복 없애기 : 정렬되어 있지 않은 연결리스트가 주어졌을 때 이 리스트에서
 *  중복되는 원소를 제거하는 코드를 작성하라.
 *  (연관문제 : 임시 버퍼를 사용할 수 없다면 어떻게 풀 수 있을까?)
 */

public class Interview1 {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(3);list.add(4);
		list.add(1);list.add(7);
		list.add(2);list.add(6);
		list.add(3);list.add(4);
		list.add(5);list.add(10);
		
		System.out.println(list);
		Interview1 interview = new Interview1();
//		interview.deleteDuplication(list);
//		System.out.println(list);
		
		HashSet set = new HashSet();
		
		set = interview.deleteDuplication2(list);
		System.out.println(set);
		
		LinkedListNode node = new LinkedListNode(1,null,null);
		LinkedListNode node2 = new LinkedListNode(2,null,null);
		node2.setNext(node);
		
		System.out.println("===========================");
		
	}
	
	void deleteDuplication(LinkedList list) {
		for(int i=0; i < list.size()-1 ; i++) {
			for(int j=i+1 ; j < list.size() ; j++) {
				if(list.get(i) == list.get(j)) {
					list.remove(j);
				}
			}
		}
	}
	
	// HashSet doesn't allow duplication. 
	HashSet deleteDuplication2(LinkedList list) {
		HashSet set = new HashSet();
		for(int i=0; i < list.size() ; i++) {
			set.add(list.get(i));
		}
		return set;
	}
	
	

}

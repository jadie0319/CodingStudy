package Chapter3.Question3;

import java.util.EmptyStackException;

import Chapter3.StackQueue.MyStack;
import CodeLibrary.LinkedListNode;

public class SetOfStacks extends MyStack {
	//Set<Stack> set = new HashSet<Stack>();
	// set을 사용하거나 node를 스택으로 해서 next로 연결시킨다.
	
	
	private MyStack stack;
	private int stackCount;
	private LinkedListNode<MyStack> node;
	
	public SetOfStacks() {
		stack = new MyStack();
		stackCount = 1;
		node = new LinkedListNode<MyStack>(stack);
	}
	
	
	public void push(int value) {
		if(node.data.isFull()) {
			// 새로 스택 생성. 노드생성.
			MyStack newStack = new MyStack();
			newStack.push(value);
			LinkedListNode<MyStack> newNode = new LinkedListNode<MyStack>(newStack);
			stackCount++;
			newNode.next = node;
			node = newNode;
			
		} else {
			node.data.push(value);
			
		}
		
	}
	
	public int pop() {
		int result =0;
		if(node.data.isEmpty() && stackCount==1) {
			throw new EmptyStackException();
		} else {
			result = node.data.pop();
			if(node.data.isEmpty()) {
				node=node.next;
				stackCount--;
			}
		}
		return result;
	}
	
	// isFull 이 true면 새로운 스택을 생성해야한다.
	// isEmpty 가 true면 현재 스택을 제거하고 이전 스택으로 돌아가야 한다.
	
	public boolean isStackFull() {
		return true;
	}
	
	public void print() {
		LinkedListNode<MyStack> tmp = node;
		while(tmp != null) {
			tmp.data.print();
			if(tmp.next != null) {
				System.out.println("====== next ====");
				tmp = tmp.next;
			} else {
				tmp = tmp.next;
			}
			
		}
	}
	
	public void stackCountPrint() {
		System.out.println(stackCount);
	}
	
	//빈 스택 채워주는것 없이 pop만 수행하는 메소드.
	public int popAt(int index) {
		int count = stackCount;
		LinkedListNode<MyStack> tmp = node;
		
		while(count != index) {
			tmp = tmp.next;
			count--;
			if(count == index) {
				break;
			}
		}
		
		
		
		return tmp.data.pop();
	}

}

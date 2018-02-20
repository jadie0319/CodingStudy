package Chapter3.Question3;

import java.util.EmptyStackException;

public class MyStack {
	private static class StackNode {
		private int data;
		private StackNode next;
		public StackNode(int data) {
			this.data = data;
		}
	}
	// capacity max = 5
	
	private int capacity;
	private StackNode top;
	
	public int pop() {
		if(top == null) throw new EmptyStackException();
		int item = top.data;
		top = top.next;
		return item;
	}
	
	public void push(int item) {
		if(capacity == 5) {
			System.out.println("Stack Overflow");
			return;
		} else {
			StackNode t = new StackNode(item);
			t.next = top;
			top = t;
			capacity++;
		}
		
		
	}
	
	public int peek() {
		if(top==null) throw new EmptyStackException();
		return top.data;
	}
	
	public boolean isEmpty() {
		return top==null;
	}
	
	public boolean isFull() {
		return capacity==5 ? true : false;
	}
	
	public void print() {
		StackNode tmp = top;
		while(tmp!=null ) {
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
	

}

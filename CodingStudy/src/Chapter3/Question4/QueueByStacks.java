package Chapter3.Question4;

import Chapter3.Question4.MyStack;

public class QueueByStacks {
	
	private MyStack stack1;
	private MyStack stack2;
	
	public QueueByStacks() {
		stack1 = new MyStack();
		stack2 = new MyStack();
	}
	
	public void add(int item) {
		stack1.push(item);
	}
	
	public int remove() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		
		int pop = stack2.pop();
		
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		
		return pop;
	}
	
	public int peek() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		
		int peek = stack2.peek();
		
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		
		return peek;
	}
	
	public void printStack1() {
		stack1.print();
		
	}
	public void printStack2() {
		stack2.print();
	}
	
	

}

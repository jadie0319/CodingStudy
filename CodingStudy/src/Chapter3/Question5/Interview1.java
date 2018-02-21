package Chapter3.Question5;

import Chapter3.StackQueue.MyStack;

/*
 *  3-5 스택 정렬 : 가장 작은 값이 위로 오도록 스택을 정렬하는 프로그램을 작성하라.
 *  추가적으로 하나 정도의 스택은 사용해도 괜찮지만 스택에 보관된 요소를 배열 등의 다른
 *  자료구조로 복사할 수는 없다. 스택은 push, pop, peek, isEmpty 의 네 가지
 *  연산을 제공해야 한다.
 */

public class Interview1 {
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.print();
		
		System.out.println();
		sort(stack);
		stack.print();
		
		
	}
	// 다른 공간에 저장 -> 스택에 저장.
	// 스택에 바로 저장. 다른공간 사용 불가.
	static public void sort(MyStack stack) {
		MyStack tempStack = new MyStack();
		
		while(!stack.isEmpty()) {
			int tmp = stack.pop();
			while(!tempStack.isEmpty() && tempStack.peek() > tmp) {
				stack.push(tempStack.pop());
			}
			tempStack.push(tmp);
		}
		
		while(!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
		
		
		
	}

}

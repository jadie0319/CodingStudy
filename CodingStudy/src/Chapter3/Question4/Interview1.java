package Chapter3.Question4;



/*
 * 3-4 스택으로 큐 : 스택 두 개로 큐 하나를 구현한 MyQueue 클래스를 구현하라. 
 */

public class Interview1 {

	public static void main(String[] args) {
		QueueByStacks queue = new QueueByStacks();
		
		queue.add(1);
		queue.add(3);
		queue.add(2);
		queue.add(6);
		queue.add(8);
		
		queue.printStack1();
		
		queue.remove();
		queue.remove();
		
		System.out.println();
		
		queue.printStack1();
		
		

	}

}

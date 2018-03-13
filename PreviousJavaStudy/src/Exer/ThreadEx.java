package Exer;

import java.util.Random;

//프로그래밍 면접 책 p281
class Producer extends Thread {
	private IntBuffer buffer;
	public Producer (IntBuffer buffer) {
		this.buffer=buffer;
	}
	public void run() {
		Random r = new Random();
		while(true) {
			int num = r.nextInt();
			buffer.add(num);
			System.out.println("Produced " + num);
		}
	}
	
}

class Consumer extends Thread {
	private IntBuffer buffer;
	public Consumer(IntBuffer buffer) {
		this.buffer=buffer;
	}
	public void run() {
		while(true) {
			int num = buffer.remove();
			System.out.println("Consumed " + num);
		}
	}
}



public class ThreadEx {
	
	public static void main(String[] args) {
		IntBuffer b = new IntBuffer();
		Producer p = new Producer(b);
		
		Consumer c = new Consumer(b);
		p.start();
		c.start();
		
	}

}



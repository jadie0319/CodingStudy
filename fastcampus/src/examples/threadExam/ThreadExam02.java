package examples.threadExam;

public class ThreadExam02 {

	public static void main(String[] args) {
		MyThread02 m1 = new MyThread02("*");
        MyThread02 m2 = new MyThread02("+");
        MyThread02 m3 = new MyThread02("#");
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        Thread t3 = new Thread(m3);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("main메소드 종료.");
		
		

	}

}

class MyThread02 implements Runnable {
	private String str;
	public MyThread02 (String str) {
		this.str = str;
	}

	@Override
	public void run() {
		for(int i=0 ; i < 5 ;i++) {
			System.out.println(str);
			try {
				Thread.sleep((long)(Math.random() * 1000));
			}catch(InterruptedException ie) {}
		}
	}
	
}
package examples.threadExam;

public class ThreadExam04 {

	public static void main(String[] args) {
		// 이름없는 클래스, 익명 클래스  new A() { ... }
		// A를 상속 받거나, 구현하는 이름 없는 객체를 생성한다.
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for(int i=0; i < 5 ; i++) {
					System.out.print("*");
				}
			}
		};
		Thread t1 = new Thread(r);
		t1.start();

	}

}

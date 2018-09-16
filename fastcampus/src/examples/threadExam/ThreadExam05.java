package examples.threadExam;

public class ThreadExam05 {

	public static void main(String[] args) {
		// 이름없는 클래스, 익명 클래스  new A() { ... }
		// A를 상속 받거나, 구현하는 이름 없는 객체를 생성한다.
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i < 5 ; i++) {
					System.out.print("*");
				}
			}
		});

		t1.start();
	}

}

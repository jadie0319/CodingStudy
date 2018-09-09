package examples.templateMethod;

// method 에 있는 final 은 상속 금지.
// 선배가 짠 코드. 
public abstract class BaseAction {
	public final void a() {
		System.out.println("aaaaa");
	}
	
	public final void logic() {
		a();
		run();
		b();
		
	}
	
	public abstract void run(); // 미완성 메소드.
	
	
	public final void b() {
		System.out.println("bbbbb");
	}

}

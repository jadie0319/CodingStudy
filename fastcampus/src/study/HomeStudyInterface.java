package study;

interface Frindle {
	public void write();
}

// A 의 코드
class Pencil implements Frindle {
	@Override
	public void write() {
		System.out.println("연필");
	}
}

// B의 코드
class Ballpoint implements Frindle {
	@Override
	public void write() {
		System.out.println("볼펜");
	}
}


public class HomeStudyInterface {
	public static void main(String[] args) {
		Frindle frindle = new Pencil();
		frindle.write();
		
		frindle = new Ballpoint();
		frindle.write();
	}
}


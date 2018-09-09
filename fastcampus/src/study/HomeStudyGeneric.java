package study;

/*
 *  제네릭 사용 example
 */

//class Box {
//	private Object object;
//	public Box() {}

//	public Box(Object object) {
//		this.object = object;
//	}
//	public Object getObject() {
//		return this.object;
//	}
//	public void setObject(Object object) {
//		this.object = object;
//	}
//}

class Box<T> {
	private T t;
	public Box() {}
	public T get() {
		return this.t;
	}
	public void set(T t) {
		this.t = t;
	}
}


class Apple {	}

public class HomeStudyGeneric {
	public static void main(String[] args) {
		Box<String> stringBox = new Box<String>();
		stringBox.set("hi");
		
		String str = stringBox.get();
		System.out.println(str);
		
		Box<Integer> integerBox = new Box<Integer>();
		integerBox.set(11);
		
		int value = integerBox.get();
		System.out.println(value);
	}

}

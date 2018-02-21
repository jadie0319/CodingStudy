package Chapter3.Question6;

import java.util.LinkedList;

/* enqueue, dequeueAny, dequeueDog, dequeueCat 의
  연산을 제공해야 한다. 기본적으로 탑재되어 있는 LinkedList 자료구조를
  사용해도 좋다. */

class Animal {
	private int order;
	protected String name;
	public Animal(String name) {
		this.name = name;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getOrder() {
		return this.order;
	}
	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}
	
}

class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}
}
class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}
}


public class AnimalQueue {
	
	private LinkedList<Dog> dogs = new LinkedList();
	private LinkedList<Cat> cats = new LinkedList();
	private int order = 1;
	
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		
		if(a instanceof Dog) {
			dogs.addLast((Dog)a);
		} else if(a instanceof Cat) {
			cats.addLast((Cat) a);
		}
	}
	
	public Animal dequeueAny() {
		if(dogs.size() == 0 ) {
			return dequeueCats();
		} else if(cats.size() == 0) {
			return dequeueDogs();
		}
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if(dog.isOlderThan(cat)) {
			return dequeueDogs();
		} else {
			return dequeueCats();
		}
		
		
	}
	
	public Dog dequeueDogs() {
		return dogs.poll();
	}
	
	public Cat dequeueCats() {
		return cats.poll();
	}
	
	

}

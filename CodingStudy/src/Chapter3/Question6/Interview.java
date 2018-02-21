package Chapter3.Question6;

/*
 *  3-6 동물보호소 : 먼저 들어온 동물이 먼저 나가는 동물 보호소가 있다고 하자.
 *  이 보호소는 개와 고양이만 수용한다. 사람들은 보호소에서 가장 오래된 동물부터
 *  입양할 수 있는데, 개와 고양이 중 어떤 동물을 데려갈지 선택할 수 있다. 하지만
 *  특정한 동물을 지정해 데려갈 수는 없다. 이 시스템을 자료구조로 구현하라.
 *  이 자료구조는 enqueue, dequeueAny, dequeueDog, dequeueCat 의
 *  연산을 제공해야 한다. 기본적으로 탑재되어 있는 LinkedList 자료구조를
 *  사용해도 좋다.
 */

public class Interview {

	public static void main(String[] args) {
		Dog dog1 = new Dog("dog 1");
		Dog dog2 = new Dog("dog 2");
		Dog dog3 = new Dog("dog 3");
		
		Cat cat1 = new Cat("cat 1");
		Cat cat2 = new Cat("cat 2");
		
		AnimalQueue queue = new AnimalQueue();
		queue.enqueue(dog2);
		queue.enqueue(dog3);
		queue.enqueue(cat1);
		queue.enqueue(dog1);
		queue.enqueue(cat2);
		
		Animal animal = queue.dequeueDogs();
		//Animal animal = queue.dequeueCats();
		
		System.out.println("name : " + animal.name + " order : " + animal.getOrder());
		
		

	}

}

package Chapter4.Question11;



/*
 * 4-11  임의의 노드 : 이진 트리 클래스를 바닥부터 구현하려고 한다. 노드의 삽입,
 * 삭제,검색뿐만 아니라 임의의 노드를 반환하는 getRandomNode() 메서드도 구현한다.
 * 모든 노드를 같은 확률로 선택해주는 getRandomNode 메서드를 설계하고 구현하라.
 * 또한 나머지 메서드는 어떻게 구현할지 설명하라. 
 */

public class Question {

	public static void main(String[] args) {
		int[] counts = new int[10];
		for (int i = 0; i < 2; i++) {
			Tree tree = new Tree();
			int[] array = {1, 0, 6, 2, 3, 9, 4, 5, 8, 7};
			for (int x : array) {
				tree.insertInOrder(x);
			}
			int d = tree.getRandomNode().data;
			counts[d]++;
		}
		
		
		int sum = 0;
		for (int i = 0; i < counts.length; i++) {
			System.out.println(i + ": " + counts[i]);
			sum += counts[i];
		}
		
		System.out.println(sum);

	}

}

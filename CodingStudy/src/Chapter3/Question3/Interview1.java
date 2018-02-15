package Chapter3.Question3;



/*
 * 3-3 접시무더기 : 접시무더기를 생각해보자. 접시를 너무 높이 쌓으면 무너져 내릴 것이다.
 * 따라서 현실에서는 접시를 쌓다가 무더기가 어느 정도 높아지면 새로운 무더기를 만든다.
 * 이것을 흉내 내는 자료구조 SetOfStacks를 구현해보라.
 * SetOfStacks 는 여러 개의 스택으로 구성되어 있으며, 이전 스택이 지정된 용량을
 * 초과하는 경우 새로운 스택을 생성해야한다. SetOfStacks.push()와
 * SetOfStacks.pop()은 스택이 하나인 경우와 동일하게 동작해야한다.
 * (다시말해 pop()은 정확히 하나의 스택이 있을 때와 동일한 값을 반환해야한다.)
 * 
 * - 연관문제 : 특정한 하위 스택에 대해서 pop을 수행하는 popAt(int index) 함수를
 * 구현하라.
 */

public class Interview1 {

	public static void main(String[] args) {
		
		SetOfStacks set = new SetOfStacks();
		
		for(int i=1; i < 30 ; i++) {
			set.push(i);
		}
		
		
		set.print();
		System.out.print("stackCount : ");
		set.stackCountPrint();
		
		System.out.println("=================");
		System.out.println(set.popAt(5));
		System.out.println(set.popAt(5));
		set.print();
		
		
		

	}

}

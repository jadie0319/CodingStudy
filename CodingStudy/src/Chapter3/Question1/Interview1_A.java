package Chapter3.Question1;

import CodeLibrary.AssortedMethods;

/*
 * 3-1 한 개로 세 개 : 배열 한 개로 스택 세 개를 어떻게 구현할지 설명하라.
 * 
 */
public class Interview1_A {
	public static void printStacks(FixedMultiStack stacks) {
		System.out.println(AssortedMethods.arrayToString(stacks.getValues()));
	}

	public static void main(String[] args) throws Exception {
		FixedMultiStack stacks = new FixedMultiStack(4);
		printStacks(stacks);
		stacks.push(0, 10);
		printStacks(stacks);
		stacks.push(1, 20);
		printStacks(stacks);
		stacks.push(2, 30);
		printStacks(stacks);
		
		stacks.push(1, 21);
		printStacks(stacks);
		stacks.push(0, 11);
		printStacks(stacks);
		stacks.push(0, 12);
		printStacks(stacks);
		
		stacks.pop(0);
		printStacks(stacks);
		
		stacks.push(2, 31);
		printStacks(stacks);
		
		stacks.push(0, 13);
		printStacks(stacks);
		stacks.push(1, 22);
		printStacks(stacks);
		
		stacks.push(2, 31);
		printStacks(stacks);
		stacks.push(2, 32);
		printStacks(stacks);
		
		

	}

}

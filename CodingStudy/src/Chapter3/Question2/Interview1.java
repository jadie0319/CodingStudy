package Chapter3.Question2;

public class Interview1 {

	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		int[] array = {2, 1, 3, 1};
		for (int value : array) {
			stack.push(value);
			
			System.out.print(value + ", ");
		}
		System.out.println('\n');
		

	}

}

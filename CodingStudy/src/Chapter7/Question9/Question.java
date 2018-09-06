package Chapter7.Question9;

public class Question {

	public static void main(String[] args) {
		int size = 10;
		CircularArray<String> arr = new CircularArray<String>(size);
		for(int i=0; i < size ; i++) {
			arr.set(i, String.valueOf(i));
			System.out.print(arr.get(i) + " ");
		}
		
		System.out.println();
		
		arr.rotate(3);
		for(int i=0 ; i < size; i++) {
			System.out.print(arr.get(i) + " ");
		}
		
		System.out.println();
		
		arr.rotate(2);
		
		for(String s : arr) {
			System.out.print(s + " ");
		}
		

	}

}

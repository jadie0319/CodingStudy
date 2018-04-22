package Chapter5.Question7;





/*
 * 5-7 쌍끼리 맞바꾸기 : 명령어를 가능한 한 적게 사용해서 주어진 정수의 짝수 번째
 * 비트의 값과 홀수 번째 비트의 값을 바꾸는 프로그램을 작성하라.
 * 예 : 0번째 비트와 1번째 비트를 바꾸고, 2번째 비트와 3번째 비트를 바꾸는 식으로)
 */

public class Question {

	public static void main(String[] args) {
		int a = 1775;
		String binaryNum = binaryToString(a);
		System.out.println(binaryNum + "   length : " + binaryNum.length());
		
		String result = changeEvenOdd(binaryNum);
		
		System.out.println("\n" + result);
		

	}
	
	public static String binaryToString(int num) {
		String s = "";
		while(num > 0) {
			Integer n = new Integer(num & 1);
			s = n.toString() + s;
			num = num >> 1;
		}
		return s;
	}
	
	public static String changeEvenOdd(String s) {
		System.out.println("in method : " + s);
		char[] chars = s.toCharArray();
		
		for(int i=0; i < s.length(); i=i+2 ) {
			if(i == s.length()-1) {
				break;
			}
			char temp = chars[i];
			chars[i] = chars[i+1];
			chars[i+1] = temp;
			
			int k=0;
			while(k < 11) {
				System.out.print(chars[k]);
				k++;
			}
			System.out.println();
		}
		
		
		return String.valueOf(s);
	}

}

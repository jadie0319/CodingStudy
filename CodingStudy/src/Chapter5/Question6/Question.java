package Chapter5.Question6;



/*
 * 5-6 변환 : 정수 A와 B를 2진수로 표현했을 때, A를 B로 바꾸기 위해 뒤집어야
 * 하는 비트의 개수를 구하는 함수를 작성하라.
 * 
 * input : 29(혹은 11101), 15(01111)
 * output : 2
 */

public class Question {

	public static void main(String[] args) {
		int a = 29;
		int b = 15;
		String s1 = binaryToString(a);
		String s2 = binaryToString(b);
		System.out.println("number1 : " + s1 + " number2 : " + s2);
		
		if(s1.length() >= s2.length()) {
			s2 = addZero(s2, s1.length() - s2.length());
		} else {
			s1 = addZero(s1, s2.length() - s1.length());
		}
		System.out.println("number1 : " + s1 + " number2 : " + s2);
		
		int alterNum = alterNumber(s1,s2);
		System.out.println(alterNum);
		
		
		// Using bit
		System.out.println(bitSwapRequired(a,b));
		
		
		
	}
	
	
	// int ---> binary
	public static String binaryToString(int num) {
		String s = "";
		while(num > 0) {
			Integer n = new Integer(num & 1);
			s = n.toString() + s;
			num = num >> 1;
		}
		return s;
	}
	
	
	
	// add zero 
	public static String addZero(String str, int numberZero) {
		while(numberZero > 0) {
			str = "0" + str;
			numberZero--;
		}
		
		return str;
	}
	
	// counting changed 0
	public static int alterNumber(String str1, String str2) {
		int count =0;
		for(int i=0 ; i < str1.length() ; i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				count++;
			}
		}
		return count;
	}
	
	
	// Using bit xor
	public static int bitSwapRequired(int a, int b) {
		int count =0;
		for(int c = a^b ; c != 0 ; c=c >> 1 ) { 
			count += c & 1;
		}
		return count;
	}

}

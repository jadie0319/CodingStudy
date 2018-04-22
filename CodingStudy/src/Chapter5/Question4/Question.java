package Chapter5.Question4;






/*
 * 5-4 다음 숫자 : 양의 정수가 하나 주어졌다. 이 숫자를 2진수로표기했을 때 1비트의
 * 개수가 같은 숫자 중에서 가장 작은수와 큰수를 구하여라.
 * 
 * 11001 -> 작은수 : 00111 , 큰수 : 11100 
 */

public class Question {

	public static void main(String[] args) {
		int a = 1775;  // 11011101111
		String binaryNum = binaryToString(a);
		System.out.println(binaryNum);
		
		int count = countOne(binaryNum);
		String smallest = binaryMin(binaryNum,count);
		System.out.println(smallest);
		
		String biggest = binaryMax(binaryNum,count);
		System.out.println(biggest);

		
	}
	
	// 1 개수 세는 함수
	public static int countOne(String str) {
		char[] chars = str.toCharArray();
		int count = 0;
		for(int i=0; i < chars.length ; i++) {
			if(chars[i] == '1') {
				count++;
			}
		}
		return count;
	}
	
	// 가장 큰 수 찾는 함수
	public static String binaryMin(String str, int count) {
		System.out.println(str + "      " + count);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length() ; i++) {
			if(i < count) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			
		}
		
		return sb.toString();
	}
	
	// 가장 작은 수 찾는 함수
	public static String binaryMax(String str, int count) {
		StringBuilder sb = new StringBuilder();
		for(int i = str.length()-1; i >= 0 ; i--) {
			if(i < count) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			
		}
		
		return sb.toString();
	}
	
	
	public static String binaryToString(int num) {
		String s = "";
		while(num > 0) {
			Integer number = new Integer(num & 1);
			s = number.toString() + s;
			num = num >> 1;
		}
		
		return s;
	}

}

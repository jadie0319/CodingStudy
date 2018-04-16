package Chapter5.Question3;


/*
 *  5-3 비트 뒤집기 : 어떤 정수가 주어졌을 때 여러분은 이 정수의 비트 하나를 0에서
 *  1로 바꿀 수 있다. 이때 1이 연속으로 나올 수 있는 가장 큰 길이를 구하는 코드를
 *  작성하라.
 *  
 *   input : 1775 ( 혹은 11011101111)
 *   출력 : 8
 *   
 */

public class Question {
	public static void main(String[] args) {
		int num = 1775;
		String binaryNum = binaryToString(num);
		System.out.println(binaryNum);
		System.out.println(countLongestOne(binaryNum));
		
		
		
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

	
	public static int countLongestOne(String s) {
		
		char[] chars = s.toCharArray();
		int max = 0;
		for(int i=0 ; i < chars.length ; i++) {
			if(chars[i] == '0') {
				max = checkChangeBit(chars, i);
			}
		}
		
		return max;
	}
	
	public static int checkChangeBit(char[] chars, int position) {
		char[] temp = chars.clone();
		temp[position] = '1';
		
		int oneCount =0;
		int max =0;
		
		for(int i=0 ; i < temp.length ; i++) {
			if(temp[i] == '1') {
				oneCount++;
				max = oneCount >= max ? oneCount : max;
			} else {
				
				oneCount = 0;
			}
		}
		
		return max;
	}
	
	
	
	
	
	
	
	
	
}

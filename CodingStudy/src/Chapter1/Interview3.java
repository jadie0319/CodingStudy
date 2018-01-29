package Chapter1;

import java.util.Scanner;

/*
 *  1-3 URL화 : 문자열에 들어 있는 모든 공백을 '%20'으로 바꿔 주는 메서드를
 *  작성하라. 최종적으로 모든 문자를 다 담을 수 있을 만큼 충분한 공간이 이미
 *  확보되어 있으며 문자열의 최종 길이가 함께 주어진다고 가정해도 된다.
 *  (자바로 구현한다면 배열 안에서 작업할 수 있도록 문자배열을 이용하길 바란다.)
 *  
 *  input : "Mr John Smith" , 13(length)
 *  output : "Mr%20John%20Smith"
 */

public class Interview3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String words = sc.nextLine();
		int length = sc.nextInt();
		
		StringBuilder builder = new StringBuilder();
		Interview3 interview = new Interview3();
		
		char[] str = words.toCharArray();
		
		interview.changeSpace(str, builder);
		interview.changeSpace2(str, length);
		
	
	}
	
	// Using StringBuilder
	// This solution don't use length. We better used all terms. 
	
	public void changeSpace(char[] str, StringBuilder builder) {
		
		for(int i=0; i < str.length ; i++) {
			if(str[i] != ' ') {
				builder.append(str[i]);
			} else {
				builder.append("%20");
			}
		}
		System.out.println(builder);
	}
	
	
	// Book's solution.
	// It read word from back.
	
	public void changeSpace2(char[] str, int length) {
		int spaceCount=0;
		for(int i=0 ; i < length ; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		int index = length + spaceCount * 2;
		
		char[] result = new char[index];
		
		for(int i= length-1 ; i >= 0 ; i--) {
			if(str[i] == ' ') {
				result[index-1] = '0';
				result[index-2] = '2';
				result[index-3] = '%';
				index= index -3;
			} else {
				result[index-1] = str[i];
				index--;
			}
		}
		
		System.out.println(result);
		
	}

}

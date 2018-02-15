package Chapter1.Question6;

import java.util.Scanner;
import java.util.Stack;

/*
 * 1-6 문자열 압축 : 반복되는 문자의 개수를 세는 방식의 기본적인 문자열 압축
 * 메소드를 작성하라. 예를 들어 문자열 aabccccaaa를 압축하면 a2b1c4a3이 된다.
 * 만약 '압축된' 문자열의 길이가 기존 문자열의 길이보다 길다면 기존 문자열을
 * 반환해야 한다. 문자열은 대소문자 알파벳으로만(a to z) 이루어져 있다.
 */

public class Interview6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		
		Interview6 interview = new Interview6();
		
		System.out.println(interview.compression(word));
		
		
		
		
		
		
		
	}
	
	// My solution. It's complex. This solution is inefficient.
	
	String compression(String word) {
		int count=1;
		StringBuilder result = new StringBuilder();
		
		char alphabet[] = word.toCharArray();
		
		for(int i=0 ; i < alphabet.length ; i++) {
			if(i != alphabet.length -1) {
				if(alphabet[i] == alphabet[i+1]) {
					count++;
					
				} else {
					result.append(alphabet[i]);
					result.append(count);
					count=1;
				}
			} else if (i == alphabet.length -1) {
				if(i==0) {
					return alphabet[i] + "1";
				} else if(alphabet[i] == alphabet[i-1]) {
					result.append(alphabet[i]);
					result.append(count);
					
				} else if (alphabet[i] != alphabet[i-1]) {
					result.append(alphabet[i] + "1");
				}
			}
		}
		
		if(alphabet.length >= result.length()) {
			return result.toString();
		} else {
			return word;
		}
		
	}
	
	String comPression(String word) {
		StringBuilder compressed = new StringBuilder();
		int count=0;
		for(int i=0; i < word.length() ; i++) {
			count++;
			
			// i+1 >= word.length()가 의미하는 것을
			// 위에서는 너무 복잡하게 표현했다.
			if(i+1 >= word.length() || word.charAt(i) != word.charAt(i+1) ) {
				compressed.append(word.charAt(i));
				compressed.append(count);
				count=0;
			}
		}
		return compressed.length() < word.length() ? compressed.toString() : word;
		
		
	}
	
	
	
	
	
	
}

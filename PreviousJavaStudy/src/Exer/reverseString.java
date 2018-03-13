package Exer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reverseString {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int start=0;
		int end=0;
		int length=0;
		
		String src = br.readLine();
		length = src.length()-1;
		reverseString rs = new reverseString();
		
		
		System.out.println("원본 : " + src);
		System.out.println("reverse : " + rs.reverseStr(src));
		System.out.println("word reverse : " + rs.reverseWords(rs.reverseStr(src)));
		

	}
	// 문장 전체를 뒤집는 함수, 단어 뒤집는것도 사용.
	public String reverseStr(String str) {
		char ch[] = new char[str.length()];
		char ch2[] = str.toCharArray();
		String result="";
		for(int i=0 ; i < ch.length ; i++) {
			result += Character.toString(ch2[ch2.length-1 - i]);
		}
		return result;
		
	}
	
	public String reverseWords(String str) {
		String st[] = str.split(" ");
		String result="";
		for(int i=0 ; i < st.length ; i++) {
			result += reverseStr(st[i]) + " ";
		}
		result = result.substring(0, result.length()-1);
		
		return result;
	}

}

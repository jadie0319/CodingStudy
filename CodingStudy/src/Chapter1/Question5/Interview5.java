package Chapter1.Question5;

/*
 * 1-5 하나 빼기 : 문자열을 편집하는 방법에는 세 가지 종류가 있다.
 * 문자 삽입, 문자 삭제, 문자 교체. 문자열 두 개가 주어졌을 때, 문자열을 같게
 * 만들기 위한 편집 횟수가 1회 이내인지 확인하는 함수를 작성하라.
 * 
 * input, output : pale, ple -> true
 * pale, bale -> true
 * pale, bake -> false
 */

import java.util.Scanner;

public class Interview5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word1 = sc.nextLine();
		String word2 = sc.nextLine();
		
		Interview5 interview = new Interview5();
		
		System.out.println(interview.selectOne(word1, word2));
		
		
		

	}
	
	// ## 1
	boolean selectOne(String word1, String word2) {
		if(word1.length() == word2.length()) {
			return replace(word1,word2);
		} else if(word1.length() -1 == word2.length()) {
			return insert(word1 , word2);
		} else if(word1.length() + 1 == word2.length()) {
			return insert(word2, word1);
		}
		
		return false;
	}
	
	boolean replace(String word1, String word2) {
		boolean checkReplaceable = false;
		for(int i=0 ; i < word1.length() ; i++) {
			if(word1.charAt(i) != word2.charAt(i)) {
				if(checkReplaceable) {
					return false;
				} else {
					checkReplaceable = true;
				}
			}
		}
		
		return true;
	}

	// word1 is long. word2 is short.
	boolean insert(String word1, String word2) {
		int index1 =0;
		int index2 =0;
		
		while(word1.length() > index1 && word2.length() > index2) {
			if(word1.charAt(index1) != word2.charAt(index2)) {
				if(index1 != index2) {
					return false;
				}
				index1++;
			} else {
				index1++;
				index2++;
			}
		}
		
		return true;
	}
	

}

package Chapter1;

import java.util.ArrayList;

/* 1-2 순열 확인 : 문자열 두 개가 주어졌을 때 이 둘이 서로 순열 관계에
 * 있는지 확인하는 메서드를 작성하라.
 */

import java.util.Scanner;

public class Interview2 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Interview2 interview = new Interview2();
		
		String word1 = sc.nextLine();
		String word2 = sc.nextLine();
		
		int val = word1.charAt(0);
		System.out.println(val);
		
		if(word1.length() != word2.length()) {
			System.out.println("False");
		}
		
		ArrayList<String> wordList1 = new ArrayList<String>();
		ArrayList<String> wordList2 = new ArrayList<String>();
		
		wordList1 = interview.permutation(word1);
		wordList2 = interview.permutation(word2);
		
		interview.compareTwoWords(wordList1, wordList2);
		
		/*
		 * The main thing is to understand purpose of Question.
		 * Actually, permutation method is not necessary.
		 * 1. Sort + count char.
		 * 2. Using Hashtable.
		 * Above two solution easily understand than the bottom.
		 */
		
		
	}
	
	
	
	public ArrayList<String> permutation(String word) {
		ArrayList<String> permutationList = new ArrayList<String>();
		permutation(word,"",permutationList);
		return permutationList;
	}
	
	public void permutation(String word, String prefix,ArrayList<String> permutationList) {
		if(word.length() == 0) {
			permutationList.add(prefix);
		}else {
			for(int i=0; i < word.length() ; i++) {
				String temp = word.substring(0, i) + word.substring(i+1);
				permutation(temp, prefix + word.charAt(i),permutationList);		
			}
			
		}
	}
	
	// very inefficient
	public void compareTwoWords(ArrayList<String> words1, ArrayList<String> words2) {
		for(int i=0 ; i < words1.size() ; i++) {
			for(int j=0 ; j < words2.size() ; j++) {
				if(words1.get(i).equals(words2.get(j))) {
					System.out.println("TRUE : word1("+i+") : "
							+ words1.get(i) + "  word2(" + j + ") : " + words2.get(j));
					return;
				}
			}
		}
		System.out.println("FALSE");
	}
	
	
	
	
}

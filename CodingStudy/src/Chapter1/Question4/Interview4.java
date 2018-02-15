package Chapter1.Question4;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1-4 회문 순열 : 주어진 문자열이 회문(palindrome)의 순열인지 아닌지 확인하는
 * 함수를 작성하라. 회문이란 앞으로 읽으나 뒤로 읽으나 같은 단어 혹은
 * 구절을 의미하며, 순열이란 문자열을 재배치하는 것을 뜻한다. 회문이 꼭 사전에
 * 등장하는 단어로 제한될 필요는 없다.
 * 
 * Input : Tact Coa
 * Output : True(순열 : "taco cat", "atco cta" 등)
 */

/*
 * This question don't require all permutations. 
 */


public class Interview4 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		char[] arr = input.toCharArray();
		
		
		Interview4 in = new Interview4();
		
		
		

	}
	
	// Book's Solution(Bottom)

	// a,b,c ~~  -> number
	// ## 1.
	boolean isPermutationOfPalindrome(String phrase) {
		int[] table = buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}
	
	boolean checkMaxOneOdd (int[] table) {
		boolean foundOdd = false;
		for(int count : table) {
			if(count % 2 ==1) {
				if(foundOdd) {
					return false;
				}
				foundOdd=true;
			}
		}
		return true;
	}
	
	int getCharNumber ( Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a <= val && val <= z) {
			return val - a;
		}
		
		return -1;
	}
	
	int[] buildCharFrequencyTable(String phrase) {
		int[] table = new int[Character.getNumericValue('z') -
		                      Character.getNumericValue('a')+1];
		
		for(char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if( x != -1) {
				table[x]++;
			}
		}
		
		return table;
	}
	
	
	// ## 2. hashtable

	boolean isPermutationOfPalindrome2(String phrase) {
		int countOdd =0;
		int[] table = new int[Character.getNumericValue('z') -
		                      Character.getNumericValue('a')+1];
		for(char c: phrase.toCharArray()) {
			int x = getCharNumber(c);
			if( x != -1) {
				table[x]++;
				if(table[x] % 2 == 1) { // if odd
					countOdd++;
				} else {
					countOdd--;
				}
			}
		}
		
		return countOdd <= 1;
	}
	
	// ## 3
	
	boolean isPermutationOfPalindrome3(String phrase) {
		int bitVector = createBitVector(phrase);
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);
	}
	
	
	// create bitvector
	int createBitVector(String phrase) {
		int bitVector =0;
		for(char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			bitVector = toggle(bitVector,x);
		}
		return bitVector;
	}
	
	// 정수의 i번째 비트값을 바꾼다.
	int toggle(int bitVector, int index) {
		if(index < 0) return bitVector;
		int mask = 1 << index;
		if ((bitVector & mask) == 0) {
			bitVector |= mask;
		} else {
			bitVector &= ~mask;
		}
		return bitVector;
	}
	
	boolean checkExactlyOneBitSet(int bitVector) {
		return (bitVector & (bitVector - 1)) == 0;
	}
	
	

}

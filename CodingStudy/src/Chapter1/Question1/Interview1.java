package Chapter1.Question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Hashtable;

/* 1-1 중복이 없는가? (Duplication)
 * 문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는
 * 확인하는 알고리즘을 작성하라. 자료구조를 추가로 사용하지 않고
 * 풀 수 있는 알고리즘 또한 고민하라.
 */


public class Interview1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word1 = br.readLine();
		
		Interview1 interview = new Interview1();
		System.out.println(interview.isDuplicated(word1));
		System.out.println(interview.isDuplicatedUseSort(word1));
		System.out.println(interview.isDuplicatedUseHash(word1));
		System.out.println(interview.isDuplicatedUseBitSet(word1));
		
		
		

	}
	
	// brute force? 
	
	public String isDuplicated(String word1) {
		
		for(int i=0 ; i < word1.length()-1 ; i++) {
			for(int j=i+1 ; j < word1.length() ; j++) {
				if(word1.charAt(i) == word1.charAt(j)) {
					return "Duplicated";
				}
			}
		}
		return "Not Duplicated";
	}
	
	// Using sort
	// ex) abcedb -> abbcde 
	
	public String isDuplicatedUseSort(String word1) {
		char[] ch = word1.toCharArray();
		Arrays.sort(ch);
		
		
		for(int i=0 ; i < ch.length -1 ; i++) {
			if(ch[i] == ch[i+1]) {
				return "Duplicated";
			}
		}
		return "Not Duplicated";
		
	}
	
	
	// Hashtable
	// Or compare size(). if table.size() < word1.length()
	// duplicate. (hashtable doesn't allow duplication of keys) 
	
	public String isDuplicatedUseHash(String word1) {
		
		Hashtable<Character,Integer> table = new Hashtable<Character,Integer>();
		for(int i=0 ; i < word1.length() ; i++) {
			if(!table.containsKey(word1.charAt(i))) {
				table.put(word1.charAt(i), 1);
			} else {
				
				return "Duplicated";
			}
		}
		return "Not Duplicated";
	}
	
	// Using BitSet
	// (int)a = 97
	
	public String isDuplicatedUseBitSet(String word1) {
		BitSet bitSet = new BitSet();
	
		for(int i=0 ; i < word1.length() ; i++) {
			int temp = (int)word1.charAt(i)-97;
			
			if(bitSet.get(temp)==true) {
				return "Duplicated";
			} else {
				bitSet.set(temp, true);
			}
		}
		return "Not Duplicated";
		
	}
	

}

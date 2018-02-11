package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Chapter1.Question1.Interview1;

public class Interview1Test {
	@Test
	public void testDuplication() {
		Interview1 interview = new Interview1();
		String testStr = "abcdefghijklmnopqrstuvawxyz";
		
		String result = interview.isDuplicated(testStr);
		assertEquals(result,"Duplicated");
	}
	@Test
	public void testDuplicationUseSort() {
		Interview1 interview = new Interview1();
		String testStr = "abcdefghijklmnopqrstuvawxyz";
		
		String result = interview.isDuplicatedUseSort(testStr);
		assertEquals(result,"Duplicated");
	}
	
	static void main (String[] args) {
		
	}
	
	
}

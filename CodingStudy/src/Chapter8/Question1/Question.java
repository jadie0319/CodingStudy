package Chapter8.Question1;

import java.util.Arrays;

public class Question {

	public static void main(String[] args) {
		int n = 3;
		int ways = count(n);
		System.out.println(ways);
	}
	
	
	public static int count(int n) {
		int memo[] = new int[n+1];
		Arrays.fill(memo, -1);
		return count(n, memo);
	}
	
	public static int count(int n, int[] memo) {
		if(n < 0) {
			return 0;
		} else if(n == 0) {
			return 1;
		} else if(memo[n] > -1) {
			return memo[n];
		} else {
			memo[n] = count(n-1, memo) + count(n-2, memo) + count(n-3,memo);
			return memo[n];
		}
	}
	

}

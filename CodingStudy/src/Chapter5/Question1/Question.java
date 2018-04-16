package Chapter5.Question1;

import CodeLibrary.AssortedMethods;

public class Question {
	
	public static int changeBits(int n, int m, int i, int j) {
		
		if(i >= 32 || j < i) {
			return 0;
		}
		
		int allOne = ~0;
		int left = allOne << (j+1);
		int right = (1 << i) -1;
		int mask = left | right;
		
		int n_clear = n & mask;
		int m_move = m << i;
		
		return n_clear | m_move;
	}
	
	

	public static void main(String[] args) {
		int a = 103217;
		System.out.println(toFullBinaryString(a));
		
		int b = 13;
		System.out.println(toFullBinaryString(b));
		
		int c = changeBits(a,b,20,23);
		System.out.println(toFullBinaryString(c));
		
		
	}
	
	public static String toFullBinaryString(int a) {
		String s = "";
		for (int i = 0; i < 32; i++) {
			Integer lsb = new Integer(a & 1);
			s = lsb.toString() + s;
			a = a >> 1;
		}
		return s;
	}

}

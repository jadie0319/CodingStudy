package Chapter5;

public class test {

	public static void main(String[] args) {
		int x = -93242;
		int count = 40;
		
		System.out.println(repeatedArithmeticShift(x,count));
		System.out.println(x);
		System.out.println(repeatedLogicalShift(x,count));

	}
	
	public static int repeatedArithmeticShift(int x, int count) {
		for(int i=0; i < count ; i++) {
			x >>= 1;  // 최상위 비트에 1을 반복적으로 채워 넣음 -> 결과는 -1
		}
		return x;
	}

	public static int repeatedLogicalShift(int x, int count) {
		for(int i=0; i < count; i++) {
			x >>>= 1; // 최상위 비트에 0을반복적으로 채워 넣음 -> 결과는 0
		}
		return x;
	}
}

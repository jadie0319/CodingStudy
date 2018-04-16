package Chapter5.Question2;



/*
 * 5-2 2진수를 문자열로 : 0.72와 같이 0과 1 사이의 실수가 double 타입으로 주어졌을 때,
 * 그 값을 2진수 형태로 출력하는 코드를 작성하라. 길이가 32이하인 문자열로 2진수로 
 * 정확하게 표현할 수 없다면 error을 출력하라.
 */

public class Question {

	public static String binaryToString(double num) {
		if(num >= 1 || num <= 0) {
			return "ERROR";
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(".");
		while(num > 0) {
			if(builder.length() > 32) {
				return "ERROR";
			}
			double r = num * 2;
			if(r >= 1) {
				builder.append(1);
				num = r-1;
			} else {
				builder.append(0);
				num=r;
			}
		}
		return builder.toString();
	}
	
	
	
	public static void main(String[] args) {
		String bs = binaryToString(.72);
		System.out.println(bs);
		
		for (int i = 0; i < 1000; i++) {
			double num = i / 1000.0;
			String binary = binaryToString(num);
			if (!binary.equals("ERROR")) {
				System.out.println(num + " : " + binary);
			}
		}

	}

}

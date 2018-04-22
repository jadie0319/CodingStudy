package Chapter5.Question5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * 5-5  디버거 : 다음 코드가 하는 일을 설명하라. (펜으로 풀자)
 * 	(( n & (n-1)) == 0)
 */
public class Question {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int number = sc.nextInt();
		
		if((number & (number-1)) == 0) {
			System.out.println(number + " 는 2의 거듭제곱수다.");
		}else {
			System.out.println(number + " 은 2의 거듭제곱수가 아니다.");
		}
		

	}

}

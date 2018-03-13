package Exer;

import java.util.Scanner;

public class removeChars {

	public static void main(String[] args) {
		
		String s  = "가나다라똠방각하ABCDE 가나다라똠방각하ABCDE"; // 원본 문자열
	    String s2;

	    System.out.println("원본:    " + s);
	    System.out.println(); // 줄바꿈


	    // 문자열에서 모든 똠방각하 다 지우기
	    s2 = s.replace("똠방각하", "");
	    System.out.println("삭제(1): " + s2); // 출력 결과: 가나다라ABCDE 가나다라ABCDE


	    // 첫번째 "똠방각하"만 없애기
	    s2 = s.replaceFirst("똠방각하", "");
	    System.out.println("삭제(2): " + s2); // 출력 결과: 가나다라ABCDE 가나다라똠방각하ABCDE


	    // 문자열에서 모든 똠방각하 다 지우기
	    s2 = s.replaceAll("똠방각하", "");
	    System.out.println("삭제(3): " + s2); // 출력 결과: 가나다라ABCDE 가나다라ABCDE

			
		
		Scanner sc = new Scanner(System.in);
		String test = sc.nextLine();
		
		removeChars rc = new removeChars();
		System.out.println(rc.removeChar(test, "p"));
		
		

	}
	
	public static String removeChar (String str, String remove) {
		
		char[] s = str.toCharArray();
		char[] r = remove.toCharArray();
		int src,dst=0;
		
		// 삭제할 문자 플래그 자동으로 초기화, ASCII를 가정하고 크기를 128로 지정
		boolean[] flags = new boolean[128];
		
		// 모든 문자에 대해서 플래그 설정
		for(src=0 ; src < r.length ; src++) {
			flags[r[src]] = true;
		}
		
		// 모든 문자에 대해 반복문을 돌리면서 플래그가 true가 아닐 때만 복사함
		for(src=0 ; src < r.length ; src++) {
			if(!flags[s[src]]) {
				s[dst++] = s[src];
			}
		}
		
		
		return new String(s, 0 ,dst);
	}

}

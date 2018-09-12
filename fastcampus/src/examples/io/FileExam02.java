package examples.io;

import java.io.File;

public class FileExam02 {

	public static void main(String[] args) {
		File file = new File(".");  // 현재경로 
		// 절대경로를 출력한다.
		// 절대경로는 /로 시작(Mac). 윈도우는 드라이브명.
		System.out.println(file.getAbsolutePath());

	}

}

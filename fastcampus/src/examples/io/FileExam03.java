package examples.io;

import java.io.File;

// 현재경로의 파일 목록들을 출력한다.
public class FileExam03 {

	public static void main(String[] args) {
		File file = new File(".");
		File[] files = file.listFiles();
		for(File f : files) {
			if(f.isDirectory()) {
				System.out.println("[DIR] " + f.getAbsolutePath());
			}else {
				System.out.println(f.length());
				System.out.println(f.getAbsolutePath());
			}
		}

	}

}

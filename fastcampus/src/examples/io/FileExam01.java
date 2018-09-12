package examples.io;

import java.io.File;

public class FileExam01 {

	public static void main(String[] args) {
		
		String fileName = File.separator + "Users" + File.separator + "choijaeyong" + File.separator + "Documents" + File.separator + "dfdf.csv";
		File file = new File(fileName);
		
		if(file.exists()) {
			System.out.println(fileName + "이 존재합니다.");
		}

	}

}

package examples.io;

import java.io.File;

public class FileExam04 {

	public static void main(String[] args) {
		File file = new File("/tmp/a/b/c");
		if(!file.exists()) {  // 존재하지 않는다면
			file.mkdirs(); // 최하위 폴더까지 생성해준다.
		}

	}

}

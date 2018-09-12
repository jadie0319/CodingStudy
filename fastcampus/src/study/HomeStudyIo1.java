package study;

import java.io.File;

/*
 * 1. 현재 디렉토리 이하의 파일들을 탐색하여 전체 파일 크기의 합을 출력하시오.
 * 	현재 디렉토리. File(".")
 * 	File[] files = file.listFiles();
 */

public class HomeStudyIo1 {
	static int capacity = 0;

	public static void fileBrowse(File file) {
        File[] files = file.listFiles();
        if(files.length == 0) {
            System.out.println("비었습니다.");
            return;
        } else {
            for(int i=0; i < files.length ; i++) {
                if(files[i].isDirectory()) {
                    fileBrowse(files[i]);
                } else if(files[i].isFile()) {
                    capacity += files[i].length();
                }

            }
        }

    }
	
	
	public static void main(String[] args) {
		File file = new File(".");
		File[] files = file.listFiles();

        for(File f : files) {
            if(f.isDirectory()) {
                System.out.println("[DIR] " + f.getAbsolutePath());
            } else {
                System.out.println(f.getAbsolutePath());
            }
        }

        fileBrowse(file);
        System.out.println(capacity);
	}

}

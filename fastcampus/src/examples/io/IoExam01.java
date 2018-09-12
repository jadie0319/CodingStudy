package examples.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 1바이트씩 읽어서 1바이트씩 쓴다.
public class IoExam01 {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		
		try {
			File file = new File("/Users/choijaeyong/Documents/dfdf.csv");
			if(!file.isDirectory() && file.exists()) {
				in = new FileInputStream(file);
				out = new FileOutputStream("/tmp/dfdf.out");
				int readData=0;
				while((readData = in.read()) != -1) {
					out.write(readData);
				}
			}
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				in.close();
			} catch(IOException ex) {}
			
			try {
				out.close();
			} catch(IOException ex) {}
		}
		

	}

}

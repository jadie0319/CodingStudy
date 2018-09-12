package examples.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// [] 로 읽어서 [] 쓴다.
public class IoExam02 {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		
		try {
			File file = new File("/Users/choijaeyong/Documents/dfdf.csv");
			if(!file.isDirectory() && file.exists()) {
				in = new FileInputStream(file);
				out = new FileOutputStream("/tmp/dfdf2.out");
				
				byte[] buffer = new byte[1024];
				int readCount =0;
				while((readCount = in.read(buffer)) != -1) {
					out.write(buffer, 0, readCount);
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

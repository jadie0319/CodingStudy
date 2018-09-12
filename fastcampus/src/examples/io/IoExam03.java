package examples.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class IoExam03 {
	// main 메소드에서 Exception 을 발생해도 무시하려면 throws Exception 을 붙인다.
	public static void main(String[] args) throws Exception {
		String str = "hello world!";
		byte[] buffer = str.getBytes();
		
		InputStream in = new ByteArrayInputStream(buffer);
		OutputStream out = new FileOutputStream("/tmp/buffer.txt");
		
		CopyUtil.copy(in, out);
		
		InputStream in2 = new FileInputStream("/tmp/buffer.txt");
		OutputStream out2 = new ByteArrayOutputStream();
		
		CopyUtil.copy(in2, out2);
		
		byte[] result = ((ByteArrayOutputStream)out2).toByteArray();
		String str2 = new String(result);
		System.out.println(str2);

	}

}

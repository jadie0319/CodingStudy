package study;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/*
 * 2. 특정 디렉토리 (ex: /tmp) 이하에 /tmp/2018/09/03 이라는 폴더를 생성한다. 년 월 일 폴더를 만들기!. 
 */
public class HomeStudyIo2 {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DATE);
		
		File file = new File("/tmp/" + year + "/" + month + "/" + day);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		
		
		Date today = new Date();
	    System.out.println(today);
	    
	    // 이런식으로 생성해서 해도 된다.
	        
	    SimpleDateFormat date = new SimpleDateFormat("/yyyy/MM/dd");
	    SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
	        
	    System.out.println("Date: "+date.format(today));
	    System.out.println("Time: "+time.format(today));



	}

}

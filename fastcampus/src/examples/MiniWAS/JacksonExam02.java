package examples.MiniWAS;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class JacksonExam02 {
    public static void main(String[] args) throws Exception {
        MiniWasConfiguration miniWasConfiguration =
                new MiniWasConfiguration();

        miniWasConfiguration.setStaticDir("/tmp/www");
        miniWasConfiguration.setClassPath(".");

        // 객체를 json메시지로 변환한다.( 직렬화 한다!)
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonConfiguration =
                objectMapper.writeValueAsString(miniWasConfiguration);
        System.out.println(jsonConfiguration);

        InputStream in = new ByteArrayInputStream(jsonConfiguration.getBytes());

        OutputStream out = new FileOutputStream("/tmp/exam/test.txt");
        byte[] buffer = new byte[1024];
        int readCount =0;
        while((readCount = in.read(buffer)) != -1) {
            out.write(buffer,0,readCount);
            out.flush();
        }

        InputStream in2 = new FileInputStream("/tmp/exam/test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in2));

        String line = null;
        while((line = br.readLine()) != null) {
            System.out.println("읽어와서 출력! : " + line);
        }





    }
}

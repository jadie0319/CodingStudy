package examples.MiniWAS;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private InputStream in;
    private BufferedReader br;
    private String httpMethod;
    private String httpPath;
    private Map<String,String> headers;

    public Request(InputStream in , BufferedReader br) {
        this.in = in;
        this.br = br;
        headers = new HashMap<>();

        try {
            String requestLine = br.readLine();
            System.out.println("요청라인 : " + requestLine);
            String[] requestLines = requestLine.split(" ");
            if(requestLines.length > 2) {
                httpMethod = requestLines[0];
                httpPath = requestLines[1];
            }

            String headerLine = null;
            String key = null;
            String value = null;
            while((headerLine = br.readLine() ) != null) {
                if(headerLine.equals("")) {
                    break;
                }
                System.out.println("Header : " + headerLine);

                int idx = headerLine.indexOf(':');
                if(idx != -1) {
                    key = headerLine.substring(0,idx);
                    value = headerLine.substring(idx+1).trim();
                }
                headers.put(key,value);
            }


        }catch(Exception ex) {
            throw new RuntimeException("잘못된 요청 : " + ex.toString());
        }





    }


    public InputStream getIn() {
        return in;
    }

    public BufferedReader getBr() {
        return br;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getHttpPath() {
        return httpPath;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}

package examples.MiniWAS;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class DefaultServlet {

    public void service(Request req , Response res) {

        // 응답!
        String webpath = req.getHttpPath();
        if("/".equals(webpath)) {
            webpath = webpath + "index.html";
        }

//        String path = "/Users/choijaeyong/wasfolder" + webpath;
//        String path = "/tmp/www" + webpath;

        MiniWasConfigurationManager wcm = MiniWasConfigurationManager.getInstance();
        MiniWasConfiguration miniWasConfiguration = wcm.getMiniWasConfiguration("/tmp/m.json");
        String path = miniWasConfiguration.getStaticDir() + webpath;
        System.out.println("path = "+path);

        File file = new File(path);
        res.setContentLength(file.length());

        OutputStream out = res.getOut();
        PrintWriter pw = res.getPw();

        if(file.exists()) {
            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("Content-Length: " + file.length());
            pw.println("");
            pw.flush();


            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int readCount =0;
                while((readCount = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, readCount );
                    out.flush();
                }


            }catch(Exception ex) {
                System.out.println("DefaultServlet Error : " + ex.getMessage());
            }finally {
                try {
                    fis.close();
                }catch(Exception e){}
            }

        } else {
            pw.println("HTTP/1.1 404 NOT FOUND");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("");
            pw.flush();

        }
    }

}

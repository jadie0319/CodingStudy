package main.java.my.examples.mywas;

public abstract class HttpServlet {
    public void init() {

    }

    public void doGet(Request req , Response resp) {

    }

    public void doPost(Request req , Response resp) {

    }

    public void destroy() {

    }

    public void service(Request req , Response resp) {
        if("GET".equals(req.getHttpPath().toUpperCase())) {
            doGet(req,resp);
        } else if("POST".equals(req.getHttpPath().toUpperCase())){
            doPost(req,resp);
        }

    }




}

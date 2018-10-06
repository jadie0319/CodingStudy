package main.java.my.examples.mywas;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ClassLoaderTest07 {
    public static void main(String[] args) {
        String baseDir = "/Users/choijaeyong/fastcampus/git/mywas/target/classes/";
        WebServletMapperManager wsmm = new WebServletMapperManager();
        Map<String , Class> map = wsmm.findServlet(baseDir);

        Set<String> paths = map.keySet();
        for(String path : paths) {
            System.out.println(path + " : " + map.get(path).getName());
        }
    }
}

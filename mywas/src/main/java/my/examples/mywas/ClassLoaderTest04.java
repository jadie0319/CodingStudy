package main.java.my.examples.mywas;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// 내 방식. 내가 만든거.

public class ClassLoaderTest04 {
    public static void main(String[] args) throws Exception {
        URL url = ClassLoader.getSystemResource(".");
        System.out.println(url);

        Class<?> c = Main.class;
        String path = c.getResource(c.getSimpleName() + ".class").getPath().replace(c.getSimpleName() + ".class", "");

        System.out.println("file:" + path);

        File f = new File(path);
        File[] files = f.listFiles();

        System.out.println(files.length);
        List<String> classList = new ArrayList<>();

        for(int i=0; i < files.length ; i++) {
            String result= path;
            result = files[i].getPath().substring(path.length());

            int lastIdx = result.lastIndexOf('.');
            result = result.substring(0,lastIdx);
            classList.add(result);

            System.out.println(result);
        }









    }

}

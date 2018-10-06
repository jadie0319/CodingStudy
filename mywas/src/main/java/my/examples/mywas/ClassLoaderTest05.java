package main.java.my.examples.mywas;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderTest05 {
    private static String baseDir = "/DEVEL/fastcampus2/miniwas/target/classes/";
    public static void main(String[] args) throws Exception{
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources =
                contextClassLoader.getResources("");
        while(resources.hasMoreElements()){
            URL url = resources.nextElement();
            File root = new File(url.getPath());
            if(root.isDirectory()){
                printDirectory(root);
            }else{
                printFile(root);
            }
        }
    } // main
    public static void printDirectory(File file){
        File[] files = file.listFiles();
        for(File f : files){
            if(f.isDirectory()){
                printDirectory(f);
            }else{
                printFile(f);
            }
        }
    }
    public static void printFile(File file){
//        System.out.println(file.getPath());
        printClassName(file.getPath());
    }
    public static void printClassName(String path){
        path = path.substring(baseDir.length());
        path = path.replace('/', '.');
        int lastIndex = path.lastIndexOf('.');
        path = path.substring(0, lastIndex);
        System.out.println(path);
    }
}

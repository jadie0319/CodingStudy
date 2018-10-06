package main.java.my.examples.mywas;

import java.lang.annotation.Annotation;
import java.util.List;

public class ClassLoaderTest06 {
    public static void main(String[] args) throws Exception{
        String baseDir = "/Users/choijaeyong/fastcampus/git/mywas/target/classes/";
        ClassFinder classFinder = new ClassFinder(baseDir);
        List<String> allClass =
                classFinder.findAllClass();
        for(String className : allClass){
            System.out.println(className);
        }

        System.out.println("======================================================");

        for(String className : allClass) {
            Class clazz = Class.forName(className);
            Annotation annotation = clazz.getAnnotation(WebServlet.class);
            if(annotation != null) {
                // WebServlet 의 value값을 출력한다.
                System.out.println("annotation 이 있는 클래스 : "+className + " annotation : " + annotation);
                WebServlet webServlet = (WebServlet)annotation;
                String value = webServlet.value();
                System.out.println(className + " : " + value);

            }
        }


    } // main
}

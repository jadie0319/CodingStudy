package examples.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam02 {
    public static void main(String[] args) {
        // 우리가 스프링 컨테이너라고 말하는 녀석은 applicationContext.xml 을 말한다.
        // ApplicationContext 는 인터페이스다.

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(JavaConfig.class);

        MyBean2 myBean2 = applicationContext.getBean(MyBean2.class);

        System.out.println(myBean2.getName());

    }
}

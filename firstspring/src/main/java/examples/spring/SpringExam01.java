package examples.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) {
        // 우리가 스프링 컨테이너라고 말하는 녀석은 applicationContext.xml 을 말한다.
        // ApplicationContext 는 인터페이스다.

        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("applicationContext.xml");

        MyBean myBean = (MyBean)applicationContext.getBean(MyBean.class);
        myBean.print();

        MyBean myBean1 = applicationContext.getBean(MyBean.class);
        myBean1.print();

        if(myBean == myBean1) {
            System.out.println("myBean == myBean1");
        }
    }
}

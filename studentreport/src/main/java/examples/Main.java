package examples;

import examples.controller.MainController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // MainController 와 의존관계

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(StudentConfig.class);
        MainController mainController = applicationContext.getBean(MainController.class);
        mainController.control();

    }
}

package examples;


import examples.controller.MainController;
import examples.controller.UI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    UI ui() {
        return new UI();
    }

    @Bean
    MainController control(UI ui) {
        MainController control = new MainController();
        control.setUI(ui);
        return control;
    }

}

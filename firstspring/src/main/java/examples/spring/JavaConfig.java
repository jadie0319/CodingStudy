package examples.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public MyBean2 myBean2Class() {
        return new MyBean2();
    }

}

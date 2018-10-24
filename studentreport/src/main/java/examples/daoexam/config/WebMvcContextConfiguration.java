package examples.daoexam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"examples.daoexam.controller"})
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {

    // 정적데이터를 외부에 어떤 path로 제공할 것이냐 하는 설정을 한다.
    // src/main/webapp/img/github.gif 가 있을경우 아래와 같이 설정하면
    // <img src="/imges/github.gif">
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/css").setCachePeriod(31556926);
        registry.addResourceHandler("/images/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }


    // default servlet handler 을 사용하게 합니다.
    // / 요청은 WAS가 가지고 있는 default servlet 이 처리한다.
    // DispatcherServlet 이 Controller를 호출해서 url을 처리하는데 요청받은 url을 처리할 Controller가 없으면
    // 디폴트 서블렛이에게 해당 url을 처리해달라고 요청한다.
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    // viewresolver 설정
    // InternalResourceViewResolver 는 ViewResolver중에 한가진데, 어떤 jsp를 사용할지 전략을 세워준다.
    // 사용자가 Controller에서 view name을 리턴하면, Dispatcher 서블릿은
    // ViewResolver에게 해당 view 를 통하여 어떤 View를 사용할지 물어보게 되어 있다.
    // /WEB-INF/views/ + view name + .jsp 라는 경로의 jsp를 사용하게 해준다.
    // 해당 정보를 이용하여 JstlView 라는 객체를 생성하여 jsp를 보여주게 된다.
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }







}

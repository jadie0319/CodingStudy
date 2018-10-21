package examples;


import examples.book.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam07 {
    // 01~06 은 다른 프로젝트에! streo-xmlconfig

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BookConfig.class);
        BookService bookService = context.getBean(BookService.class);
        bookService.service();
    }


}

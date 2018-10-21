package examples.book;

import org.springframework.stereotype.Component;

@Component
public class BookDao {
    // 수업시간에 한 내용
    public BookDao() {
        System.out.println("BookDao()");
    }

    public void crud() {
        System.out.println("crud");
    }

}

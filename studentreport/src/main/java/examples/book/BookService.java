package examples.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    // 수업시간에 한 내용.

    @Autowired
    private BookDao bookDao;

//    public BookService(BookDao bookDao) {
//        this.bookDao = bookDao;
//        System.out.println("BookService 생정자 BookDao()");
//    }

    public void service() {
        bookDao.crud();
    }
}

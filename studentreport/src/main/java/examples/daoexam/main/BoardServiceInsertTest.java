package examples.daoexam.main;

import examples.daoexam.config.ApplicationConfig;
import examples.daoexam.dto.Board;
import examples.daoexam.service.BoardService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;

public class BoardServiceInsertTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext ac =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

		BoardService boardService = ac.getBean(BoardService.class);

//		Board board = new Board();
//		board.setContent("hello");
//		board.setName("kim");
//		board.setReadCount(0);
//		board.setRegdate(new Date()); // java.Util
//		board.setTitle("title!");
//
//		Board result = boardService.addBoard(board);
//		System.out.println(result);

		List<Board> list = boardService.getBoards(1,10);
//		System.out.println(list.size());
		for(Board board : list ) {
			System.out.println(board);
		}


    }
}

package examples.daoexam.service;

import examples.daoexam.dao.BoardDao;
import examples.daoexam.dto.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl  implements BoardService{

    // @Autowired 를 붙이던가
    // 생성자를 통해 주입 하던가. 둘중에 하나만 하면 된다
    // 여기에선 생성자를 통한 주입.

    private BoardDao boardDao;

    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    @Transactional
    public Board addBoard(Board board) {
        // board 정보를 저장. id값은 저장시 자동으로 생성된다.
        Long id = boardDao.addBoard(board);
        board.setId(id);

        return board;
    }

    @Override
    @Transactional
    public Board getBoard(Long id) {

        // readcount 를 수정해줘야 한다. 그래서 트랜잭션 처리해!
        boardDao.updateCount(id);

        // 1건 읽어오고.
        Board board = boardDao.getBoard(id);


        return board;
    }







    @Override
    @Transactional(readOnly = true)
    public List<Board> getBoards(int start, int limit) {
        List<Board> boards = boardDao.getBoards(start,limit);
        return boards;
    }



}

/*
create table board (
    id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    title varchar(255) not null,
    name varchar(255) NOT NULL,
    content text,
    regdate datetime,
    read_count int,
    primary key(id)
);

 */
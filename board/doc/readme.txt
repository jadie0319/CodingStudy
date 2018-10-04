게시판 만들기 시작!

localhost:8080/

/board/list : 전체 리스트.
/board/write : 글쓰기.
/board/delete + 게시판번호 : 글삭제.
/board/update + 게시판번호: 글 수정

DB 연동하기
db : boardexam  --- complete
table : board    -- not yet



/board/list
글쓰기 버튼만들기.


04/10/18 우선순위
table 만들기.

CREATE TABLE user (
  id varchar(15) not null primary key,
  password varchar(15) not null,
  nick varchar(30) not null
);

CREATE TABLE board (
  boardnum bigint(30) unsigned not null auto_increment primary key ,
  title varchar(50) not null ,
  content text,
  userid varchar(15),
  regdate datetime,
  constraint board_userid_fk foreign key (userid) references user (id)
);
/* boardnum 1부터 재정렬하는 query~ */
alter table board auto_increment=1;
set @count=0;
update board set board.boardnum=@count:=@count+1;





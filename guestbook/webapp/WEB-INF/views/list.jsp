<%--
  Created by IntelliJ IDEA.
  User: choijaeyong
  Date: 02/10/2018
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>list</h1>
    <a href="/guestbook/login">관리자 로그인</a>
    <a href="/guestbook/logout">관리자 로그아웃</a>
    <br><br>




    <h1> List </h1>
    <form method="post" action="/guestbook/write">
        이름 : <input type="text" name="name"><br>
        내용 : <br>
        <textarea name="content" id="content" cols="30" rows="10"></textarea>
        <input type="submit" value="제출">
    </form>


    <!-- 방명록 목록을 출력한다. -->
    이름 : 홍길동 <br>
    내용 : 자바가 ... <br>
    <a href="/guestbook/delete?id=1">삭제</a><br><br>
    이름 : 고길동 <br>
    내용 : 하하  ... <br>
    <a href="/guestbook/delete?id=2">삭제</a><br>

</body>
</html>

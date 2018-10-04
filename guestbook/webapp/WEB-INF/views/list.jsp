<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:if test="${sessionScope.admin != 'true'}">
        <a href="/guestbook/login">관리자 로그인</a>
    </c:if>
    <c:if test="${sessionScope.admin == 'true'}">
        <a href="/guestbook/logout">관리자 로그아웃</a>
    </c:if>

    <br><br>

    방명록 건수 : ${ guestbookSize } <br>


    <h1> List </h1>
    <form method="post" accept-charset="UTF-8"   action="/guestbook/write">
        이름 : <input type="text" name="name"><br>
        내용 : <br>
        <textarea name="content" id="content" cols="30" rows="10"></textarea>
        <input type="submit" value="제출">
    </form>


    <!-- 방명록 목록을 출력한다. -->
    <c:forEach items="${requestScope.guestbookList}" var = "guestbook">
        이름 : ${guestbook.name} <br>
        내용 : ${guestbook.content} <br>
        <c:if test="${sessionScope.admin == 'true'}">
            <a href="/guestbook/delete?id=${guestbook.id}">삭제</a><br><br>
        </c:if>

    </c:forEach>


</body>
</html>

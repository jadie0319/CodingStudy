<%--
  Created by IntelliJ IDEA.
  User: choijaeyong
  Date: 24/10/2018
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>list</title>
</head>
<body>
<h1>list</h1>
<br>
<c:forEach items="${boards}" var="board">
    ${board.title}<br>
</c:forEach>
<br>
<a href="/boards/writeform">글쓰기</a>
</body>
</html>
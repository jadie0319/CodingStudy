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
    <title>writeform</title>
</head>
<body>
<h1>writeform</h1>
<br>
<form method="post" action="/boards">
    name : <input type="text" name="name"><br>
    title : <input type="text" name="title"><br>
    content : <textarea name="content" cols="50" rows="6"></textarea>
    <br>
    <input type="submit">
</form>
</body>
</html>

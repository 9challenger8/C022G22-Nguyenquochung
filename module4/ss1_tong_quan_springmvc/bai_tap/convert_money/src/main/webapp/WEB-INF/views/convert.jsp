<%--
  Created by IntelliJ IDEA.
  User: ASUS-PRO
  Date: 15/06/2022
  Time: 4:15 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Chuyển Đổi Tiền Tệ </h2>
<form method="get" action="/convert">
VND:
<input name="num1" type="text" placeholder="enter value. . .">
<br>
USA:
<input name="num2" type="text" value="${result}">
    <br>
    <button type="submit">Convert</button>
</form>
</body>
</html>

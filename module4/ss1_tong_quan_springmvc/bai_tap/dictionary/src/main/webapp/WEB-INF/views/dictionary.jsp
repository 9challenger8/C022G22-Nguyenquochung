<%--
  Created by IntelliJ IDEA.
  User: ASUS-PRO
  Date: 15/06/2022
  Time: 7:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Dictionary Pro Max</h2>
<form action="/translate" method="get">
    <div>
        English:
        <input type="text" name="word1" >
    </div>
    <div>
        Vietnamese:
        <input type="text" name="word2" value="${word}">
    </div>
    <div>
        <button>Translate</button>
    </div>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ASUS-PRO
  Date: 30/05/2022
  Time: 9:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th> Name Customer</th>
        <th> Birthday</th>
        <th> Address</th>
        <th> Picture</th>
    </tr>

    <c:forEach var="temp" items="${listCustomer}">
        <tr>
            <td>${temp.name}</td>
            <td>${temp.date}</td>
            <td>${temp.address}</td>
            <td><img src="${temp.img}"></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>

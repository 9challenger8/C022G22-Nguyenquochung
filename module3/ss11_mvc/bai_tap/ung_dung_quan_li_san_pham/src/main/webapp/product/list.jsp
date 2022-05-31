<%--
  Created by IntelliJ IDEA.
  User: ASUS-PRO
  Date: 31/05/2022
  Time: 2:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh Sách Sản Phẩm</title>
</head>
<body>
<h1>Danh Sách Sản Phẩm</h1>
<a href="/products?action=create">Create new product</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Detail</th>
        <th>Producer</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="temp" items="${products}">
        <tr>
            <td><a href="/products?action=view&id=${temp.getID()}">${temp.getID()}</a></td>
            <td>${temp.getName()}</td>
            <td>${temp.getPrice()}</td>
            <td>${temp.getDetail()}</td>
            <td>${temp.getProducer()}</td>
            <td><a href="/products?action=edit&id=${temp.getID()}">edit</a></td>
            <td><a href="/products?action=delete&id=${temp.getID()}">delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

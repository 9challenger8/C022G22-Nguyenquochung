<%--
  Created by IntelliJ IDEA.
  User: ASUS-PRO
  Date: 19/06/2022
  Time: 7:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p style="color: green">${medical.name}</p>
<p style="color: green">${medical.id}</p>
<p style="color: green">${medical.yearOfBirth}</p>
<p style="color: green">${medical.gender}</p>
<p style="color: green">${medical.vehicle}</p>
<p style="color: green">${medical.numberVehicle}</p>
<p style="color: green">${medical.numberSeat}</p>
<p style="color: green">${medical.desc}</p>
<div style="display: flex">
    <p style="color: green">${medical.dayStart}</p>
    <p style="color: green;margin: 15px">${medical.monthStart}</p>
    <p style="color: green;margin: 15px">${medical.yearStart}</p>
</div>
<div style="display: flex">
    <p style="color: green;">${medical.dayEnd}</p>
    <p style="color: green;margin: 15px">${medical.monthEnd}</p>
    <p style="color: green;margin: 15px">${medical.yearEnd}</p>
</div>


<a href="/medical">Return</a>
</body>
</html>

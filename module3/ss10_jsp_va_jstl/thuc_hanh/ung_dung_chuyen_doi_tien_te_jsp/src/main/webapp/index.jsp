<%--
  Created by IntelliJ IDEA.
  User: ASUS-PRO
  Date: 30/05/2022
  Time: 10:52 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency Converter</title>
  </head>
  <body>
    <h2> Currency Converter </h2>
    <form action="converter.jsp" method="get">
      <label>Rate: </label><br/>
      <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
      <label>USD: </label><br/>
      <input type="text" name="usd" placeholder="USD" value="0"/><br/>
      <input type = "submit" id = "submit" value = "Converter"/>
    </form>
  </body>
</html>

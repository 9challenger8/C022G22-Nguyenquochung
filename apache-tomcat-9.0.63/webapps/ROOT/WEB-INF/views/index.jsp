<%--
  Created by IntelliJ IDEA.
  User: ASUS-PRO
  Date: 16/06/2022
  Time: 4:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Calculator ProMax</h1>
<form action="/calculator">
  <input type="text" name="num1">
  <input type="text" name="num2">
  <button type="submit">Addition(+)</button>
  <button type="submit">Subtraction(-)</button>
  <button type="submit">Multiplication(*)</button>
  <button type="submit">Division(/)</button>
</form>

  <h2>Result Division:${div1}</h2>
  <h2>Result Addition:${sum}</h2>
  <h2>Result Subtraction:${sub}</h2>
  <h2>Result Multiplication:${mul}</h2>


  </body>
</html>

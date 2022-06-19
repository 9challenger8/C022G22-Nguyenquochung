<%--
  Created by IntelliJ IDEA.
  User: ASUS-PRO
  Date: 17/06/2022
  Time: 2:33 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form:form action="/update" modelAttribute="emailConfiguration" method="post">
    <form:label path="languages">Languages:</form:label>
    <form:select path="languages" >
      <form:option value="English">English</form:option>
      <form:option value="Japanese">Japanese</form:option>
      <form:option value="Chinese">Chinese</form:option>
      <form:option value="Vietnamese">Vietnamese</form:option>
    </form:select><br>
    <form:label path="pageSize">Page size:</form:label>
    <form:select path="pageSize" >
      <form:option value="5">5</form:option>
      <form:option value="10">10</form:option>
      <form:option value="15">15</form:option>
      <form:option value="25">25</form:option>
      <form:option value="25">25</form:option>
      <form:option value="50">50</form:option>
      <form:option value="100">100</form:option>
    </form:select><br>
    <form:checkbox path="spamFilter" id="1"/>
    <form:label path="spamFilter" for="1">Enable spam filters</form:label>
    <br>
    <form:label path="signature">Signature:</form:label>
    <form:textarea path="signature"/><br>
      <button> Update</button>
      <button type="reset"> Reset</button>
  </form:form>

  <p>${languages}</p>
  <p>${pageSize}</p>
  <p>${spamFilter}</p>
  <p>${signature}</p>




  </body>
</html>

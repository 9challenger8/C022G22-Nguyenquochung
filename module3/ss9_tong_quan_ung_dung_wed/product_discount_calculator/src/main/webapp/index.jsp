<%--
  Created by IntelliJ IDEA.
  User: ASUS-PRO
  Date: 30/05/2022
  Time: 12:14 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <form method="post" action="/calculator">
    <div class="product-discount">
      <label>Product Description: </label><br/>
      <textarea name="productDescription" placeholder="Enter your Product Description: "></textarea>
      <br>
      <label>List Price: </label><br/>
      <input type="text" name="listPrice" placeholder="Enter your List Price: "/>
      <br>
      <label>Discount Percent: </label><br/>
      <input type="text" name="discountPercent" placeholder="Enter your Discount Percent: "/>
      <br>
      <input type="submit" name="Calculate Discount" value="calculate">
    </div>
  </form>
</html>

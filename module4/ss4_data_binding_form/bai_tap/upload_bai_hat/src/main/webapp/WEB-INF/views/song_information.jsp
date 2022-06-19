<%--
  Created by IntelliJ IDEA.
  User: ASUS-PRO
  Date: 19/06/2022
  Time: 8:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>



<form:form action="/display" method="post" modelAttribute="song">
    <h1>Settings</h1>
    <fieldset>
        <legend> The song</legend>
        <table>
            <tr>
                <td>The Song</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Author</td>
                <td><form:input path="author"/></td>
            </tr>
            <tr>
                <td><b>Category</b></td>
                <td>
                    <form:select path="category">
                        <form:option value="Rap"> Rap</form:option>
                        <form:option value="UK"> UK</form:option>
                        <form:option value="US"> US</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><b>Link  </b></td>
                <td>
                    <form:select path="link">
                        <form:option value="https://www.youtube.com/watch?v=GMJqYncDJOs"> Hoa vàng trên cỏ xanh</form:option>
                        <form:option value="https://www.youtube.com/watch?v=XaxjJRZ28ao">See You Again</form:option>
                        <form:option value="https://www.youtube.com/watch?v=E5vuXFwdlT4">Tạm biệt 1 cuộc tình</form:option>
                        <form:option value="https://www.youtube.com/watch?v=PLSHmNSpfLU">Tạm biệt em</form:option>
                        <form:option value="https://www.youtube.com/watch?v=PLSHmNSpfLU">Tạm Biệt Anh</form:option>
                        <form:option value="https://www.youtube.com/watch?v=kPnIqaEP2W0"> Em ở nơi xa</form:option>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Update" class="update"/>
                    <input type="reset" value="cancel" class="update"/>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>



    <div>The song : ${songResult.name}</div>
    <div> Author : ${songResult.author}</div>
    <div>Category : ${songResult.category}</div>
    <div>Link : <iframe width="200px" height="auto" title="the song" src="${songResult.link}" allowfullscreen> </iframe> </div>


</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<form method="post">
    <fieldset>
        <legend> <h2>Edit Employee</h2></legend>

        <c:if test="${employee != null}">
            <input type="hidden" name="id" value="<c:out value='${employee.id}' />"/>
        </c:if>

        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">Name:</span>
            <input value="<c:out value='${employee.name}'/>" name="name" type="text" class="form-control" placeholder="Enter name" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon2">Birthday:</span>
            <input value="<c:out value='${employee.birthday}'/>"  name="birthday" type="date" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon3">CMND Number:</span>
            <input value="<c:out value='${employee.idCard}'/>"  name="numberCMND" type="text" class="form-control" placeholder="CMND Number" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon9">Salary:</span>
            <input value="<c:out value='${employee.salary}'/>"  name="salary" type="text" class="form-control" placeholder="Salary"
                   aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon4">Phone Number:</span>
            <input value="<c:out value='${employee.numberPhone}'/>"  name="numberPhone" type="text" class="form-control"
                   placeholder="Phone Number" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon5">Email:</span>
            <input value="<c:out value='${employee.email}'/>"  name="email" type="text" class="form-control" placeholder="Enter email" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon6">Address:</span>
            <input value="<c:out value='${employee.address}'/>"  name="address" type="text" class="form-control" placeholder="Address" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <br>
        <select value="<c:out value='${employee.position}'/>"  name="position" class="form-select" aria-label="Default select example">
            <c:forEach var="temp" items="${listPosition}">
                <option value="${temp.id}">${temp.name}</option>
            </c:forEach>
        </select><br>
        <br>
        <select value="<c:out value='${employee.educationDegree}'/>"  name="educationDegree" class="form-select" aria-label="Default select example">
            <c:forEach var="temp" items="${listEducationDegree}">
                <option value="${temp.id}">${temp.name}</option>
            </c:forEach>
        </select><br>
        <br>
        <select value="<c:out value='${employee.division}'/>"  name="division" class="form-select" aria-label="Default select example">
            <c:forEach var="temp" items="${listDivision}">
                <option value="${temp.id}">${temp.name}</option>
            </c:forEach>
        </select><br>
        <button type="submit" class="btn btn-primary">Save</button>
        <a href="/employees">Back </a>
    </fieldset>
</form>









<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
</body>
</html>


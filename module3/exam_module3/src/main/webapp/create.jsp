<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS-PRO
  Date: 12/06/2022
  Time: 11:44 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
    <link href="form.css" rel="stylesheet">
</head>
<body>

<div class="form_input">
    <div class="form_input_left"></div>
    <div class="form_input_mid">
        <form method="post">
            <h2 style="text-align: center">Create </h2>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">Id:</span>
                <input name="id" type="text" class="form-control" placeholder="Enter name" aria-label="Username"
                       aria-describedby="basic-addon1">
            </div>
            <select name="idTrangThai" class="form-select" aria-label="Default select example">
                <option value="">Choose Trang Thai</option>
                <c:forEach var="temp" items="${listTrangThai}">
                    <option value="${temp.id}">${temp.name}</option>
                </c:forEach>
            </select>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon3">Dien tich</span>
                <input name="dienTich" type="text" class="form-control" placeholder="CMND Number"
                       aria-label="Username" aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon9">Tang:</span>
                <input name="tang" type="text" class="form-control" placeholder="Salary"
                       aria-label="Username" aria-describedby="basic-addon1">
            </div>
            <select name="idLoaiMatBang" class="form-select" aria-label="Default select example">
                <option value="">Choose Trang Thai</option>
                <c:forEach var="temp" items="${listLoaiMatBang}">
                    <option value="${temp.id}">${temp.name}</option>
                </c:forEach>
            </select>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon5">Gia:</span>
                <input name="gia" type="text" class="form-control" placeholder="Enter email" aria-label="Username"
                       aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon6">Ngay bat dau:</span>
                <input name="ngayBatDau" type="date" class="form-control" placeholder="Address" aria-label="Username"
                       aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon90">Ngay ket thuc:</span>
                <input name="ngayKetThuc" type="date" class="form-control" placeholder="Address" aria-label="Username"
                       aria-describedby="basic-addon1">
            </div>
            <div style="display: flex;justify-content: center">
                <button type="submit" class="btn btn-success">Save</button>
                <a style="margin-left : 40px" class="btn btn-primary" href="/matbang" role="button">Back</a>
            </div>
        </form>
    </div>
    <div class="form_input_right"></div>
</div>



<script src="https://code.jquery.com/jquery-2.2.4.min.js"
        integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
        integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
        crossorigin="anonymous"></script>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>

<script>
    $(document).ready(function (){
        $('#tableCustomer').dataTable({
            "dom" : 'lrtip',
            "lengthChange":false,
            "pageLength": 8
        });
    });
</script>
</body>
</html>

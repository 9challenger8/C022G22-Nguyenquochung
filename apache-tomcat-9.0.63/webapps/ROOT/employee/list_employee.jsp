<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
    <link href="home.css" rel="stylesheet">
</head>
<body>

<div class="header">
    <a href="http://localhost:8080/"><img class="logo"
                                           src="https://static.vecteezy.com/system/resources/previews/005/947/068/original/wood-house-logo-design-indigeneous-village-logo-vector.jpg"></a>
    <h2>FURAMA</h2>
</div>

<div class="navigation" style="border: 1px solid #b3d7ff">
    <nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="http://localhost:8080/">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse d-flex justify-content-between" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="/customers" id="navbarDropdown1" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Customer
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/customers?action=create">Add New</a></li>

                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="/employees" id="navbarDropdown2" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Employee
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/employees?action=create">Add New Employee</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Service
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contract</a>
                    </li>
                </ul>

            </div>

        </div>
    </nav>
</div>


<div class="content">

    <div class="content-left">

    </div>


    <div class="content-right">
        <div style="display: flex;justify-content: space-between;align-items: center">
            <a href="/employees"><h2 style="margin-left: 15px;color: blue">List employee:</h2></a>
            <form method="post" action="/employees?action=search" class="d-flex" role="search">
                <input name="search" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button style="margin-right: 20px" class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>

        <table class="table table-striped table-bordered" id="tableCustomer" style="width: 100%">

            <thead>

            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>CMND Numbers</th>
                <th>Salary</th>
                <th>Numbers Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Position</th>
                <th>Education Degree</th>
                <th>Division</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="temp" items="${listEmployee}">
                <tr>
                    <td><c:out value="${temp.getId()}"/></td>
                    <td><c:out value="${temp.getName()}"/></td>
                    <td><c:out value="${temp.getBirthday()}"/></td>
                    <td><c:out value="${temp.getIdCard()}"/></td>
                    <td><fmt:formatNumber pattern="#" value="${temp.salary}"/></td>
                    <td><c:out value="${temp.getNumberPhone()}"/></td>
                    <td><c:out value="${temp.getEmail()}"/></td>
                    <td><c:out value="${temp.getAddress()}"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${temp.position==1}">Lễ Tân</c:when>
                            <c:when test="${temp.position==2}">Phục vụ</c:when>
                            <c:when test="${temp.position==3}">Chuyên viên</c:when>
                            <c:when test="${temp.position==4}">Giám sát</c:when>
                            <c:when test="${temp.position==5}">Quản lý</c:when>
                            <c:when test="${temp.position==6}">Giám đốc</c:when>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${temp.educationDegree==1}">Trung cấp</c:when>
                            <c:when test="${temp.educationDegree==2}">Cao Đẳng</c:when>
                            <c:when test="${temp.educationDegree==3}">Đại Học</c:when>
                            <c:when test="${temp.educationDegree==4}">Sau Đại Học</c:when>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${temp.division==1}">Sale-Marketing</c:when>
                            <c:when test="${temp.division==2}">Hành chính</c:when>
                            <c:when test="${temp.division==3}">Phục vụ</c:when>
                            <c:when test="${temp.division==4}">Quản lý</c:when>
                        </c:choose>
                    </td>

                    <td><a href="/employees?action=edit&id=${temp.getId()}">Edit</a></td>

                    <td><a style="cursor: pointer;color: #005cbf"  data-bs-toggle="modal"  data-bs-target="#staticBackdropDelete${temp.id}">Delete</a></td>
                        <%--                    <td>--%>
                        <%--                        <button type="button" class="btn btn-danger" data-bs-toggle="modal"--%>
                        <%--                                data-bs-target="#staticBackdropDelete${temp.id}">Delete--%>
                        <%--                        </button>--%>
                        <%--                    </td>--%>
                    <!-- Modal Delete -->
                    <div class="modal fade" id="staticBackdropDelete${temp.id}" data-bs-backdrop="static"
                         data-bs-keyboard="false" tabindex="-1"
                         aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabelAddNew">Delete Employee</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="alert alert-warning">
                                        Do you want delete Employee?  Name: <strong>${temp.name}</strong>
                                         and Id: <strong>${temp.id}</strong>
                                    </div>
                                    <a href="/employees?action=delete&id=${temp.id}" class="btn btn-success">Submit</a>
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                    </button>
                                </div>
                                <div class="modal-footer"></div>
                            </div>
                        </div>
                    </div>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="footer">

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

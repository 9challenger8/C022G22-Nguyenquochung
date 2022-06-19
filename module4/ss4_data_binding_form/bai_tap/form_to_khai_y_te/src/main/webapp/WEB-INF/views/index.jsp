<%--
  Created by IntelliJ IDEA.
  User: ASUS-PRO
  Date: 19/06/2022
  Time: 3:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
        <h2 style="text-align: center">MEDICAL DECLARATION</h2>
        <h4 style="text-align: center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG,THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN
            THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM </h4>
        <H6 STYLE="text-align: center;color: red">Khai báo thông tin sai là vi phạm pháp luật, có thể vi phạm hình sự</H6>


        <form:form action="/medical" method="post" modelAttribute="medical">

            <form:label path="name" >Họ tên(ghi chữ IN HOA) (*)</form:label>
            <form:input path="name" />
            <br>
            <form:label path="yearOfBirth" >Năm sinh (*)</form:label>
            <form:select path="yearOfBirth" >
                <c:forEach var="i" begin="1700" end="2021" step="1">
                    <form:option value="${i}">${i}</form:option>
                </c:forEach>
            </form:select>
            <br>
            <form:label path="gender" >Gender (*)</form:label>
            <form:select path="gender">
                <form:option value="Nam">Nam</form:option>
                <form:option value="Nữ">Nữ</form:option>
            </form:select>
            <br>
            <form:label path="nation" >Quốc tịch (*)</form:label>
            <form:select path="nation" >
                <form:option value="Việt Nam">Việt Nam</form:option>
                <form:option value="Japan">Japan</form:option>
            </form:select>
            <br>
            <form:label path="id" >Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác (*)</form:label>
            <form:input path="id" />
            <br>
            <form:label path="vehicle" >Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác (*)</form:label>
            <br>
            <form:radiobutton path="vehicle" value="Tàu bay"/>Tàu bay
            <form:radiobutton path="vehicle" value="Tàu thuyền"/>Tàu thuyền
            <form:radiobutton path="vehicle" value="Oto"/>Oto
            <form:radiobutton path="vehicle" value="Khác(ghi rõ)"/>Khác(ghi rõ)
            <br>
            <form:label path="numberVehicle" >Số hiệu phương tiện</form:label>
            <form:input path="numberVehicle" placeholder="vd: 1234"/>
            <br>
            <form:label path="numberSeat" >Số ghế</form:label>
            <form:input path="numberSeat" />
            <br>
        <label>Ngày khởi hành (*)</label>

                <form:select path="dayStart" >
                <c:forEach var="h" begin="1" end="31" step="1">
                    <form:option value="${h}">${h}</form:option>
                </c:forEach>
                </form:select>
                <form:select path="monthStart" >
                    <c:forEach var="i" begin="1" end="12" step="1">
                        <form:option value="${i}">${i}</form:option>
                    </c:forEach>
                </form:select>
                <form:select path="yearStart" >
                    <c:forEach var="i" begin="2018" end="2022" step="1">
                        <form:option value="${i}">${i}</form:option>
                    </c:forEach>
                </form:select>
            <br>
        <label class="text-black">Ngày kết thúc (*)</label>
                <form:select path="dayEnd" >
                <c:forEach var="i" begin="1" end="31" step="1">
                    <form:option value="${i}">${i}</form:option>
                </c:forEach>
                </form:select>
                <form:select path="monthEnd" class="form-control">
                    <c:forEach var="i" begin="1" end="12" step="1">
                        <form:option value="${i}">${i}</form:option>
                    </c:forEach>
                </form:select>
                <form:select path="yearEnd" class="form-control">
                    <c:forEach var="i" begin="2018" end="2022" step="1">
                        <form:option value="${i}">${i}</form:option>
                    </c:forEach>
                </form:select>
            <br>
            <form:label path="desc" >Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào không(*)</form:label>
            <form:textarea path="desc" cols="" rows="2" />
            <br>
            <button >Xác nhận</button>
        </form:form>


</body>
</html>

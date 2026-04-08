<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Khai báo thư viện JSTL core --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <%-- Tiêu đề trang báo cáo --%>
    <title>Báo cáo điểm</title>
</head>
<body>

<%-- Sử dụng EL để hiển thị tiêu đề từ Request Attribute --%>
<h1>${reportTitle}</h1>

<%--
    Số lượt xem  được Controller xử lý và đẩy vào requestScope/applicationScope
--%>
<p>Lượt xem trang: ${totalViewCount}</p>

<table border="1">
    <thead>
    <tr>
        <th>STT</th>
        <th>Họ tên</th>
        <th>Điểm</th>
        <th>Xếp loại</th>
    </tr>
    </thead>
    <tbody>
    <%-- Dùng JSTL để duyệt danh sách sinh viên --%>
    <c:forEach var="sv" items="${studentList}" varStatus="status">
        <tr>
                <%-- Hiển thị số thứ tự (bắt đầu từ 1) --%>
            <td>${status.index + 1}</td>

                <%-- Chống XSS bằng c:out cho dữ liệu tên người dùng --%>
            <td><c:out value="${sv.fullName}" /></td>

                <%-- Hiển thị điểm số (đã xóa dấu chấm phẩy lỗi) --%>
            <td>${sv.score}</td>

                <%-- Xử lý logic xếp loại bằng c:choose thay cho if-else Java --%>
            <td>
                <c:choose>
                    <c:when test="${sv.score >= 90}">Xuất sắc</c:when>
                    <c:when test="${sv.score >= 80}">Giỏi</c:when>
                    <c:when test="${sv.score >= 70}">Khá</c:when>
                    <c:when test="${sv.score >= 60}">Trung bình khá</c:when>
                    <c:when test="${sv.score >= 50}">Trung bình</c:when>
                    <c:otherwise>Yếu</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
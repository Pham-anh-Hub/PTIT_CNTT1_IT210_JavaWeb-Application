<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 08/04/2026
  Time: 8:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Quản lý đơn hàng</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left; }
        th {
            background-color: #f2f2f2; }
        .footer {
            margin-top: 20px;
            font-weight: bold;
            color: #333;
        }
    </style>
</head>
<body>

<h2>Xin chào, ${sessionScope.staffName}!</h2>
<p>Vai trò: <strong>${sessionScope.role}</strong></p>

<hr>

<h3>Danh sách đơn hàng</h3>
<table>
    <thead>
    <tr>
        <th>Mã đơn</th>
        <th>Tên sản phẩm</th>
        <th>Tổng tiền</th>
        <th>Ngày đặt</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orderList}">
        <tr>
            <td>${order.order_id}</td>
            <td>${order.product_name}</td>
            <td>
                <fmt:formatNumber value="${order.total_amount}" type="currency" currencySymbol="VNĐ" />
            </td>
            <td>
                <fmt:formatDate value="${order.order_date}" pattern="dd/MM/yyyy" />
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="footer">
    <p>Tổng lượt xem đơn hàng toàn hệ thống: ${applicationScope.totalViewCount}</p>

    <a href="<c:url value='/logout'/>">Đăng xuất</a>
</div>

</body>
</html>

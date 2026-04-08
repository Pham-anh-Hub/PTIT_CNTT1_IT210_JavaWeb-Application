<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 08/04/2026
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Đăng nhập hệ thống</title>
    <style>
        .error-msg {
            color: red; margin-bottom: 10px; font-weight: bold;
        }
        .login-container {
            width: 300px; margin: 50px auto; border: 1px solid #ccc; padding: 20px; border-radius: 5px;
        }
        input {
            width: 100%; margin-bottom: 10px; padding: 8px; box-sizing: border-box;
        }
        button {
            width: 100%; padding: 10px; background-color: #007bff; color: white; border: none; cursor: pointer;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>Đăng nhập</h2>

    <c:if test="${not empty errorMessage}">
        <div class="error-msg">${errorMessage}</div>
    </c:if>

    <form action="<c:url value='/login'/>" method="post">
        <div>
            <label>Tài khoản:</label>
            <input type="text" name="username" required placeholder="Tên đăng nhập" />
        </div>
        <div>
            <label>Mật khẩu:</label>
            <input type="password" name="password" required placeholder="Mật khẩu" />
        </div>
        <button type="submit">Đăng nhập</button>
    </form>
</div>

</body>
</html>
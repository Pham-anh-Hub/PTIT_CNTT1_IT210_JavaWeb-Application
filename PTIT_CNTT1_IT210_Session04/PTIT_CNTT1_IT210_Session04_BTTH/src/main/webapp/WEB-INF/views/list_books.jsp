<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 09/04/2026
  Time: 8:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>

<h2>DANH SÁCH SÁCH CỦA THƯ VIỆN</h2>
<div class=".table">
    <table border="1" cellspacing="10" cellpadding="10">
        <thead>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${not empty listBook}">
                <c:forEach items="${listBook}" var="book" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td><c:out value="${book.id}"/></td>
                        <td><c:out value="${book.title}"/></td>
                        <td><c:out value="${book.author}"/></td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="4">Không có sẵn sách</td>
                </tr>
            </c:otherwise>
        </c:choose>


        </tbody>
    </table>
</div>


</body>
</html>

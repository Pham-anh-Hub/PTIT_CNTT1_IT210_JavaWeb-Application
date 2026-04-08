<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 07/04/2026
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<String> names = (List<String>) request.getAttribute("ds_ten");
%>

<%--    Sử dụng JSTL--%>
<h2>danh sach import</h2>
<c:forEach items="${ds_ten}" var="p">
    <p><c:out value="${p}"/></p>
</c:forEach>



</body>
</html>

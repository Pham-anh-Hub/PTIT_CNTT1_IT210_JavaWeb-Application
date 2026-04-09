<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 09/04/2026
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Mã sách: ${bookTarget.id}</h2>
<h1>Sách: <c:out value="${bookTarget.title}"/></h1>
<h3>Tác giả: <c:out value="${bookTarget.author}"/></h3>

</body>
</html>

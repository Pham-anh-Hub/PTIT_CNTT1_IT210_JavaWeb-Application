<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="dt" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 08/04/2026
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Tìm kiếm sự kiện</title>
    <style>
        .sold-out {
            color: red; font-weight: bold;
        }
        .low-stock {
            color: orange;
        }
        .available {
            color: green;
        }
        .badge-free {
            background-color: #28a745; color: white; padding: 2px 5px; border-radius: 4px;
        }
        .disabled-link {
            color: gray; pointer-events: none; text-decoration: none;
        }
    </style>
</head>
<body>

<div>
    <h3>Tìm kiếm</h3>
    <form action="${pageContext.request.contextPath}/events/search" method="GET">
        <label for="kw">Tên sự kiện: </label>
        <%-- Giữ lại giá trị cũ trong input bằng value="${keyword}" --%>
        <input type="text" id="kw" name="keyword"
               value="<c:out value='${keyword}'/>"
               placeholder="Nhập từ khóa tìm kiếm..." />

        <button type="submit">Tìm kiếm</button>
        <a href="${pageContext.request.contextPath}/events/search">Xóa lọc</a>
    </form>
</div>

<c:choose>
    <c:when test="${empty keyword}">
        <h2>Danh sách sự kiện</h2>
    </c:when>
    <c:otherwise>
        <h2>Kết quả tìm kiếm cho: <c:out value="${keyword}"/></h2>
        <p>Tìm thấy <strong>${totalFound}</strong> sự kiện.</p>
    </c:otherwise>
</c:choose>


<c:choose>
    <c:when test="${empty events}">
        <p>Không tìm thấy sự kiện nào phù hợp.</p>
    </c:when>
    <c:otherwise>
        <table border="1" cellpadding="10" cellspacing="0">
            <thead>
            <tr>
                <th>STT</th>
                <th>Tên sự kiện</th>
                <th>Ngày tổ chức</th>
                <th>Giá vé</th>
                <th>Vé còn lại</th>
                <th>Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="event" items="${events}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td><c:out value="${event.name}"/></td>
                    <td>${event.eventDate}</td>
                    <td>
                        <c:choose>
                            <dt:when test="${event.price == 0}">  <span class="badge-free">MIỄN PHÍ</span>
                            </dt:when>
                            <c:otherwise>
                                <fmt:formatNumber value="${event.price}" type="number"/> VNĐ
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${event.remainingTickets == 0}">
                                <span class="sold-out">HẾT VÉ</span>
                            </c:when>
                            <c:when test="${event.remainingTickets < 10}">
                                <span class="low-stock">Sắp hết (còn ${event.remainingTickets} vé)</span>
                            </c:when>
                            <c:otherwise>
                                <span class="available">${event.remainingTickets}</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:url var="bookUrl" value="/events/${event.id}/book"/>
                        <c:choose>
                            <c:when test="${event.remainingTickets == 0}">
                                <span class="disabled-link">Đặt vé</span>
                            </c:when>
                            <c:otherwise>
                                <a href="${bookUrl}">Đặt vé</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

<hr>
<div class="footer">
    <c:if test="${not empty events}">
        <p>Sự kiện nổi bật: <strong>${fn:toUpperCase(events[0].name)}</strong></p>
    </c:if>
    <p>Độ dài từ khóa: ${fn:length(keyword)} ký tự.</p>
</div>

</body>
</html>
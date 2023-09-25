<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-09-22
  Time: 오후 2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach begin="0" end="3" var="i">
    <p>${foodList[i]}</p>
</c:forEach>

<hr>

<c:forEach var="name" items="${names}">
    <p>${name}</p>
</c:forEach>

<%-- varStatus: 반복문의 상태 --%>
<c:forEach begin="0" end="3" var="n" varStatus="status">
    <p>${n}, ${status.begin}, ${status.end}, ${status.count}</p>
</c:forEach>
hr
<ul>
    <c:forEach var="food" items="${foodList}" varStatus="status">
        <li>${status.count} : ${food}</li>
    </c:forEach>
</ul>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-09-27
  Time: 오전 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Model</h1>
<c:forEach var="item" items="${items}">
    <p>${item}</p>
</c:forEach>
<hr>
<h1>Session</h1>
<c:forEach var="item" items="${sessionScope.items}">
    <p>${item}</p>
</c:forEach>
</body>
</html>

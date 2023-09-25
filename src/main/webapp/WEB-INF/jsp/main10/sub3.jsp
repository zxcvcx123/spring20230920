<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-09-22
  Time: 오후 2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="car" items="${person1.cars}">
    <h1>${car}</h1>
</c:forEach>

<hr>

<c:forEach var="food" items="${person1.foods}">
    <h1>${food}</h1>
</c:forEach>
</body>
</html>

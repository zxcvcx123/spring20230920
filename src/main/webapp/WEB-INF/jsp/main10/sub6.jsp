<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-09-22
  Time: 오후 3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="text-align: center; border: 1px solid black; margin: 5% auto; font-size: 1.5rem">
    <tr>
        <th>id</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>className</th>
        <th>phoneNumber</th>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.id}</td>
            <td>${list.firstName}</td>
            <td>${list.lastName}</td>
            <td>${list.className}</td>
            <td>${list.phoneNumber}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

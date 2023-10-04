<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-10-04
  Time: 오후 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>sub3</h1>
<h1>공급자 목록</h1>
<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PHONE</th>
    </tr>
    <c:forEach var="shippers" items="${shippers}">
        <tr>
            <td>${shippers.id}</td>
            <td>${shippers.name}</td>
            <td>${shippers.phone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

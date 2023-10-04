<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-10-04
  Time: 오후 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    *{
        margin: 5px auto;
        text-align: center;
    }
    table {
        border: 1px solid black;
    }
    th {
        border: 1px solid black;
        background: yellow;
    }
    td {
        border: 1px solid black;
    }
</style>
<body>
<h1>고객 정보</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Adress</th>
        <th>Country</th>
    </tr>
    <c:forEach var="list" items="${customerList}">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.address}</td>
            <td>${list.country}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-10-04
  Time: 오후 3:17
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
<h1>Customer Data</h1>
<table>
    <tr>
        <th>CustomerID</th>
        <th>CustomerName</th>
        <th>CustomerCity</th>
        <th>CustomerCountry</th>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.city}</td>
            <td>${list.country}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-10-06
  Time: 오전 11:51
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
<h4>조회 결과</h4>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
        </tr>
    </c:forEach>
</table>

<div>
    <c:forEach begin="1" end="${lastPageNumber}" var="pageNumber">
        <a href="/main22/sub2?p=${pageNumber}">${pageNumber}</a>
        |
    </c:forEach>
</div>
</body>
</html>

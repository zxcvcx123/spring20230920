<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-10-04
  Time: 오후 3:36
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
<h4>상품 목록</h4>
<table>
    <tr>
        <th>번호</th>
        <th>상품명</th>
        <th>단위</th>
        <th>가격</th>
    </tr>
    <c:forEach items="${productList}" var="prod">
        <tr>
            <td>${prod.pid}</td>
            <td>${prod.productName}</td>
            <td>${prod.unit}</td>
            <td>${prod.price}$</td>
        </tr>
    </c:forEach>
</table>
<a href="/main19/sub8">상품번호 조회하기</a>
</body>
</html>

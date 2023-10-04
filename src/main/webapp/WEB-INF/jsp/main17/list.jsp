<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-09-27
  Time: 오후 3:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<h3>${message}</h3>
<h1>글 목록</h1>
<table>
    <tr>
        <th>id</th>
        <th>제목</th>
    </tr>
    <c:forEach var="item" items="${postList}" varStatus="status">
        <tr>
            <td>${status.index}</td>
            <td>
                <a href="/main17/view?id=${status.index}">${item.title}</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div><a href="/main17/new">글 쓰러가기</a></div>
</body>
</html>

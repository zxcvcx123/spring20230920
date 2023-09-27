<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-09-27
  Time: 오전 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>냉장고</h1>
<c:forEach var="item" items="${food}">
    <p>${item}</p>
</c:forEach>
<a href="/main15/sub7">냉장고에 넣을 음식 고르기</a>
</body>
</html>

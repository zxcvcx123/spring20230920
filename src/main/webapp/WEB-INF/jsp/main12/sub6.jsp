<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-09-25
  Time: 오후 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty search}">
    <h3>${search} 검색 결과입니다.</h3>
</c:if>
<c:if test="${empty search}">
    <h3>검색어를 입력해 주세요.</h3>
</c:if>
<a href="/main12/sub5">다시 검색하러가기</a>
</body>
</html>

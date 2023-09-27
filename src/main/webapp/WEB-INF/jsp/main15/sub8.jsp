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
<h1>선택한 음식들</h1>
<div>
  <c:forEach var="item" items="${food}">
      <p>${item}</p>
  </c:forEach>
</div>
<a href="/main15/sub9">음식들 냉장고에 보관시키기</a>

<body>

</body>
</html>

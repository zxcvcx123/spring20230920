<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-09-27
  Time: 오후 4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <label for="titleInput">제목</label>
    <input type="text" name="title" id="titleInput" value="${post.title}" readonly>
</div>
<div>
    <input type="text" value="${post.body}" readonly></textarea>
</div>
</body>
</html>

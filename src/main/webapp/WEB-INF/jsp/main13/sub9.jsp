<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-09-26
  Time: 오후 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main13/sub10">
    <div>
        <label for="input1">제목</label>
        <input type="text" id="input1" name="title">
    </div>

    <div>
        <label for="input2">본문</label>
        <textarea name="content" id="input2" cols="30" rows="10"></textarea>
    </div>
    <button>전송</button>
</form>
</body>
</html>

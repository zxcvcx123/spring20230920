<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-09-26
  Time: 오후 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main13/sub8">
    <div>
        <label for="param1">아이디</label>
        <input type="number" id="param1" name="id">
    </div>
    <div>
        <label for="param2">이름</label>
        <input type="text" id="param2" name="name">
    </div>
    <div>
        <label for="param3">주소</label>
        <input type="text" id="param3" name="address">
    </div>
    <div>
        <label for="param4">약속일자</label>
        <input type="datetime-local" id="param4" name="schedule">
    </div>

    <h3>할 일</h3>
    <div>
        <label for="param5">쇼핑</label>
        <input type="checkbox" id="param5" name="todos" value="쇼핑">
    </div>
    <div>
        <label for="param6">식사</label>
        <input type="checkbox" id="param6" name="todos" value="식사">
    </div>
    <div>
        <label for="param7">영화관람</label>
        <input type="checkbox" id="param7" name="todos" value="영화관람">
    </div>
    <button>전송</button>
</form>
</body>
</html>

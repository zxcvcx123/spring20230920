<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-10-19
  Time: 오전 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>직원 조회</h4>
<form action="/main30/sub13" method="get">
    <input type="number" name="id" placeholder="직원 번호">
    <button>조회</button>
</form>

<h4>직원 수정</h4>
<form action="/main30/sub14" method="post">
    <div><input type="text" name="id" value="${emp.id}" readonly></div>
    <div><input type="text" name="lastName" value="${emp.lastName}"></div>
    <div><input type="text" name="firstName" value="${emp.firstName}"></div>
    <div><input type="text" name="photo" value="${emp.photo}"></div>
    <div><input type="date" name="birthDate" value="${emp.birthDate}"></div>
    <div>
        <textarea name="notes" id="" cols="30" rows="10">${emp.notes}</textarea>
    </div>
    <div>
        <button>수정</button>
    </div>


</form>
<div>
<h3>${msg}</h3>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-10-19
  Time: 오전 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>고객 조회</h4>
<form action="/main30/sub15" method="get">
    <input type="number" name="id" placeholder="고객 번호">
    <button>조회</button>
</form>

<hr>

<h4>고객 정보</h4>
<form action="/main30/sub16" method="post">

    <div>
        고객 번호
    </div>
    <div>
        <input type="text" name="id" value="${list.id}" readonly>
    </div>
    <div>
        고객 이름
    </div>
    <div>
        <input type="text" name="name" value="${list.name}">
    </div>
    <div>
        고객 주소
    </div>
    <div>
        <input type="text" name="address" value="${list.address}">
    </div>
    <div>
        고객 국가
    </div>
    <div>
        <input type="text" name="country" value="${list.country}">
    </div>
    <div>
        <button>수정</button>
    </div>
</form>
<div>
    <h1>${msg}</h1>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-09-25
  Time: 오후 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>form 요소</h1>

<form action="">
    <input type="text" name="param1"> <br>
    <input type="text" name="param2"> <br>
    <button type="submit">전송</button>
</form>
<br> <br>

<form action="https://search.daum.net/search">
    <p>다음에서 검색하기</p>
    <input type="text" name="q">
    <br>
    <button>전송</button>
</form>

<h1>action 속성 값: /로 시작하는 경우 path가 결정됨</h1>
<form action="/main12/sub2">
    <input type="text" name="email">
    <button>전송</button>
</form>
<br>
<%--전송버튼 클릭시 request parameter가 /main12/sub2 로 전송되도록--%>
<form action="/main12/sub2">
    <input type="text" name="age">
    <button>전송</button>
</form>

<hr>
<h1>action 속성 값 : /도 아니고 protocol(scheme)이 아니면 현재페이지의 상대경로</h1>
<h1>마지막 / 기준</h1>
</body>
</html>

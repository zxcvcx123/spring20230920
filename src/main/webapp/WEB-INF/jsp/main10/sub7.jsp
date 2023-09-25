<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-09-25
  Time: 오전 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>el에서 사용가능한 연산자</h3>
<h4>산술 연산자</h4>
<h4>+, -, *, /, %</h4>
<hr>

<h5>+ : 더하기</h5>
<p>${a} + ${b} = ${a + b}</p>
<p>${c} + ${d} = ${c + d}</p>
<hr>

<h5>- : 빼기</h5>
<p>${a} - ${b} = ${a - b}</p>
<p>${c} - ${d} = ${c - d}</p>
<hr>

<h5>* : 곱하기</h5>
<p>${a} * ${b} = ${a * b}</p>
<p>${c} * ${d} = ${c * d}</p>
<hr>

<h5>/ : 나누기</h5>
<p>${a} / ${b} = ${a / b}</p>
<p>${c} / ${d} = ${c / d}</p>
<hr>

<h5>/ (div) : 나누기</h5>
<p>${a} / ${b} = ${a div b}</p>
<p>${c} / ${d} = ${c div d}</p>
<hr>

<h5>% : 나머지 연산 (modulo, remainder)</h5>
<p>${b} % ${a} = ${b % a}</p>
<p>${d} % ${a} = ${d % a}</p>
<hr>

<h5>구구단 2단 ~ 9단</h5>
<c:forEach begin="2" end="9" var="i">
    <h5>${i} 단</h5>
    <c:forEach begin="1" end="9" var="x">
        <p>${i} X ${x} = ${i*x}</p>
    </c:forEach>
</c:forEach>
<hr>

<h5>구구단 9단 ~ 2단</h5>
<c:forEach var="i" items="${l}">
    <h5>${i} 단</h5>
    <c:forEach var="x" items="${r}">
        <p>${i} X ${x} = ${i*x}</p>
    </c:forEach>
</c:forEach>


</body>
</html>

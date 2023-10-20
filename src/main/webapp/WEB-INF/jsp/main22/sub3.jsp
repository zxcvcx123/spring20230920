<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-10-06
  Time: 오후 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title></title>
</head>
<style>
    * {
        margin: 5px auto;
        text-align: center;
    }

    table {
        border: 1px solid black;
    }

    th {
        border: 1px solid black;
        background: yellow;
    }

    td {
        border: 1px solid black;
    }

    .active {
        background-color: darkblue;
        color: white;
    }
</style>
<body>
<h1>JDBC JSP 페이징 연습</h1>
<h4>고객 목록</h4>
<table>
    <th>아이디</th>
    <th>이름</th>
    <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
        </tr>
    </c:forEach>
</table>
<div>

    <c:if test="${currentPage != 1}">
        <a href="/main22/sub3?p=1"> << 처음 </a> |
    </c:if>
    <c:if test="${leftPageNumber > 5}">
        <a href="/main22/sub3?p=${prevPageNumber}"> < 이전 </a> |
    </c:if>
    <c:forEach begin="${leftPageNumber}" end="${rightPageNumber}" var="num">


        <a
                <c:if test="${num == currentPage}">
                    class="active"
                </c:if>

                href="/main22/sub3?p=${num}">${num}</a>
        |
    </c:forEach>

    <c:if test="${lastPageNum >= nextPageNumber}">
        <a href="/main22/sub3?p=${nextPageNumber}"> 다음 > </a> |
    </c:if>

    <c:if test="${currentPage != lastPageNum}">
        <a href="/main22/sub3?p=${lastPageNum}"> 맨 끝 >> </a>
    </c:if>

</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-09-25
  Time: 오후 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- /main11/sub7?show=true --%>
<%-- table 형식의 데이터 --%>
<c:choose>
    <c:when test="${(param.show eq 'true')}">
        <table>
            <tr>
                <th>ID</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>ClassName</th>
                <th>Phone</th>
            </tr>
            <c:forEach var="item" items="${list}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.firstName}</td>
                    <td>${item.lastName}</td>
                    <td>${item.className}</td>
                    <td>${item.phoneNumber}</td>
                </tr>
            </c:forEach>
        </table>
    </c:when>

    <c:otherwise>
        <p>파라미터를 입력해주세요.</p>
        <p>show=<input type="text" id="ab" placeholder="파라미터 입력하기" value=""> <button onclick="
          location.href ='localhost:8080/main11/sub2'">이동하기</button></p>
    </c:otherwise>

</c:choose>

<%-- /main11/sub7 --%>
<%--파라미터를 입력해주세요.--%>
</body>
</html>

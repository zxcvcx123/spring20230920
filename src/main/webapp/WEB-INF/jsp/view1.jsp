<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-09-21
  Time: 오후 3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>어떤 페이지</h1>

<button id="btn" class="btnClass" value="hello" onclick="btn(event)">
    버튼
</button>

<script>
    function btn(e){
      console.log("target : "+ e.target)
      console.log("target.type : "+e.target.type)
      console.log("target.id : "+e.target.id)
      console.log("target.className : "+e.target.className)
      console.log("target.value : "+e.target.value)

    }
</script>



</body>

</html>

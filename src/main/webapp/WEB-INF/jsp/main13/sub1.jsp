<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-09-26
  Time: 오전 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>input 요소들</h3>
<form action="/main13/sub2">
    <div><input type="text" name="param1"></div>
    <div><input type="password" name="param2"></div>
    <div><input type="date" name="param3"></div>
    <div><input type="button" name="param4" value="어떤 버튼"></div>
    <div><input type="number" name="param5"></div>
    <div><input type="submit" name="param6" value="회원가입"></div>
    <div><input type="radio" name="param7"></div>
    <div><input type="radio" name="param7"></div>
    <div><input type="checkbox" name="param9"></div>
    <div><input type="checkbox" name="param9"></div>
    <div><input type="hidden" name="param10" value="some value"></div>
    <button>전송</button>
</form>

<form action="/main13/sub2">
    <div><input type="text" name="param1" value="son"></div>
    <div><input type="text" name="param2" placeholder="이름을 입력해주세요."></div>
    <div><input type="text" name="param3" maxlength="5"></div>
    <div><input type="text" name="param4" required></div>
    <div><input type="text" name="param5" readonly value="kim"></div>
    <div><input type="checkbox" name="param6" id="" checked></div>
    <div><input type="checkbox" name="param6" id=""></div>
    <div><input type="radio" name="param7" id=""></div>
    <div><input type="radio" name="param7" id="" checked></div>
    <div><input type="file" name="" id="" multiple></div>
    <button>전송</button>
</form>
<form action="/main13/sub2">
    <label for="input1">주소</label>
    <input type="text" id="input1"> <br>
    <div>
        <div><label for="check1">Lorem.</label><input type="checkbox" name="" id="check1"></div>
        <div><label for="check2">Numquam!</label><input type="checkbox" name="" id="check2"></div>
        <div><label for="check3">Ipsam.</label><input type="checkbox" name="" id="check3"></div>
    </div>
    <input type="submit" value="전송">
</form>
</body>
</html>

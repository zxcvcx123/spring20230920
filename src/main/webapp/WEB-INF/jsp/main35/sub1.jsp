<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-10-23
  Time: 오후 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>

<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
<div>
    <button onclick="ajax1()">button1</button>
</div>
<div>
    <button onclick="ajax2()">button2</button>
</div>
<div>
    <button onclick="ajax3()">button3</button>
</div>
<div>
    <button onclick="ajax4()">button4</button>
</div>

<div>

    <div>
        <input type="text" name="" value="서울" id="input1">
    </div>
    <div>
        <input type="text" name="" value="1" id="input2">
    </div>
    <div>
        <input type="text" name="" value="90.5" id="input3">
    </div>
    <div>
        <input type="text" name="" value="한국" id="input4">
    </div>
    <div>
        <button onclick="ajax5()">전송</button>
    </div>
</div>

<div>

    <div>
        <input type="text" value="서울" id="input5">
    </div>
    <div>
        <input type="text" value="손흥민" id="input6">
    </div>
    <div>
        <input type="text" value="33" id="input7">
    </div>
    <div>
        <input type="text" value="son@tot.tot" id="input8">
    </div>
    <div>
        <button onclick="ajax6()">전송</button>
    </div>
</div>
<div>
    <div>
        <button onclick="ajax7()">button7</button>
    </div>
</div>
<div>
    <div>
        <button onclick="ajax8()">button8</button>
    </div>
</div>
<div>
    <div>
        <button onclick="ajax10()">button10</button>
    </div>
</div>
<div>
    <div>
        id
        <input type="text" id="input9">
    </div>
    <div>
        lastName
        <input type="text" id="input10">
    </div>
    <div>
        firstName
        <input type="text" id="input11">
    </div>
    <div>
        <button onclick="ajax11()">button11</button>
    </div>
</div>
<script>

    function ajax11() {

        let id = document.getElementById("input9").value;
        let lastName = document.getElementById("input10").value;
        let firstName = document.getElementById("input11").value;

        axios.post("/main35/sub9", {
            id,
            lastName,
            firstName
        }, {
            headers: {
                "content-type": "application/x-www-form-urlencoded"
            }
        })
    }
</script>
<script>
    function ajax1() {
        // https://axios-http.com/docs/req_config
        axios.request({
            url: "/main35/sub2" // url 통신 주소
        });
    }
</script>

<script>
    function ajax2() {


        axios.request({
            url: "/main35/sub3?address=seoul"
        })
    }
</script>

<script>
    function ajax3() {
        axios.request({
            url: "/main35/sub4",
            params: {
                address: "seoul",
                name: "son",
                age: 33,
                email: "abc@naver.com"

            }
        })
    }
</script>

<script>
    function ajax4() {
        axios.request({
            url: "/main35/sub5",
            params: {
                city: "seoul",
                id: 11,
                score: 30.5,
                country: "Korea"

            }
        })
    }
</script>

<script>
    function ajax5() {

        const city = document.querySelector("#input1").value;
        const id = document.querySelector("#input2").value;
        const score = document.querySelector("#input3").value;
        const country = document.querySelector("#input4").value;

        axios.request({
            url: "/main35/sub5",
            params: {
                city: city,
                id: id,
                score: score,
                country: country,

            }
        })
    }
</script>
<script>
    function ajax6() {

        const address = document.querySelector("#input5").value;
        const name = document.querySelector("#input6").value;
        const age = document.querySelector("#input7").value;
        const email = document.querySelector("#input8").value;

        axios.request({
            url: "/main35/sub4",
            params: {
                address: address,
                name: name,
                age: age,
                email: email
            }
        })
    }
</script>
<script>
    function ajax7() {
        axios.request({
            url: "/main35/sub6",
            params: {
                id: 9,
                lastName: "손",
                firstName: "흥민"
            }
        })
    }
</script>
<script>
    function ajax8() {
        axios.request({
            url: "/main35/sub7",
            method: "post"
        })
    }
</script>
<script>
    function ajax8() {
        axios.request({
            url: "/main35/sub7",
            method: "post"
        })
    }
</script>
<script>
    function ajax10() {
        axios.post("/main35/sub8", {
            city: "서울",
            country: "한국"
        }, {
            headers: {
                "content-type": "application/x-www-form-urlencoded"
            }
        })
    }
</script>

<div>
    <div>
        <input type="text" id="input12" value="이강인">
    </div>
    <div>
        <input type="file" multiple id="input13" accept="image/*">
    </div>
    <div>
        <button onclick="ajax12()">button12</button>
    </div>
</div>
<script>
    function ajax12() {

        axios.postForm("/main35/sub10", {
            name: document.getElementById("input12").value,
            files: document.getElementById("input13").files
            });
    }
</script>
<div>
    <div>
        <button onclick="ajax13()">button13</button>
        <script>
            function ajax13(){
                axios.request({
                    url: "/main35/sub11"
                });
            }
        </script>
    </div>
</div>
</body>
</html>

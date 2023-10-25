<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-10-25
  Time: 오후 12:16
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
    <script>
        function ajax1() {
            axios.get("/main39/sub1")
                .then(() => console.log("응답 성공"))
                .catch(() => console.log("응답 실패"))
        }
    </script>
</div>
<div>
    <button onclick="ajax2()">button2</button>
    <script>
        function ajax2() {
            axios.get("/main39/sub2")
                .then(() => console.log("성공"))
                .catch(() => console.log("실패"))
        }
    </script>
</div>
<div>
    <button onclick="ajax3()">button3</button>
    <script>
        function ajax3() {
            axios.get("/main39/sub2")
                .catch(function (error) {
                    console.log(error);
                    console.log(error.response.status); // 응답 상태 코드
                    let status = error.response.status;
                    if (status >= 400 && status < 500) {
                        console.log("요청이 잘못됐습니다.")
                    } else if (status >= 500 && status < 599) {
                        console.log("서버에서 오류가 발생했습니다.")
                    }

                });
        }
    </script>
</div>
<div>
    <button onclick="ajax4()">button4</button>
    <p id="result1"></p>
    <script>
        // 400번대 응답 #result1 요소에 "잘못된 요청" 출력
        // 500번대 응답 #result1 요소에 "서버 에러" 출력
        function ajax4() {
            axios.get("/main39/sub3")
                .catch((e) => {
                    let status = e.response.status;
                    if (status >= 400 && status < 500) {
                        document.getElementById("result1").innerText = "잘못된 요청"
                    } else if (status >= 500 && status < 600) {
                        document.getElementById("result1").innerText = "서버 에러"
                    }
                })
        }
    </script>
</div>
<div>
    <input type="text" id="input1">
    <button onclick="ajax5()">button5</button>
    <script>
        function ajax5() {
            const pid = document.getElementById("input1").value;
            axios.get("/main39/sub4?id=" + pid)
                .then((res) => res.data)
                .then((data) => console.log(data))
                .catch((e) => console.log(e));
        }
    </script>
</div>
<div>
    <button onclick="ajax6()">button6</button>
    <script>
        function ajax6() {
            axios.get("/main39/sub5")
                .then((res) => console.log("성공"))
                .catch((e) => console.log("실패"))
                .finally(() => console.log("항상 실행"));
        }
    </script>
</div>
<hr>
<div>
    <h3>직원 입력</h3>
    <div>
        <input type="text" id="firstNameInput" placeholder="first name">
    </div>
    <div>
        <input type="text" id="lastNameInput" placeholder="last name">
    </div>
    <div>
        <input type="date" id="birthInput">
    </div>
    <div>
        <textarea id="notesTextArea" cols="30" rows="10"></textarea>
    </div>
    <p id="result2"></p>
    <div>
        <button onclick="ajax7AddEmployee()" id="btn">등록</button>
        <script>
            function ajax7AddEmployee() {
                const firstName = document.getElementById("firstNameInput").value;
                const lastName = document.getElementById("lastNameInput").value;
                const birthDate = document.getElementById("birthInput").value;
                const notes = document.getElementById("notesTextArea").value;
                document.getElementById("btn").setAttribute("disabled", "disabled");

                axios.post("/main39/sub6", {
                    lastName, firstName, birthDate, notes
                })
                    .then(() => {
                        // 성공했을 때 (2xx 응답)
                        document.getElementById("result2").innerText = "등록 성공";
                    })
                    .catch((e) => {
                        // 실패했을 때 (2xx 외 응답)
                        const code = e.response.status;
                        if (400 >= code && code < 500) {
                            document.getElementById("result2").innerText = "잘못된 입력";
                        } else if (500 >= code && code < 600) {
                            document.getElementById("result2").innerText = "서버 오류";
                        }
                    })
                    .finally(() => {
                        // 항상 실행
                        document.getElementById("btn").removeAttribute("disabled");

                    })

            }
        </script>
    </div>
</div>
</body>
</html>

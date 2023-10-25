<%--
  Created by IntelliJ IDEA.
  User: jungmo
  Date: 2023-10-24
  Time: 오후 4:11
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
        function ajax1(){
            axios.get("/main38/sub1");
        }
    </script>
</div>

<div>
    <button onclick="ajax2()">button2</button>
    <script>
        function ajax2(){
            axios.get("/main38/sub2")
                .then((res) => {
                    console.log("응답 받은 후 하는일");
                    console.log(res.data);
                    console.log(res.status);
                    console.log(res.statusText);
                    console.log(res.headers);
                    console.log(res.config);

                })
        }
    </script>
</div>

<div>
    <button onclick="ajax3()">button3</button>
    <script>
        function ajax3(){
            axios.get("/main38/sub3")
                .then((res)=>{
                    console.log(res.data); // 파싱되서 들어가진 상태
                    console.log(res.data.age);
                    console.log(res.data.name);
                })
        }
    </script>
</div>

<div>
    <button onclick="ajax4()">button4</button>
    <script>
        function ajax4(){
            axios.get("/main38/sub4")
                .then((res)=>{
                    console.log(res.data.city);
                    console.log(res.data.price);
                    console.log(res.data.list[0]);
                    console.log(res.data.birth);
                })
        }
    </script>
</div>
<div>
    <input type="text" id="input1">
    <button onclick="ajax5()">button5</button>
    <script>
        function ajax5(){
            const id = document.getElementById("input1").value;
            console.log(id);
            axios.get("/main38/sub5", {params: {id:id}},{headers:{"content-type": "application/x-www-form-urlencoded"}})
                .then((res)=>{
                    const product = res.data;
                    console.log(product.ProductID);
                    console.log(product.ProductName);
                    console.log(product.Price);
                })
        }
    </script>
</div>
<div>
    <button onclick="ajax6()">button6</button>
    <script>
        function ajax6(){
            axios.get("/main38/sub2")
                .then((res)=>{
                    console.log("응답 완료 후 실행");
                })
                .then((res)=>{
                    console.log("그 다음 실행");
                })
                .then((res)=>{
                    console.log("또 그다음 실행")
                })
        }
    </script>
</div>
<div>
    <button onclick="ajax7()">button7</button>
    <script>
        function ajax7(){
            axios.get("/main38/sub2")
                .then((res)=>{
                    console.log("첫 함수");
                    return "abcd";
                })
                .then((param)=>{
                    console.log("두번째 함수");
                    console.log(param); // abcd 출력
                    return 345;
                })
                .then((param)=>{
                    console.log("세번째 함수");
                    console.log(param); // 345출력
                })

        }
    </script>
</div>
<div>
    <button onclick="ajax8()">button8</button>
    <script>
        function ajax8(){
            axios.get("/main38/sub2")
                .then((res)=>{
                    console.log("첫 함수");
                    return res.data;
                })
                .then((param)=>{
                    console.log("두번째 함수");
                    console.log(param);
                    return 345;
                })
                .then((param)=>{
                    console.log("세번째 함수");
                    console.log(param); // 345출력
                })

        }
    </script>
</div>
<div>
    <button onclick="ajax9()">button9</button>
    <script>
        function ajax9(){
            axios.get("/main38/sub2")
                .then(res => res.data)
                .then(param => console.log(param))


        }
    </script>
</div>
<div>
    <button onclick="ajax10()">button10</button>
    <script>
        function ajax10(){
            axios.get("/main38/sub4")
                .then(res => res.data)
                .then(data => console.log(data.list[1])); // lee
        }
    </script>
</div>
<script>
    // 구조분해할당
    // destructuring assignment
    let a = {
        name: "son",
        age: 30
    };

    console.log(a.name);
    console.log(a.age);

    let myName = a.name;
    let myAge = a.age;

    console.log(myName);
    console.log(myAge);

    let {name, age} = a; // 구조분해 할당
    console.log(name);
    console.log(age);

    let b = {
        city: "seoul",
        country: "korea"
    }

    let c = {
        email: "abc@gmail.com",
        price: 300
    };

    let {email, price} = c;
    let {email} = c; // 모든 프로퍼티값을 할당 안해도 됨

    let d = {
        name: "lee",
        address: "paris",
        age: 23
    };

    let {name, address} = d; // 모든 프로퍼티값을 할당 안해도 됨

    let {city, country} = b;

    let e = {
        city: "seoul",
        country: "korea"
    }

    let {city, country, category} = e;
    console.log(city); // seoul
    console.log(country); // korea
    console.log(category) // undefined

    let g = [30, 40, 50];

    let [h, i, j] = g;

</script>
<div>
    <button onclick="ajax11()">button11</button>
    <script>
        function ajax11(){
            axios.get("/main38/sub4")
                .then(res => res.data)
                .then(({price, birth, list, city}) => {
                    console.log(price)
                    console.log(birth)
                    console.log(list)
                    console.log(city)
                });
        }
    </script>
</div>
<div>
    <button onclick="ajax13()">button13</button>
    <script>
        function ajax13(){
            axios.get("/main38/sub4")
                .then(res => res.data)
                .then(({price, city, country = "korea"}) => {
                console.log(price);
                console.log(city);
                console.log(country);
            })
        }
    </script>
</div>
</body>
</html>

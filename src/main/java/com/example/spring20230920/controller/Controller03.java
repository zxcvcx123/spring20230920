package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("main2")
public class Controller03 {

    // /main2/sub1?address=seoul
    @RequestMapping("sub1")
    public void method1(WebRequest request) { // query string의 값을 WebRequest 객체에 담겨온다
        System.out.println("Controller03.method1");

        String address = request.getParameter("address"); // getParameter("name")으로 값 추출

        System.out.println("address = " + address);
    }

    // /main2/sub2?name=kim&address=jeju
    @RequestMapping("sub2")
    public void method2(WebRequest request) {
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        System.out.println("Controller03.method2");
        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }

    @RequestMapping("sub3")
    public void method3(@RequestParam("name") String name) {
        System.out.println("name = " + name);
    }

    @RequestMapping("sub4")
    public void method4(@RequestParam("name") String name,
                        @RequestParam("address") String address) {
        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }

    // /main2/sub5?email=abc@gmaile.com&gender=남자&number=010-9999-9999
    @RequestMapping("sub5")
    public void method5(@RequestParam("email") String email,
                        @RequestParam("gender") String gender,
                        @RequestParam("number") String number){
        System.out.println("email = " + email);
        System.out.println("gender = " + gender);
        System.out.println("number = " + number);
    }

    @RequestMapping("sub6")
    public void method6(@RequestParam("name") String name,
                        @RequestParam("age") String age){
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        Integer iage = Integer.valueOf(age);

        System.out.println("10년후 나의 나이는? "+ (iage+10));

    }

    @RequestMapping("sub7")
    public void method7(@RequestParam("name") String name,
                        @RequestParam("age") Integer age){
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        System.out.println("10년후 나의 나이는? "+ (age+10));
    }

    // /main2/sub8?address=seoul&married=false&age=66
    @RequestMapping("sub8")
    public void method8(@RequestParam("address") String address,
                        @RequestParam("married") Boolean married,
                        @RequestParam("age") Integer age){
        System.out.println("주소 = " + address);
        if(married){
            System.out.println("혼인여부 = 기혼");
        } else {
            System.out.println("혼인여부 = 미혼");
        }
        System.out.println("나이 = " + age);

    }

    @RequestMapping("sub9")
    public void method9(@RequestParam(value = "name", required = false) String name){
        System.out.println("name = " + name);
    }

    // /main2/sub10?address=seoul&age=30
    // /main2/sub10?address=jeju
    @RequestMapping("sub10")
    public void  method10(@RequestParam("address") String address,
                          @RequestParam(value = "age",required = false) String age){
        System.out.println("주소: " + address);
        System.out.println("나이: " + age);
    }

    @RequestMapping("sub11")
    public void method11(@RequestParam(value = "age",defaultValue = "0") Integer age){
        System.out.println("나이: " + age);
    }


}

package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("main4")
public class Controller04 {


    @RequestMapping("sub1")
    public void method1(@RequestParam String name){
        System.out.println("name: " + name);
    }

    // /main4/sub2?address=seoul&email=abc@gmail.com&age=44
    @RequestMapping("sub2")
    public void mehtod2(@RequestParam String address,
                        @RequestParam String email,
                        @RequestParam String age){

        System.out.println("address: " + address);
        System.out.println("email: " + email);
        System.out.println("age: " + age);

    }

    @RequestMapping("sub3")
    public void method3(String name, Boolean married){
        System.out.println("name = " + name);
        System.out.println("married = " + married);

    }

    // /main4/sub4?check=true&email=abc@naver.com&age=55
    @RequestMapping("sub4")
    public void method4(Boolean check,
                        String email,
                        Integer age){
        System.out.println("check: " + check);
        System.out.println("email: " + email);
        System.out.println("age: " + age);
    }

}

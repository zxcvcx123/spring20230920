package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("main2")
public class Controller03 {

    // /main2/sub1?address=seoul
    @RequestMapping("sub1")
    public void method1(WebRequest request){ // query string의 값을 WebRequest 객체에 담겨온다
        System.out.println("Controller03.method1");

        String address = request.getParameter("address"); // getParameter("name")으로 값 추출

        System.out.println("address = " + address);
    }
}

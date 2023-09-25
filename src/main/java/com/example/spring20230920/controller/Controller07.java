package com.example.spring20230920.controller;

import jdk.jfr.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("main7")
public class Controller07 {

    // Handler Method 라고함
    @RequestMapping("sub1")
    public String method1(){
        System.out.println("Controller07.method1");
        return "view1";
    }

    @RequestMapping("sub2")
    public String method2(){
        System.out.println("Controller07.method2");
        return "html2";
    }

    // void return 타입이면 요청경로가 view name이 됨
    // 경로 : main7/sub3
    // view name : /main7/sub3.jsp
    // view 경로 : /WEB-INF/jsp/main7/sub3.jsp 가 되는거임
    @RequestMapping("sub3")
    public void method3(){
        System.out.println("Controller07.method3");
    }

    @RequestMapping("sub4")
    public String method4(){
        return "/main7/html4";
    }

    @RequestMapping("sub5")
    public void method5(){

    }


}

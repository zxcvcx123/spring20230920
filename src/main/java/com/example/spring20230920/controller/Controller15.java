package com.example.spring20230920.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("main15")
public class Controller15 {

    @GetMapping("sub1")
    public void method1(){

    }

    @GetMapping("sub2")
    public void method2(HttpSession session){

        System.out.println("session = " + session.getId()); // 세션ID정보 가져오기
    }

    @GetMapping("sub3")
    public void method3(
            @RequestParam(value = "name", defaultValue = "") String name,
            HttpSession session){

        if(!name.isBlank()){
            session.setAttribute("username", name);
        }

        System.out.println("세션에 저장된 username" + session.getAttribute("username"));

    }

    @GetMapping("sub4")
    public void method4(){

    }


    @PostMapping("sub5")
    public void method5(@RequestParam("name") String name, HttpSession session){
        session.setAttribute("username", name);
    }

    @GetMapping("sub6")
    public void method6(){

    }

    @GetMapping("sub7")
    public void method7(){

    }

    // post 요청 /main15/sub8
    // request parameter foods를
    // session 에 attribute로 넣고
    // sub8.jsp 로 포워드 메소드 만들기
    @PostMapping("sub8")
    public void method8(@RequestParam(value = "foods") List<String> food, HttpSession session){
        session.setAttribute("food", food);
    }

    // get 요청 /main15/sub9
    // sub9.jsp로 포워드하는 메소드 만들기
    @GetMapping("sub9")
    public void method9(){

    }

    @GetMapping("sub10")
    public void method10(Model model, HttpSession session){
        model.addAttribute("modelAttr1", "탕후루");
        session.setAttribute("sessionAttr1", "마라탕");

        model.addAttribute("attr1", "돈까스");
        session.setAttribute("attr1", "커피");

    }
}

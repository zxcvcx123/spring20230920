package com.example.spring20230920.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("main16")
public class Controller16 {
    
    @Autowired
    private ServletContext application;

    @GetMapping("sub1")
    public void method1(Model model, HttpSession session){
        model.addAttribute("modelAttr1", "추석");
        session.setAttribute("sessionAttr1", "강강술래");
        application.setAttribute("appAttr1", "보름달");

        // model.addAttribute("attr1", "송편");
        session.setAttribute("attr1", "윳놀이");
        application.setAttribute("attr1", "토끼");
    }

    @GetMapping("sub2")
    public void method2(HttpSession session){
        Object count = session.getAttribute("count");
        if(count == null){
            session.setAttribute("count", 0);
        } else {
            Integer countInt = (Integer) count;
            countInt++;
            session.setAttribute("count", countInt);
        }

        Object appCount = application.getAttribute("count");
        if(count == null){
            application.setAttribute("count", 0);
        } else {
            Integer countInt = (Integer) count;
            countInt++;
            application.setAttribute("count", countInt);
        }
    }

    @GetMapping("sub3")
    public void method3(Model model, HttpSession session){

        model.addAttribute("modelAttr1", "보름달");
        session.setAttribute("sessionAttr1", "송편");


    }

    @GetMapping("sub4")
    public void method4(Model model, HttpSession session){
        Object modelAttr1 = model.getAttribute("modelAttr1");
        Object sessionAttr1 = session.getAttribute("sessionAttr1");

        System.out.println("modelAttr1 : " + modelAttr1);
        System.out.println("sessionAttr1 : " + sessionAttr1);
    }

    @GetMapping("sub5")
    public String method5(){
        return "/main16/sub5";
    }

    @GetMapping("sub6")
    public String method6(){
        // redirection
        // 다른 곳(location)으로 가!!! 라는 응답(response, 302)
        return "redirect:/main16/sub5";
    }

    @GetMapping("sub7")
    public String method7(){
        return "redirect:https://www.naver.com";
    }

    @GetMapping("sub8")
    public String method8(String email){

        return "redirect:/main16/sub9?p=" + email;
    }

    @GetMapping("sub9")
    public void method9(String p){
        System.out.println("p = " + p);
    }

    @GetMapping("sub10")
    public String method10(String name, HttpSession session){
        String processed = name + " 처리 결과";
        session.setAttribute("proccessedValue", processed);
        return "redirect:/main16/sub11";
    }

    @GetMapping("sub11")
    public void method11(HttpSession session){
        Object proccessedValue = session.getAttribute("proccessedValue");
        System.out.println("proccessedValue : " + proccessedValue);
    }

    @GetMapping("sub12")
    public String method12(String address, RedirectAttributes rttr){
        String pro = address + "처리 결과";
        rttr.addFlashAttribute("pro", pro);
        return  "redirect:/main16/sub13";
    }

    @GetMapping("sub13")
    public void method13(Model model){
        Object pro = model.getAttribute("pro");
        System.out.println("pro: " + pro);
    }

    //첫 요청을 /main16/sub14
    @GetMapping("sub14")
    public String method14(String[]foodList, RedirectAttributes reAttr){

        reAttr.addFlashAttribute("foodList", foodList);

        return "redirect:/main16/sub14";
    }

    @GetMapping("sub15")
    public void method15(Model model){

        model.addAttribute("foodList", model.getAttribute("foodList"));

    }

    @GetMapping("sub16")
    public String method16(RedirectAttributes rttr){
        rttr.addFlashAttribute("flashAttr", "모델에 붙음");
        rttr.addAttribute("attr1", "쿼리스트링에 붙음");
        return "redirect:/main16/sub17";
    }

    @GetMapping("sub17")
    public void method17(){
        System.out.println("Controller16.method17");
    }
}

package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("main12")
public class Controller12 {

    @RequestMapping("sub1")
    public void method1(){

    }

    @RequestMapping("sub2")
    public void method2(@RequestParam String age, Model model){
        model.addAttribute("age", age);
    }

    @RequestMapping("asbu2/bsub2/csub2/dsub2/esub2")
    public void method31(){

    }

    @RequestMapping("sub3")
    public void method3(){

    }

    @RequestMapping("sub4")
    public void method4(String name, String age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
    }

    @RequestMapping("sub5")
    public void method5(){

    }

    @RequestMapping("sub6")
    public void method6(String search, Model model ){
        model.addAttribute("search", search);

    }
}

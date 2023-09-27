package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto9;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main11")
public class Controller11 {

    @RequestMapping("sub1")
    public void method1() {

    }

    @RequestMapping("sub2")
    public void method2() {

    }

    @RequestMapping("sub3")
    public void method3() {

    }

    @RequestMapping({"sub4", "sub5"})
    public void method4() {

    }

    @RequestMapping("sub7")
    public void method7(@RequestParam(value = "show", defaultValue = "false") Boolean show, Model model) {

        if (show) {
            List<MyDto9> list = new ArrayList<>();
            list.add(new MyDto9(31, "son", "hm", "football", "010"));
            list.add(new MyDto9(32, "lee", "ki", "paris", "011"));
            list.add(new MyDto9(33, "김", "두식", "서울", "02"));
            list.add(new MyDto9(34, "김", "봉석", "부산", "03"));
            list.add(new MyDto9(35, "장", "희수", "제주", "05"));
            model.addAttribute("list", list);
        }

        System.out.println(show);

    }

}

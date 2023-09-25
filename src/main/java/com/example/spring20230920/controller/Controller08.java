package com.example.spring20230920.controller;

import com.example.spring20230920.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main8")
public class Controller08 {

    @RequestMapping("board")
    public void method1(Model model){
        model.addAttribute("attr1","value1");
        model.addAttribute("attr2", "value2");

    }

    @RequestMapping("user")
    public String method(Person person, Model model){
        person.setName("kim");
        person.setAge(27);

        model.addAttribute("person", person);
        return "/main8/sub2";
    }

    @RequestMapping("sub3")
    public void method3(Model model){
        model.addAttribute("myName", "kim");
        model.addAttribute("yourAddress", List.of(5,4));
        model.addAttribute("herEmail", Map.of("addr","naver"));
    }
}

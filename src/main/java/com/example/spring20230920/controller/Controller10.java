package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto10;
import com.example.spring20230920.domain.MyDto9;
import com.example.spring20230920.domain.Student;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main10")
public class Controller10 {

    @RequestMapping("sub1")
    public void method1(Model model) {
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();

        student1.setFirstName("son");
        student2.setFirstName("lee");
        student3.setFirstName("kim");

        model.addAttribute("students", List.of(student1, student2));
        model.addAttribute("studentsList", List.of(student1, student2, student3));
    }

    @RequestMapping("sub2")
    public void method2(Model model) {
        Student o1 = new Student();
        Student o2 = new Student();
//
//        o1.setLastName("두식");
//        o2.setLastName("봉석");

//        model.addAttribute("personMap", Map.of("person1", o1, "person2", o2));

        o1.setLastName("흥민");
        o2.setLastName("강인");

        model.addAttribute("people", Map.of("1st", o1, "2nd", o2));
    }

    @RequestMapping("sub3")
    public void method3(Model model) {
        MyDto10 o1 = new MyDto10();
        o1.setName("doosik");
        o1.setId(3);
        o1.setFoods(List.of("pizza", "burger", "milk"));
        o1.setCars(List.of("race","sports","bus"));
        o1.setNums(new String[]{"one", "two"});

        model.addAttribute("person1", o1);
    }

    @RequestMapping("sub4")
    public void method4(Model model){
        model.addAttribute("myList", List.of("tesla", "kia", "benz"));
    }

    @RequestMapping("sub5")
    public void method5(Model model){
        model.addAttribute("foodList", List.of("apple", "banana", "pineapple","berry"));
        model.addAttribute("names", List.of("두식", "봉석", "희수", "미현"));

    }

    @RequestMapping("sub6")
    public void method6(Model model){
        List<MyDto9> list = new ArrayList<>();
        list.add(new MyDto9(31, "son", "hm", "football","010"));
        list.add(new MyDto9(32, "lee", "ki", "paris","011"));
        list.add(new MyDto9(33, "kim", "doosik", "seoul","02"));
        list.add(new MyDto9(34, "park", "bongsu", "busan","03"));
        list.add(new MyDto9(35, "jung", "huisoo", "jeju","05"));


        model.addAttribute("list",list);
    }

    @RequestMapping("sub7")
    public void method7(Model model){
        model.addAttribute("a", 3);
        model.addAttribute("b", 5);

        model.addAttribute("c", "8");
        model.addAttribute("d", "9");

        model.addAttribute("l", List.of(9,8,7,6,5,4,3,2));
        model.addAttribute("r", List.of(1,2,3,4,5,6,7,8,9));
    }

    @RequestMapping("sub8")
    public void method8(Model model){
        model.addAttribute("a", 3);
        model.addAttribute("b", 5);
    }

    @RequestMapping("sub9")
    public void method9(Model model){
        model.addAttribute("a", "java");
        model.addAttribute("b", "");
        model.addAttribute("c", List.of(3,4));
        model.addAttribute("d", List.of());
        model.addAttribute("e", Map.of("name", "son"));
        model.addAttribute("f", Map.of());
        model.addAttribute("g", null);
    }
}

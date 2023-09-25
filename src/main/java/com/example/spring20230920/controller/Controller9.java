package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto7;
import com.example.spring20230920.domain.MyDto8;
import com.example.spring20230920.domain.Student;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Controller
@RequestMapping("main9")
public class Controller9 {

    @RequestMapping("sub1")
    public void method1(Model model){
        model.addAttribute("attr1", "son");
        model.addAttribute("attr2", 300);
        model.addAttribute("attr3", true);
        model.addAttribute("attr4", 3.14);

        // 모델속성이 배열일 경우
        model.addAttribute("attr5",new String[]{"lee","kim"});

        String[] myArr1 = {"korea", "jeju", "seoul"};
        model.addAttribute("yourArr6",myArr1);

    }

    @RequestMapping("sub2")
    public void method2(Model model){
        String[] myName = {"son","lee"};
        String[] yourEmail = {"naver", "google", "yahoo"};
        String[] herAddress = {"seoul"};
        model.addAttribute("myName",myName);
        model.addAttribute("yourEmail",yourEmail);
        model.addAttribute("herAddress",herAddress);
    }

    @RequestMapping("sub3")
    public void method3(Model model){
        model.addAttribute("names", List.of("두식", "봉석","희수"));
        model.addAttribute("list1", List.of("리스트1번", "리스트2번"));
        model.addAttribute("mapList1", List.of("map1", "map2","map3"));
        model.addAttribute("cities", List.of("cities1", "cities2","cities3","cities4"));
    }

    @RequestMapping("sub4")
    public void method4(Model model){
        var map1 = Map.of("son",7,"lee",19,"kim",3);
        model.addAttribute("myMap",map1);

        var map2 = Map.of("seoul","seoul","busan","busan");
        var map3 = Map.of("red","red","blue","blue","black","black");
        model.addAttribute("cityMap", map2);
        model.addAttribute("color", map3);

        var map4 = Map.of("name","두식","my name","봉석","your-nmae","희수");
        model.addAttribute("attr3",map4);
    }

    @RequestMapping("sub5")
    public void method5(Model model) {
        var map1 = Map.of("phone1", "iphone", "phone2", "galaxy");
        var map2 = Map.of("korea", "seoul","us","ny");
        var map3 = Map.of("1st", "hamburger","2nd","pizza");

        model.addAttribute("phones",map1);
        model.addAttribute("caps",map2);
        model.addAttribute("foods",map3);
    }

    @RequestMapping("sub6")
    public void method6(Model model){
        model.addAttribute("attr1", new Object());
        model.addAttribute("attr2", new Scanner(System.in));


        model.addAttribute("attr3", new MyDto7());

    }

    @RequestMapping("sub7")
    public void method7(Model model){

        MyDto8 o1 = new MyDto8();
        o1.setFood("pizza");
        o1.setComputer("intel");
        o1.setBirthDate("2020-0101");

        model.addAttribute("person1",o1);

    }

    @RequestMapping("sub8")
    public void method8(Model model){
        Student student = new Student();
        student.setId("abcd");
        student.setLastName("J");
        student.setLastName("M");
        student.setClassName("C");
        student.setPhoneNumber("010-0000-0000");

        model.addAttribute("student", student);
    }

}


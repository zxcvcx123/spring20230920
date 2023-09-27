package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto11;
import com.example.spring20230920.domain.MyDto12;
import com.example.spring20230920.domain.MyDto13;
import jdk.jfr.Registered;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("main13")
public class Controller13 {

    @RequestMapping({"sub1", "sub2", "sub4", "sub7", "sub9", "sub11", "sub13"})
    public void method1() {

    }

    @RequestMapping("sub3")
    public void method3(@RequestParam("param1") String param1,
                        @RequestParam("param2") String param2,
                        @RequestParam("param3") String param3,
                        @RequestParam("param4") LocalDate param4) {
        System.out.println("param1= " + param1);
        System.out.println("param2= " + param2);
        System.out.println("param3= " + param3);
        System.out.println("param4= " + param4);
    }

    @RequestMapping("sub5")
    @ResponseBody
    public String method5(@RequestParam("userId") String userId,
                          @RequestParam("userEmail") String userEmail,
                          @RequestParam("birthDate") LocalDate birthDate,
                          @RequestParam("hobby") List<String> hobby) {
        System.out.println("아이디: " + userId);
        System.out.println("이메일: " + userEmail);
        System.out.println("생년월일: " + birthDate);
        for (String item : hobby) {
            System.out.println("취미: " + item);
        }
        return "회원가입이 완료 됐습니다.";
    }

    @RequestMapping("sub6")
    @ResponseBody
    public String method6(MyDto11 user) {

        System.out.println("아이디: " + user.getUserId());
        System.out.println("이메일: " + user.getUserEmail());
        System.out.println("생년월일: " + user.getBirthDate());
        for (String item : user.getHobby()) {
            System.out.println("취미: " + item);
        }

        return "회원가입이 완료 됐습니다.";
    }

    @RequestMapping("sub8")
    public void method7(MyDto12 info) {
        System.out.println("info = " + info);
    }

    @RequestMapping("sub12")
    public void method12(MyDto13 vo) {
        System.out.println("vo= " + vo);
    }

    @RequestMapping("sub14")
    public void method14(String[] hobby){
        for(String item:hobby){
            System.out.println(item);
        }
    }
}

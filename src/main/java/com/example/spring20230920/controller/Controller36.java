package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao6;
import com.example.spring20230920.dao.MyDao7;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("main36")
public class Controller36 {

    private final MyDao7 dao;

    @GetMapping("sub1")
    public void method1() {

    }

    @GetMapping("sub2")
    public void method2(Integer id) {
        Map<String, Object> data = dao.selectByCustomerId(id);
        System.out.println("data = " + data);
    }

    @GetMapping("sub3")

    public void mehtod3(@RequestBody Map<String, Object> map) {
        System.out.println("map = " + map);
    }

    // axios.post("/main36/sub4",  lastName: "손", firstName: "흥민", birthDate: 2020-02-02});
    @PostMapping("sub4")
    public void method4(String lastName, String firstName, LocalDate birthDate) {
        System.out.println("lastName = " + lastName);
        System.out.println("firstName = " + firstName);
        System.out.println("birthDate = " + birthDate);
    }

    // post /main36/sub5
    // name=라면&price=150.00&category=3
    @PostMapping("sub5")
    public void method5(String name,
                        Double price,
                        Integer category) {
        int r = dao.insertProduct(name, price, category);
        System.out.println(r + " 개 행이 입력됨");
    }


    @DeleteMapping("sub6")
    public void method6() {
        System.out.println("Controller36.method6");
    }

    @DeleteMapping("sub7")
    public void method7() {
        System.out.println("Controller36.method7");
    }

    /*axios.delete("/main36/sub8")*/
    @DeleteMapping("sub8")
    public void method8(String name) {
        System.out.println("name = " + name);
    }

    // PathVariable 
    @DeleteMapping("sub9/{name}")
    public void method9(@PathVariable("name") String name) {
        System.out.println("name = " + name);
    }

    @DeleteMapping("sub10/{id}")
    public void method10(@PathVariable("id") Integer id) {
        System.out.println("id = " + id);
    }

    @PutMapping("sub13")
    public void method13() {
        System.out.println("Controller36.method13");
    }

    @PutMapping("sub14")
    public void method14(){

    }

    @PutMapping("sub15")
    public void method15(String city, Integer age, Double score){
        System.out.println("city = " + city);
        System.out.println("age = " + age);
        System.out.println("score = " + score);
    }

    @PutMapping("sub17")
    public void method17(String lastName, String firstName, LocalDate birthDate, Integer id){
        dao.updateEmp(lastName, firstName, birthDate, id);
    }
}

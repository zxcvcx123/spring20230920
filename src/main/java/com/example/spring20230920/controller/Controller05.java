package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main5")
public class Controller05 {

    @RequestMapping(value = "sub1",params = "address")
    public void method1(String name, Integer age, String address){
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("address = " + address);
    }


    @RequestMapping("sub2")
    public void method2(Person5 person5){
        System.out.println(person5.getName());
        System.out.println(person5.getAge());
        System.out.println(person5.getAddress());
    }

    // main5/sub4?email=abc@naver.com&married=true&age=33&info=programmer
    @RequestMapping("sub4")
    public void method4(User user){
        System.out.println("email: " + user.getEmail());
        System.out.println("married: " + user.getMarried());
        System.out.println("age: " + user.getAge());
        System.out.println("info: " + user.getInfo());
    }
}

class User{
    private String email;
    private Boolean married;
    private Integer age;
    private String info;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

class Person5{
    private String name;
    private Integer age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


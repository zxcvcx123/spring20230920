package com.example.spring20230920.domain;

public class MyDto7 {



    public String getName(){
        return "김봉석";
    }

    public String getAddress(){
        return "서울특별시";
    }

    public String getEmail(){
        return "네이버";
    }

    public String getAge(){
        return "27살";
    }

    @Override
    public String toString() {
        return "내가 만든 클래스";
    }
}

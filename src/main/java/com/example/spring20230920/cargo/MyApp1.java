package com.example.spring20230920.cargo;

public class MyApp1 {

    public static void main(String[] args) {
        System.out.println("code Start");

        MyClass1 o1 = new MyClass1();
        o1.method1();
    }

}

class MyClass1 {
    public void method1(){
        System.out.println("MyClass1.method1");
    }

}
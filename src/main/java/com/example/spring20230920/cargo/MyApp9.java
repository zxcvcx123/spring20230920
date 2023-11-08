package com.example.spring20230920.cargo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp9 {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp9.class, args);

        MyClass16 myClass16 = context.getBean("myClass16", MyClass16.class);
        MyClass15 myClass15 = context.getBean("myClass15", MyClass15.class);

        System.out.println(myClass16);
        System.out.println(myClass15.getField());

    }

}

@Component
class MyClass16{

}

@Component
@RequiredArgsConstructor // final 필드를 아규먼트로 받는 생성자 만들어주는 lombok 어노테이션
class MyClass15 {


    // final을 작성하게되면 무조건 값을 한번 받아야 한다.
    // 우리가 값을 받는 방법중 바로 받을 수 있는건 생성자를 통해 받을 수 있다.
    private final MyClass16 field;

    // @RequiredArgsConstructor 쓰면 자동으로 만들어줌
//    public MyClass15(MyClass16 field) {
//        this.field = field;
//    }


    public MyClass16 getField() {
        return field;
    }
}

package com.example.spring20230920.cargo;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp13 {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp13.class, args);
        
    }
    
}

@Component
class MyClass26{
    
    @PostConstruct // DI가 끝나면 바로 이 메소드를 실행시켜라 하는 어노테이션
    public void method1(){
        System.out.println("MyClass26.method1");
    }
}
package com.example.spring20230920;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp10 {

    public static void main(String[] args) {
        ApplicationContext context;

    }

}

interface MyInterface1 {

}

@Component
class MyClass18 implements MyInterface1 {
    
}

@Component
class MyClass19 implements MyInterface1 {
    
}

@Component
//@RequiredArgsConstructor
class MyClass17 {
    private final MyInterface1 field;
    
    // MyInterface1에 주입이 될 수 있는데 여러개 라면 (MyClass18, MyClass19)
    // @Qualifier("스프링 빈 명")을 명시해줘야한다
    public MyClass17(@Qualifier("myClass18")MyInterface1 field) {
        this.field = field;
    }
}

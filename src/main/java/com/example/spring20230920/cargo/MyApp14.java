package com.example.spring20230920.cargo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class MyApp14 {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp14.class, args);
        Object myBean1 = context.getBean("myBean1");
        System.out.println(myBean1);

        Configuration1 configuration1 = context.getBean("configuration1", Configuration1.class);
        MyClass27 obj1 = configuration1.myBean1();
        System.out.println(obj1);

    }
}

// Configuraion 클래스(빈) :
// spring bean을 만드는 메소드를 가진 클래스
@Configuration
class Configuration1 {


    // 빈을 만드는 메소드
    // bean의 이름은 메소드명과 같음
    @Bean
    public MyClass27 myBean1(){
        return new MyClass27();
    }

}

// @Conponent // 빈의 이름이 클래스 이름으로 lowerCamelCase로 바꾼것
class MyClass27{}

package com.example.spring20230920.cargo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp2 {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp2.class, args);

        // @SpringBootApplication 가 동작하는 방식
        // @Component가 하는 일
        Object bean1 = context.getBean("myInstance2"); // spring bean
        System.out.println(bean1 instanceof MyClass2); // true
        MyClass2 o1 = (MyClass2) bean1; // 형변환
        o1.method2(); // 형변환된 객체의 메소드 사용

        Object bean3 = context.getBean("myBean3"); // spring bean
        System.out.println(bean3 instanceof MyClass3); // true
        MyClass3 o2 = (MyClass3) bean3;

        System.out.println(System.identityHashCode(context.getBean("myBean3"))); // 같은 참조값
        System.out.println(System.identityHashCode(context.getBean("myBean3"))); // 같은 참조값
        System.out.println(System.identityHashCode(context.getBean("myBean3"))); // 같은 참조값
       
        
        System.out.println(System.identityHashCode(context.getBean("myInstance2"))); // 같은 참조값
        System.out.println(System.identityHashCode(context.getBean("myInstance2"))); // 같은 참조값
        System.out.println(System.identityHashCode(context.getBean("myInstance2"))); // 같은 참조값

        MyClass2 bean22 = context.getBean("myInstance2", MyClass2.class);
        MyClass3 bean33 = context.getBean("myBean3", MyClass3.class);

        System.out.println(System.identityHashCode(context.getBean("myBean3"))); // 같은 참조값
        System.out.println(System.identityHashCode(context.getBean("myInstance2"))); // 같은 참조값
    }

}

@Component("myBean3")
class MyClass3{

}
@Component("myInstance2")
class MyClass2 {
    public void method2(){
        System.out.println("MyClass2.method2");
    }
}
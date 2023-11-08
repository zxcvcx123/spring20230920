package com.example.spring20230920.cargo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp12 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp12.class,args);

        Object bean = context.getBean("myClass25");
        Object bean1 = context.getBean("myClass24");
        Object bean2 = context.getBean("myClass23");

        MyClass25 o1 = (MyClass25) bean;

        System.out.println(bean1.hashCode()); //23
        System.out.println(bean2.hashCode()); // int값 출력 (1) //24
        System.out.println(o1.getMyInterface3().hashCode()); // int값 출력 (1) //25

    }

}

interface MyInterface3 {

}


@Component
class MyClass23 implements MyInterface3 {


}

@Component
class MyClass24 implements MyInterface3 {



}

@Component
class MyClass25  {

    private MyInterface3 myInterface3;

//    @Autowired
//    public void setMyInterface3(@Qualifier("myClass23") MyInterface3 myInterface3) {
//        this.myInterface3 = myInterface3;
//    }

    public MyClass25(@Qualifier("myClass23") MyInterface3 myInterface3) {
        this.myInterface3 = myInterface3;
    }

    public MyInterface3 getMyInterface3() {
        return myInterface3;
    }

}

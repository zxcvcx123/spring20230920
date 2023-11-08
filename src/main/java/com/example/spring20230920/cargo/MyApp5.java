package com.example.spring20230920.cargo;


public class MyApp5 {

    public static void main(String[] args) {

        // ApplicationContext context = SpringApplication.run(MyApp5.class, args);

        // 스프링 도움없이 우리가 직접 제어 한다면
        MyClass8 obj8 = new MyClass8();
        MyClass7 obj7 = new MyClass7();
        obj7.setField1(obj8);

        obj7.method7();

    }

}

class MyClass8 {
    public void method8(){
        System.out.println("MyClass8.method8");
    }
}


class MyClass7 {

    private MyClass8 field1; // dependency (의존성)

    // MyClass7 은 MyClass8의 필드와 메소드를 사용하려한다
    // 만약 MyClass8이 없으면 NullPintException이 난다
    // 그래서 없으면 안되기 때문에 이걸 의존성이라고 한다.

    public MyClass7() {

    }

    public void setField1(MyClass8 field1) {
        this.field1 = field1;
    }

    public void method7(){
        field1.method8();
    }

}


package com.demo.ioc;

//创建测试对象，通过IOC来创建对象
public class Ioc {
    //默认无参构造函数
    public Ioc(){
        System.out.println("HelloIoc default Construtor");
    }
    public void sayHelloIoc() {
        System.out.println("Hello IOC");
    }
}

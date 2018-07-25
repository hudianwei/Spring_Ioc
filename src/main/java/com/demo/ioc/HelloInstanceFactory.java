package com.demo.ioc;

public class HelloInstanceFactory {
    public HelloInstanceFactory(){
        System.out.println("实例工厂方法构造函数");
    }

    //利用实例工厂方法创建对象
    public Ioc getInstance(){
        Ioc instanceIoc = new Ioc();
        return instanceIoc;
    }
}
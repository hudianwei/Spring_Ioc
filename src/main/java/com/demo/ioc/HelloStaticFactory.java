package com.demo.ioc;


public class HelloStaticFactory {
    public HelloStaticFactory() {
        System.out.println("HelloStaticFactory constructor");
    }
//静态工厂方法
    public static Ioc getInstances() {
        return new Ioc();
    }
}


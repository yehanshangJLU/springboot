package com.factoryMethod;


import org.slf4j.ILoggerFactory;
import org.slf4j.impl.Log4jLoggerFactory;

/**
 * 工厂方法模式 （Factory Method Pattern）
 * 定义 一个 创建对象的接口，但让 实现这个接口的类来决定 实例化哪个类
 * 工厂方法模式  让类的实现 推迟到子类中进行
 * 属于 创建型 设计模式
 */
public class FactoryMethodPattern {
    public static void main(String[] args) {
       // Log4jLoggerFactory   ILoggerFactory
        ILoggerFactory Log4jLoggerFactory = new Log4jLoggerFactory();
        Log4jLoggerFactory.getLogger("");
    }
}

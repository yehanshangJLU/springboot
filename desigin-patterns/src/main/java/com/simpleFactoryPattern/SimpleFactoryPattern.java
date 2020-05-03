package com.simpleFactoryPattern;

import java.util.Calendar;

/**
 * 简单工厂模式  Simple Factory Pattern
 * 由一个 工厂对象决定 创建出哪一种 产品类的实例
 * 属于 创建型 模式，不属实23种设计模式
 */
public class SimpleFactoryPattern {
    public static void main(String[] args) {
        //时间类  Calendar 默认创建初始化类，根据国家 创建
        Calendar.getInstance();
    }

}

package com.example.jdk.demo02interfaceupgrade;

/**
 * @author meteor
 */
public class Demo2UseStaticFunction {
    public static void main(String[] args) {
        BBB bbb = new BBB();
        // bbb.test01(); 不能使用
        //使用接口名.静态方法名调用
        AAA.test01();
    }
}

interface AAA {
    public static void test01() {
        System.out.println("我是接口AA的静态方法");
    }
}

//默认方法使用方式一: 实现类可以直接使用
class BBB implements AAA {
}
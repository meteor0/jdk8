package com.example.jdk.demo02interfaceupgrade;

import java.util.HashMap;
import java.util.Map;

public interface A {
    public abstract void test01();
    //public abstract void test02();

}
class  B implements  A{

    @Override
    public void test01() {
        System.out.println("B test01");
    }

}
class C implements  A{

    @Override
    public void test01() {
        System.out.println("C test01");

    }
}

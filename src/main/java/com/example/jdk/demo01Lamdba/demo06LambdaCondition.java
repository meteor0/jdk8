package com.example.jdk.demo01Lamdba;

/**
 * @author meteor
 */
public class demo06LambdaCondition {
    public static void main(String[] args) {
        test(()-> System.out.println("我会飞了"));

    }

    public static void test(Flyable flyable){
        flyable.fly();;
    }
    Flyable f = ()->{
        System.out.println("我会飞了");
    };
    /**
     只有一个抽象方法的接口称为函数式接口,我们就能使用Lambda表达式
     @FunctionalInterface 检测这个接口是不是只有一个抽象方法
     */
    @FunctionalInterface
    interface Flyable{
        public abstract void fly();
    }
}
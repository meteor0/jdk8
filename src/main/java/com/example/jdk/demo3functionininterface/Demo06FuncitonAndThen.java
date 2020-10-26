package com.example.jdk.demo3functionininterface;

import java.util.function.Function;

/**
 * @author meteor
 */
public class Demo06FuncitonAndThen {
    public static void main(String[] args) {
        System.out.println("开始了");
        getNum((String str) -> {
            return Integer.parseInt(str);
        }, (Integer integer) -> {
            return integer * 5;
        });
    }

    private static void getNum(Function<String, Integer> function1, Function<Integer, Integer> function2) {
        System.out.println("aa");
        Integer num1 = function1.andThen(function2).apply("20");
       // Integer num2 = function2.apply(num1);
        System.out.println("num1= " + num1);
    }
}

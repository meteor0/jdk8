package com.example.jdk.demo3functionininterface;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author meteor
 */
public class Demo05Funciton {
    public static void main(String[] args) {
        System.out.println("开始了");
        getNum((String str)->{
            return Integer.parseInt(str);
        });
    }

    private static void getNum(Function<String,Integer> function){
        System.out.println("aa");
       Integer num1= function.apply("20");
        System.out.println("num1= " + num1);
    }
}

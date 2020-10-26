package com.example.jdk.demo3functionininterface;

import java.util.function.Consumer;

/**
 * @author meteor
 */
public class Demo04Comsumer {
    public static void main(String[] args) {
        System.out.println("开始了");
        printMax((String str)->{
            System.out.println(str.toUpperCase());
        });

    }

    private static void printMax(Consumer<String> consumer){
        System.out.println("aa");
         consumer.accept("hello world");
    }
}

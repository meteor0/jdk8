package com.example.jdk.demo3functionininterface;

import java.util.function.Consumer;

/**
 * @author meteor
 */
public class Demo03ComsumerAndThen {
    public static void main(String[] args) {
        System.out.println("开始了");
        printMax((String str)->{
            System.out.println(str.toLowerCase());
        },(String str)->{
            System.out.println(str.toUpperCase());
        });
    }

    private static void printMax(Consumer<String> consumer1,Consumer<String> consumer2){
        System.out.println("aa");
        String str = "Hello World";
       // consumer1.accept(str);
       // consumer2.accept(str);
        consumer1.andThen(consumer2).accept(str);
    }
}

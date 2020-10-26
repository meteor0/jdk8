package com.example.jdk.demo3functionininterface;

import java.util.Arrays;
import java.util.function.Supplier;

public class Demo02Supplier {
    //使用lambda表达式返回数组最大元素
    public static void main(String[] args) {
        System.out.println("开始了");
        printMax(()->{
            int [] arr = {11,2,3,45,54,99};

            return arr[arr.length-1];
        });

    }

    private static void printMax(Supplier<Integer> supplier){
        System.out.println("aa");
        int max = supplier.get();
        System.out.println("max:"+ max);
    }
}

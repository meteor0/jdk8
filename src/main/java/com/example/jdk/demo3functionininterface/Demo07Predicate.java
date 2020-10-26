package com.example.jdk.demo3functionininterface;

import java.util.function.Predicate;

public class Demo07Predicate {
    public static void main(String[] args) {
        idLongName((String name) ->{
           return name.length()>3;
        });

    }

    public static void idLongName (Predicate<String> predicate){
        System.out.println("aa");
        boolean isLong = predicate.test("迪丽热巴");
        System.out.println(isLong);
    }
}

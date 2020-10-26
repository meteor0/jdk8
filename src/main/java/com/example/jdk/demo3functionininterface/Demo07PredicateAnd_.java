package com.example.jdk.demo3functionininterface;

import java.util.function.Predicate;

public class Demo07PredicateAnd_ {
    public static void main(String[] args) {
        test((String name) ->{
           return name.contains("迪");
        },(String name ) ->{
            return name.contains("热");
        });

    }

    public static void test (Predicate<String> predicate1,Predicate<String> predicate2){
        System.out.println("aa");
        String str = "迪丽热巴";
        boolean test = predicate1.and(predicate2).test(str);
        predicate1.negate().test(str);

        boolean b1 = predicate1.test(str);
        boolean b2= predicate2.test(str);
        if(b1 && b2){
            System.out.println("对,我是迪丽热巴");
        }
    }
}

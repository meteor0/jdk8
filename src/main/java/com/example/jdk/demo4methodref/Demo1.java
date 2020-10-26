package com.example.jdk.demo4methodref;

import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Demo1 {
    public static void main(String[] args) {
        test03();
        test04();
        test05();
    }

    public void test01(){
        Date now = new Date();

        Supplier<Long> su1 = ()->{
            return now.getTime();
        };
        Supplier<Long> su2  =now:: getTime;
        Long aLong = su1.get();
        System.out.println("aLong="+aLong);
    }

    public void test02(){
        Supplier<Long> su1 = ()->{
            return System.currentTimeMillis();
        };
        Long aLong = su1.get();
        System.out.println("aLong="+aLong);

        Supplier<Long> su2  =System::currentTimeMillis;
        Long aLong2 = su2.get();
        System.out.println("aLong2="+aLong2);
    }

    public static void test03(){
        Function<String,Integer> su1 = (String str)->{
            return str.length();
        };
        Integer count = su1.apply("hello");
        System.out.println("count="+count);

        //类名:: 实例方法(注意: 类名::实例方法 实例方法实际上会将第一个参数作为方法的调用者)
        Function<String,Integer> su2  =String::length;
        Integer count2 = su2.apply("hello");
        System.out.println("count2="+count2);

        //类名:: 实例方法(注意: 类名::实例方法 实例方法实际上会将第一个参数作为方法的调用者)
        //BiFunction<String,Integer,String> bif2  =String::substring;
        BiFunction<String,Integer,String> bif2 = (String str,Integer index) ->{
                return str.substring(index);
        };
        String str2= bif2.apply("helloword",3);
        System.out.println("str2="+str2);
    }

    public static void test04(){

        Supplier<Person> person = ()->{
            return new Person();
        };
       // Supplier<Person> person = Person::new;
        Person person1 = person.get();
        System.out.println("person1="+person1);
        BiFunction<String,Integer,Person> bif = (String name,Integer age) ->{
            return new Person(name,age);
        };
        BiFunction<String,Integer,Person> bif2 =  Person:: new;
        Person p2 = bif2.apply("刘新", 29);
        System.out.println("p2="+p2);

    }

    public static void test05(){

        Function<Integer,int [] > f1 = (Integer index)->{
            return new int[index];
        };
        //Function<Integer,int [] > f1 = int[]::new;
        int[] arr = f1.apply(10);
        System.out.println("arr="+arr);

    }
}

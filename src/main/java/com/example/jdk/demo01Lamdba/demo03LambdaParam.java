package com.example.jdk.demo01Lamdba;

import java.util.*;

/**
 * @author meteor
 */
public class demo03LambdaParam {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("刘德华", 55, 178.7));
        personList.add(new Person("张学友", 56, 179.7));
        personList.add(new Person("郭富城", 57, 177.7));
        personList.add(new Person("黎明", 58, 176.7));

        /**
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        */
        Collections.sort(personList,(Person o1, Person o2)->{
            return o2.getAge() - o1.getAge();
        });
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
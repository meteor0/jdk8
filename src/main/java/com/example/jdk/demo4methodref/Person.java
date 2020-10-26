package com.example.jdk.demo4methodref;

/**
 * @author meteor
 */
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        System.out.println("我是有参构造方法,name="+name+",age="+age);
        this.name = name;
        this.age = age;
    }

    public Person() {
        System.out.println("我是无参构造方法");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

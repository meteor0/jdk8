package com.example.jdk.demo08repeatable;


/**
 * @author meteor
 */ //配置重复注解
@RepeatableMyTests("11")
@RepeatableMyTests("12")
public class Demo01 {
    public static void main(String[] args) throws NoSuchMethodException {
        //解析重复注解
        //getAnnotationsByType新增的api 用于获取重复的注解
        //获取类上的重复注解
        RepeatableMyTests[] annotationsByType = Demo01.class.getAnnotationsByType(RepeatableMyTests.class);
        for (RepeatableMyTests repeatableMyTest : annotationsByType) {
            System.out.println(repeatableMyTest);
        }
        //获取方法上的重复注解
        RepeatableMyTests[] annotationsByType2 = Demo01.class.getMethod("test01").getAnnotationsByType(RepeatableMyTests.class);
        for (RepeatableMyTests repeatableMyTest : annotationsByType2) {
            System.out.println(repeatableMyTest);
        }
    }

    @RepeatableMyTests("1")
    @RepeatableMyTests("2")
    public void test01() {

    }
}

package com.example.jdk.demo01Lamdba;

/**
 * Lambda的标准格式
 * Lambda是一个匿名函数,而函数想当于java中方法
 * (参数列表) -> {}
 * (参数列表):参数列表
 * -> 没有实际含义,起到连接的作用
 * {} 方法体
 *
 * @author meteor
 */
public class demo02LambdaUse {
    public static void main(String[] args) {
        goSwimming(new Swimmable() {
            @Override
            public void swimming() {
                System.out.println("我是匿名内部类的游泳");
            }
        });
        //以后我们看到方法中的参数是接口,就可以考虑用lambda表达式
        //我们可以这么认为,Lambda表达式就是对接口中的抽象方法重写
        goSwimming( (()->{
            System.out.println("我是lambda的游泳");

        }));

        goSmoking(new Smokeable(){
            @Override
            public int smoking(String name) {
                System.out.println("匿名内部类抽了"+"的烟");
                return 5;
            }
        });
        goSmoking((String name) ->{
            System.out.println("Lambda抽了"+"的烟");
            return 6;
        });
    }

    //参数有返回值的Lambda表达式
    private static void goSmoking(Smokeable smokeable) {
        int count = smokeable.smoking("中华");
        System.out.println("返回值"+count);
    }

    //参数无返回值的Lambda表达式
    private static void goSwimming(Swimmable swimmable) {
        swimmable.swimming();
    }
}
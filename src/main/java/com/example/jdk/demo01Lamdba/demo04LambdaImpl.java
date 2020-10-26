package com.example.jdk.demo01Lamdba;

/**
 * @author meteor
 */
public class demo04LambdaImpl {
    public static void main(String[] args) {
        // 匿名内部类在编译后会形成一个新的类,.$
//        goSwimming(new Swimmable() {
//            @Override
//            public void swimming() {
//                System.out.println("我是匿名内部类的游泳");
//            }
//        });
        //以后我们看到方法中的参数是接口,就可以考虑用lambda表达式
        //我们可以这么认为,Lambda表达式就是对接口中的抽象方法重写

        goSwimming((() -> {
            System.out.println("我是lambda的游泳");
        }));
    }


    //参数无返回值的Lambda表达式
    private static void goSwimming(Swimmable swimmable) {
        swimmable.swimming();
    }
}
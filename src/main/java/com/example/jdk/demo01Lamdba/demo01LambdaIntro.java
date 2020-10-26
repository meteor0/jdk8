package com.example.jdk.demo01Lamdba;

/**
 * @author meteor
 */
public class demo01LambdaIntro {
    public static void main(String[] args) {
        // 使用匿名内部类存在的问题
        //匿名内部类做了哪些事情
        //1.定义了一个没有接口名称的类
        //2. 这个类实现了runable接口
        //3.创建了这个类的队形
        // 使用匿名内部类语法是很溶于的
        // 其实我们最关注的是run方法和里面要执行的代码
        //lambda表达式提现的是函数式编程思想,只需要将要执行的代码放到函数中(函数就是类中的方法)
        ///Lambda就是一个匿名函数,我们只需要将要执行的代码放到Lambda表达式即可

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新线程执行代码啦");
            }
        }).start();
        //lambda表达式
        //lambda表达式的好处:可以简化匿名内部类,让代码更加简洁
        new Thread(()->{
            System.out.println("新线程执行代码啦");
        }).start();
    }


}

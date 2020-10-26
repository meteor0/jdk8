package com.example.jdk.demo06optional;

import java.util.Optional;

public class Test01 {
    public static void main(String[] args) {

    }

    /**
     * 创建一个Optional对象
     * of:只能传入一个具体的值,不能传入空
     * ofNullAble: 既可以传入集体值,也可以传入null
     * empty: 存入的就是null
     */
    public void test01(){
        //创建
        Optional<String> op1 = Optional.of("LX");
        Optional<String> op2 = Optional.ofNullable(null);
        Optional<String> op3 = Optional.empty();
        //使用

    }

    public String test02(){
        Optional<String> op1 = Optional.of("LX");
        Optional<String> op2 = Optional.ofNullable(null);
        /**
         * 存在的时候做什么
         * ifPresent: 如果有值就调用参数
         */
        op1.ifPresent( s->{
            System.out.println("有值:"+s);
        });
        return op1.map(s->
            s.toLowerCase()).map(s->
            s.toLowerCase()).orElse("null");
    }
}

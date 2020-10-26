package com.example.jdk.demo3functionininterface;

/**
 * @author meteor
 */
public class Demo01UseFunctionInterface {
    public static void main(String[] args) {
        test((int a, int b) -> {
            System.out.println(a + b);
        });
    }

    public static void test(Operation operation) {
        operation.getSum(1, 3);
    }
}

interface Operation {
    public abstract void getSum(int a, int b);
}

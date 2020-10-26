package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author meteor
 * 实现CommandLineRunner接口；容器启动之后，加载实现类的逻辑资源，已达到完成资源初始化的任务；
 */
@SpringBootApplication
public class JdkApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JdkApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        showAfterStartInfo();
    }

    private void showAfterStartInfo() {
        System.out.println("我要启动了");
    }
}

package com.example.jdk.demo08repeatable;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author meteor
 * <p>
 * 定义一个可重复的注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyTests.class)
public @interface RepeatableMyTests {
    String value();
}

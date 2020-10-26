package com.example.jdk.demo08repeatable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author meteor
 * <p>
 * 这是重复注解的容器
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTests {
    RepeatableMyTests[] value();
}

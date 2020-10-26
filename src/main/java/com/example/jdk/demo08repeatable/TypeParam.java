package com.example.jdk.demo08repeatable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author meteor
 */
@Target(ElementType.TYPE_PARAMETER)
public @interface TypeParam {
}

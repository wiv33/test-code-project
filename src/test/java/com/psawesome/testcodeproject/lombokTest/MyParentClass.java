package com.psawesome.testcodeproject.lombokTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * package: com.psawesome.testcodeproject.lombokTest
 * author: PS
 * DATE: 2020-03-08 일요일 23:56
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface MyParentClass {

}

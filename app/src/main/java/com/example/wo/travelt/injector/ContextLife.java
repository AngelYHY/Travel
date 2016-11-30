package com.example.wo.travelt.injector;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by freestar on 2016/11/3.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ContextLife {
    //注解属性   后为默认值
    String value() default "Application";
}

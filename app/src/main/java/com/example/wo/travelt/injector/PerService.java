package com.example.wo.travelt.injector;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by freestar on 2016/11/3.
 */
@Scope
@Retention(RUNTIME)
public @interface PerService {
}

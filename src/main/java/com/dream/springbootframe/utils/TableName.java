package com.dream.springbootframe.utils;

import java.lang.annotation.*;

/**
 * Created by guolele on 2018/5/29.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TableName {

    String value() default "";

}

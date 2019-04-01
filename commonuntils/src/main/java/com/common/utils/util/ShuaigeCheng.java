package com.common.utils.util;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ShuaigeCheng {
    int level() default 0;
}

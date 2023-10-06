package com.das.consultation.config.data;

import java.lang.annotation.*;

/**
 * created by jun on 2020/8/14
 * describe:多数据源注解
 * version 1.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    String value() default DataSourceNames.DZBL;
}

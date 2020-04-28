package com.dclup.annotation;

import com.dclup.enums.IdNameEnum;
import com.dclup.enums.TableNameEnum;
import com.dclup.enums.TypeNameEnum;

import java.lang.annotation.*;

/**
 * @author dclup
 * @Description 日志注解
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 操作方式 默认unknown
     */
    TypeNameEnum type() default TypeNameEnum.UNKNOWN;

    /**
     * 操作的表名 默认unknown
     */
    TableNameEnum table() default TableNameEnum.UNKNOWN;

    /**
     * 实体类的主键名 默认unknown
     */
    IdNameEnum id() default IdNameEnum.UNKNOWN;
}

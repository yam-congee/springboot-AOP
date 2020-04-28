package com.dclup.enums;

/**
 * @author dclup
 * @Description 操作类型名称
 * @create 2020-04-27 11:05
 **/
public enum TypeNameEnum {

    UNKNOWN("unknown"),
    INSERT("insert"),
    UPDATE("update"),
    DELETE("delete");

    private final String name;

    TypeNameEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

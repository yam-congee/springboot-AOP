package com.dclup.enums;

/**
 * @author Dongcl
 * @Description 数据库表名
 * @create 2020-04-27 11:03
 **/
public enum TableNameEnum {

    UNKNOWN("unknown"),
    USER("user"),
    DEPARTMENT("department");

    private final String name;

    TableNameEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

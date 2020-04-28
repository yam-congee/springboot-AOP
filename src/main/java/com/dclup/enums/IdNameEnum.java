package com.dclup.enums;

/**
 * @author dclup
 * @Description 操作那张表的主键名称
 **/
public enum IdNameEnum {

    UNKNOWN("unknown"),
    USER_ID("userId"),
    DEPARTMENT_ID("departmentId");

    private final String name;

    IdNameEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

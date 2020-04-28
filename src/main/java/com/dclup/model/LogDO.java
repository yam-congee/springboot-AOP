package com.dclup.model;

import lombok.Data;

/**
 * @author dclup
 * @Description 日志实体类
 **/
@Data
public class LogDO {

    /**
     * 主键
     */
    private Long oid;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 操作那个表中的主键
     */
    private Long tableId;

    /**
     * 操作方式
     */
    private String type;

    /**
     * 操作时间
     */
    private String time;

    /**
     * 操作人id
     */
    private Long userId;
}

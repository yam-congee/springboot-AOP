package com.dclup.model;

import lombok.Data;

/**
 * @author dclup
 * @Description 用户实体类
 **/
@Data
public class UserDO {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户姓名
     */
    private String userName;
}

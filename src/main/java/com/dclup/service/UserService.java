package com.dclup.service;

import com.dclup.model.UserDO;

import java.util.Map;

/**
 * @author dclup
 * @create 2020-04-27 09:58
 **/
public interface UserService {

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    Map<String, Object> getByPrimaryKey(Long userId);

    /**
     * 修改用户信息
     *
     * @param userDO
     * @return
     */
    Map<String, Object> updateByPrimaryKey(UserDO userDO);

    /**
     * 删除用户信息
     *
     * @param userId
     * @return
     */
    Map<String, Object> deleteByPrimaryKey(Long userId);
}

package com.dclup.dao;

import com.dclup.model.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author dclup
 * @Description 用户信息管理数据层
 **/

@Mapper
@Repository
public interface UserMapper {

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    Map<String, Object> getByPrimaryKey(@Param("userId") Long userId);

    /**
     * 修改用户信息
     *
     * @param userDO
     * @return
     */
    Integer updateByPrimaryKey(UserDO userDO);

    /**
     * 删除用户信息
     *
     * @param userId
     * @return
     */
    Integer deleteByPrimaryKey(@Param("userId") Long userId);

}

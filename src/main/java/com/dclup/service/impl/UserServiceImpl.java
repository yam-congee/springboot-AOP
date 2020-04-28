package com.dclup.service.impl;

import com.dclup.dao.UserMapper;
import com.dclup.model.UserDO;
import com.dclup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dclup
 * @Description 用户信息管理 服务层实现
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> getByPrimaryKey(Long userId) {
        return userMapper.getByPrimaryKey(userId);
    }

    /**
     * 修改用户信息
     *
     * @param userDO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> updateByPrimaryKey(UserDO userDO) {

        if (userMapper.updateByPrimaryKey(userDO) > 0) {
            return userMapper.getByPrimaryKey(userDO.getUserId());
        }

        HashMap<String, Object> result = new HashMap<>();
        result.put("result", "修改失败");
        return result;
    }

    /**
     * 删除用户信息
     *
     * @param userId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> deleteByPrimaryKey(Long userId) {
        HashMap<String, Object> result = new HashMap<>();

        if (userMapper.deleteByPrimaryKey(userId) > 0) {
            result.put("result", "删除成功");
        } else {
            result.put("result", "删除失败");
        }
        return result;
    }
}

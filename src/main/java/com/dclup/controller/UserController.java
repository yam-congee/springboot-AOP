package com.dclup.controller;

import com.dclup.annotation.Log;
import com.dclup.enums.TableNameEnum;
import com.dclup.enums.TypeNameEnum;
import com.dclup.model.UserDO;
import com.dclup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author dclup
 * @Description 用户信息
 **/

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取一位用户信息
     *
     * @param userId 用户id
     * @return
     */
    @GetMapping("/user/{userId}")
    public Map<String, Object> getByPrimaryKey(
            @PathVariable("userId") Long userId) {
        return userService.getByPrimaryKey(userId);
    }

    /**
     * 修改一位用户信息
     *
     * @param userDO
     * @param userId userId 用户id
     * @return
     */
    @PutMapping("/user/{userId}")
    @Log(table = TableNameEnum.USER, type = TypeNameEnum.UPDATE)
    public Map<String, Object> updateByPrimaryKey(
            @RequestBody UserDO userDO,
            @PathVariable("userId") Long userId) {
        userDO.setUserId(userId);
        return userService.updateByPrimaryKey(userDO);
    }

    /**
     * 删除一位用户信息
     *
     * @param userId userId 用户id
     * @return
     */
    @DeleteMapping("/user/{userId}")
    @Log(table = TableNameEnum.USER, type = TypeNameEnum.DELETE)
    public Map<String, Object> deleteByPrimaryKey(
            @PathVariable("userId") Long userId
    ) {
        return userService.deleteByPrimaryKey(userId);
    }

}

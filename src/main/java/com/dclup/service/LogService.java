package com.dclup.service;

import com.dclup.model.LogDO;

/**
 * @author dclup
 * @Description 日志服务层
 **/
public interface LogService {

    /**
     * 插入日志
     *
     * @param logDO
     * @return
     */
    void insertLog(LogDO logDO);
}

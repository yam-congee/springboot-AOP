package com.dclup.service.impl;

import com.dclup.dao.LogMapper;
import com.dclup.model.LogDO;
import com.dclup.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dclup
 * @Description 日志信息管理 服务层实现
 **/
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * 插入日志
     *
     * @param logDO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertLog(LogDO logDO) {
        if (logMapper.insertLog(logDO) > 0) {
            System.out.println("日志插入成功");
            return;
        }
        System.out.println("日志插入失败");
    }
}

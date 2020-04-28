package com.dclup.dao;

import com.dclup.model.LogDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author dclup
 * @Description 日志管理数据层
 **/

@Mapper
@Repository
public interface LogMapper {

    /**
     * 插入操作日志
     *
     * @param logDO
     * @return 受影响行数
     */
    Integer insertLog(LogDO logDO);
}

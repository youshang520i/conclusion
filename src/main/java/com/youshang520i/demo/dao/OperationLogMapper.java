package com.youshang520i.demo.dao;

import com.youshang520i.demo.log.model.OperationLogModel;

/**
 * @author youshang
 */
public interface OperationLogMapper {
    int deleteByPrimaryKey(String logId);

    int insert(OperationLogModel record);

    int insertSelective(OperationLogModel record);

    OperationLogModel selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(OperationLogModel record);

    int updateByPrimaryKey(OperationLogModel record);
}
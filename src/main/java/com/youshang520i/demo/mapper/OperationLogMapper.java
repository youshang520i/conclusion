package com.youshang520i.demo.mapper;

import com.youshang520i.demo.annotation.log.model.OperationLogModel;

import java.util.List;

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

    List<OperationLogModel> querylist();
}
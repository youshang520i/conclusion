package com.youshang520i.demo.annotation.service;

import com.youshang520i.demo.annotation.log.model.OperationLogModel;

import java.util.List;

/**
 * @author youshang
 */
public interface OperationLogService {

    int insertSelective(OperationLogModel record);

    List<OperationLogModel> queryList();


}

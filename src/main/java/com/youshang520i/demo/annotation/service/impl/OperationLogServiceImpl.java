package com.youshang520i.demo.annotation.service.impl;

import com.youshang520i.demo.annotation.service.OperationLogService;
import com.youshang520i.demo.mapper.OperationLogMapper;
import com.youshang520i.demo.annotation.log.model.OperationLogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author youshang
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    private OperationLogMapper logMapper;

    @Override
    public int insertSelective(OperationLogModel record){
        return logMapper.insertSelective(record);
    }

    @Override
    public List<OperationLogModel> queryList(){
        return logMapper.querylist();
    }
}

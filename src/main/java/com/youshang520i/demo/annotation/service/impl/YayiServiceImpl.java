package com.youshang520i.demo.annotation.service.impl;

import com.youshang520i.demo.annotation.log.aspect.OpContextHolder;
import com.youshang520i.demo.model.CacheRedis;
import com.youshang520i.demo.annotation.service.YayiService;
import com.youshang520i.demo.annotation.log.model.OperationLogModel;
import org.springframework.stereotype.Service;

@Service
public class YayiServiceImpl implements YayiService {
    @Override
    @CacheRedis(key = "say",expireTime = 11)
    public Integer say(Integer num) {
        System.out.println("say->num :" + num);
        return num;
    }

    @Override
    @CacheRedis(key = "example")
    public String example(String str) {
        return str;
    }

    @Override
    public OperationLogModel log(OperationLogModel logModel){
        OpContextHolder.set("xxxxxxxx");
        OperationLogModel operationLogModel = new OperationLogModel();
        return operationLogModel;
    }

}

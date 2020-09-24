package com.youshang520i.demo.annotation.service;

import com.youshang520i.demo.log.model.OperationLogModel;

public interface YayiService {

    Integer say(Integer num);

    String example(String str);

    OperationLogModel log(OperationLogModel logModel);
}

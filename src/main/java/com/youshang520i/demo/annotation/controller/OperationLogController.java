package com.youshang520i.demo.annotation.controller;

import com.youshang520i.demo.annotation.service.YayiService;
import com.youshang520i.demo.log.aspect.OperationLog;
import com.youshang520i.demo.log.model.OperationLogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author youshang
 */
@RequestMapping("/log")
@RestController
public class OperationLogController {

    @Autowired
    private YayiService yayiService;

    @PostMapping("/addExample")
    @OperationLog(modelType = 100,modelName = "测试数据",operateType= 1)
    public Map<Object, Object> addExample(@RequestBody OperationLogModel logModel){
        HashMap<Object, Object> map = new HashMap<>();
        OperationLogModel log = yayiService.log(logModel);

        map.put("data",log);
        map.put("code",0);
        map.put("message","成功");
        return map;
    }


}

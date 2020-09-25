package com.youshang520i.demo.annotation.controller;

import com.youshang520i.demo.annotation.service.OperationLogService;
import com.youshang520i.demo.annotation.service.YayiService;
import com.youshang520i.demo.annotation.log.aspect.OperationLog;
import com.youshang520i.demo.annotation.log.model.OperationLogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author youshang
 */
@RequestMapping("/log")
@RestController
public class OperationLogController {

    @Autowired
    private YayiService yayiService;
    @Autowired
    private OperationLogService logService;

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

    @GetMapping("/queryList")
    public Map<Object, Object> queryList(){
        HashMap<Object, Object> map = new HashMap<>();

        List<OperationLogModel> operationLogModels = logService.queryList();
        map.put("data",operationLogModels);
        map.put("code",0);
        map.put("message","成功");
        return map;
    }

}

package com.youshang520i.demo.beanassemble.controller;

import cn.hutool.core.util.StrUtil;
import com.youshang520i.demo.beanassemble.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试bean的resource，Autowired装配
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    /**
     * 通过 Spring 提供的Autowired装配，默认按照类型装配
     */
    @Qualifier(value = "xiaoLiStudentServiceImpl")
    @Autowired
    private TeacherService teacherService;


    /**
     * 通过jdk 1.5+ 提供的Resource注入bean，通过name注入
     * @param name
     * @return
     */
//    @Resource(name = "xiaoLiStudentServiceImpl")
//    private TeacherService teacherService;


    @GetMapping("/{name}")
    public Map getTeacherService(@PathVariable String name) {
        Map<Object, Object> map = new HashMap<>();
        map.put("data","失败");
        map.put("code","0");

        String english = teacherService.english(name);
        if (StrUtil.isNotEmpty(english)){
            map.put("data",english);
            map.put("code","200");
        }
        return map;
    }
}

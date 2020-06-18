package com.youshang520i.demo.beanassemble.service.impl;

import com.youshang520i.demo.beanassemble.service.TeacherService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service(value = "xiaoLiStudentServiceImpl")
public class XiaoLiStudentServiceImpl implements TeacherService {
    @Override
    public String english(String name) {
        log.info(String.format("xiaoLi.english : %s",name));
        return name;
    }

    @Override
    public String language(String name) {
        log.info(String.format("xiaoLi.language : %s",name));
        return name;
    }
}

package com.youshang520i.demo.annotation.controller;

import com.youshang520i.demo.annotation.service.YayiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/yayi")
public class YayiController {

    @Autowired
    private YayiService yayiService;

//    @CacheEvict

    @RequestMapping(value = "/say")
    public Integer say() {
        return yayiService.say(10);
    }

    @RequestMapping(value = "/example")
    public String example() {
        return yayiService.example("yayi");
    }

}

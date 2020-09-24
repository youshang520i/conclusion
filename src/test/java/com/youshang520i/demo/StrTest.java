package com.youshang520i.demo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import org.junit.Test;

public class StrTest {

    @Test
    public void str_test(){
        long l = DateUtil.currentSeconds();
        System.out.println(l);
    }
}

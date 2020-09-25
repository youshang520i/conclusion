package com.youshang520i.demo.annotation.log.model;

import lombok.Data;

import java.util.Date;

/**
 * @author youshang
 */
@Data
public class OperationLogModel {
    /**
     * 操作日志主键
     */
    private String logId;
    /**
     * 模块类型 2 优惠券 3 地推信息 4轮播图 5金刚位 6场景运营 7特价活动 9用户充值 10 楼层配置
     */
    private Integer modelType;
    /**
     * 模块名称
     */
    private String modelName;
    /**
     * 操作类型 增删改
     */
    private Integer operateType;
    /**
     * 操作内容
     */
    private String content;
    /**
     * 附加字段
     */
    private String extra;
    /**
     * 操作人
     */
    private String operatorId;
    /**
     * 操作人名称
     */
    private String operatorName;
    /**
     * 操作日期
     */
    private Date createTime;


}


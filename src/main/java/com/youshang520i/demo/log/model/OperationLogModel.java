package com.youshang520i.demo.log.model;

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

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public Integer getModelType() {
        return modelType;
    }

    public void setModelType(Integer modelType) {
        this.modelType = modelType;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra == null ? null : extra.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}


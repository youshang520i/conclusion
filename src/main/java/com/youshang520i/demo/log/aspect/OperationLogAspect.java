package com.youshang520i.demo.log.aspect;

import cn.hutool.core.date.DateUtil;
import com.youshang520i.demo.annotation.service.OperationLogService;
import com.youshang520i.demo.log.model.OperationLogModel;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 自定义注解 使用自定义注解实现日志保存
 * @author youshang
 */
@Log4j2
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperationLogService operationLogService;

    /**
     * 切入点
     */
    @Pointcut(value = "@annotation(com.youshang520i.demo.log.aspect.OperationLog)")
    public void pointCut(){}

    /**
     * 后置通知
     * 使用@AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
     * @param operationLog
//     * @param result
     */

//    @AfterReturning(value = "pointCut() && @annotation(operationLog)")//,returning = "result"
//    public void after(OperationLog operationLog) {//, Object result
//
//        System.out.println("后置通知:" + result);
//    }

    /**
     * 环绕通知
     * @param joinPoint
     * @param operationLog
     * @return
     */
    @Order
    @Around("pointCut() && @annotation(operationLog)")
    public Object setOperationLog(ProceedingJoinPoint joinPoint, OperationLog operationLog) throws Throwable {
        Method method = getMethod(joinPoint);//自定义注解类\
        Object result = null;
        //执行方法
        try {
            result = joinPoint.proceed();
        }finally {
            try {
                OperationLogModel operationLogModel = new OperationLogModel();
                String extra = OpContextHolder.get() != null ? OpContextHolder.get().toString() : "";
                operationLogModel.setExtra(extra);
                operationLogModel.setLogId(DateUtil.currentSeconds()+"");
                operationLogModel.setCreateTime(DateUtil.date());
                operationLogModel.setModelName(operationLog.modelName());
                operationLogModel.setModelType(operationLog.modelType());
                operationLogModel.setOperateType(operationLog.operateType());
                operationLogModel.setOperatorId("10001");
                operationLogModel.setOperatorName("admin");
                operationLogModel.setContent(this.optimizeType(operationLogModel));
            }finally {
                OpContextHolder.remove();
            }
        }
        return result;
    }

    private Method getMethod(ProceedingJoinPoint joinPoint) {
        //获取参数的类型
        Method method = null;
        try {
            Signature signature = joinPoint.getSignature();
            MethodSignature msig = null;
            if (!(signature instanceof MethodSignature)) {
                throw new IllegalArgumentException("该注解只能用于方法");
            }
            msig = (MethodSignature) signature;
            method = joinPoint.getTarget().getClass().getMethod(msig.getName(), msig.getParameterTypes());
        } catch (NoSuchMethodException e) {
            log.error("annotation no sucheMehtod", e);
        } catch (SecurityException e) {
            log.error("annotation SecurityException", e);
        }
        return method;
    }
    private String optimizeType(OperationLogModel operationLogModel){
        String str = "";
        //操作类型  增删改 上线 下线
        Integer operateType = operationLogModel.getOperateType();
        //操作人名称
        String operatorName = operationLogModel.getOperatorName();
        //附加字段
        String extra = operationLogModel.getExtra();
        //[lijing] 上线 [f55381321619475784321333eb37a1f7]
        switch (operateType){
            case 1: //添加
                str = str.concat("[").concat(operatorName).concat("]").concat("添加").concat("[").concat(extra).concat("]");
                break;
            case 2: //删除
                str = str.concat("[").concat(operatorName).concat("]").concat("删除").concat("[").concat(extra).concat("]");
                break;
            case 3: //修改
                str = str.concat("[").concat(operatorName).concat("]").concat("修改").concat("[").concat(extra).concat("]");
                break;
            case 4: //上线
                str = str.concat("[").concat(operatorName).concat("]").concat("上线").concat("[").concat(extra).concat("]");
                break;
            case 5: //下线
                str = str.concat("[").concat(operatorName).concat("]").concat("下线").concat("[").concat(extra).concat("]");
                break;
            default:
                str = "当前的操作类型没有设置！！！请设置";
                break;
        }
        return str;
    }

    /**
     * 针对当前切点的异常捕捉
     * @param throwable
     */
    @AfterThrowing(value = "pointCut()" ,throwing = "throwable")
    public void throwingMethod(Throwable throwable){
        log.info(String.format("throwingMethod: %s",throwable.getLocalizedMessage()));
    }
}

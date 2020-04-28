package com.dclup.aop;

import com.dclup.annotation.Log;
import com.dclup.enums.IdNameEnum;
import com.dclup.model.LogDO;
import com.dclup.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author dclup
 * @Description 日志切面
 **/
@Aspect
@Component
public class LogAspect {

    @Autowired
    private LogService logService;

    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.dclup.annotation.Log)")
    // @Pointcut("execution(* com.dclup.service.impl.*.*(..))")
    public void pointcutLog() {
    }

    /**
     * 在原方法成功执行之后，再调用此通知。
     *
     * @param joinPoint
     */
    @AfterReturning("pointcutLog()")
    public void afterReturning(JoinPoint joinPoint) {
        insertLog(joinPoint);
    }


    /**
     * 进行插入日志
     *
     * @param joinPoint
     */
    private void insertLog(JoinPoint joinPoint) {
        // 获取切点方法上的注解
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Log annotation = method.getAnnotation(Log.class);

        // 获取表名和操作类型
        LogDO logDO = new LogDO();
        logDO.setTableName(annotation.table().getName());
        logDO.setType(annotation.type().getName());

        // 获取当前用户id
        /*
        ServletRequestAttributes  requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        Object userIdObject = requestAttributes.getRequest().getAttribute("currentUserId");
        Long currentUserId = Long.valueOf(String.valueOf(userIdObject));
        logDO.setUserId(currentUserId);
        */

        // 模拟获取当前用户
        logDO.setUserId(10086L);

        // 获取当前时间
        LocalDateTime nowTime = LocalDateTime.now();
        String formatNowTime = nowTime.format(DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss"));
        logDO.setTime(formatNowTime);

        //获取方法参数值(按方法定义参数的顺序：google查询)
        Object[] args = joinPoint.getArgs();

        //获取Controller中传入参数(按方法定义参数的顺序：手动测试)
        LocalVariableTableParameterNameDiscoverer nameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = nameDiscoverer.getParameterNames(method);

        //获取idName的值
        if (parameterNames != null && args != null) {

            for (int i = 0; i < parameterNames.length; i++) {
                if (IdNameEnum.USER_ID.getName().equals(parameterNames[i])) {
                    logDO.setTableId(Long.valueOf(String.valueOf(args[i])));
                }
            }
        }

        //保存日志
        logService.insertLog(logDO);
    }
}

package com.common.utils.util;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 拦截指定包下的所有方法
 */
public class ControllerAspectj {
    @Pointcut("execution(public * com.jf.platform.log.controller..*.*(..))")
    public void aop() {
        System.out.println("正在初始化-----------------------------");
    }

    @AfterReturning(returning = "ret", pointcut = "aop()")
    public void afterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("-------------------------");
        System.out.println(ret.getClass());
    }

}

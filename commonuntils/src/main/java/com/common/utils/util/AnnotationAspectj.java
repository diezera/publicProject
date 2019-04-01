package com.common.utils.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

@Aspect
@Component
/**
 * 利用注解的方式去aop
 */
public class AnnotationAspectj {
    @Pointcut("@annotation(com.common.utils.util.ShuaigeCheng)")
    public void aop() {

    }

    @AfterReturning(returning = "ret", pointcut = "aop()")
    public void afterReturning(JoinPoint joinPoint,Object ret) throws Throwable {
        // 处理完请求，返回内容
        MethodSignature signature=(MethodSignature) joinPoint.getSignature();
        Method method=signature.getMethod();
        Annotation  annoMethod=method.getAnnotation(ShuaigeCheng.class);

        if( ret instanceof  Collection){
            List<Object> retList=(List<Object>)ret;
            for (Object o:retList){
                doAspectj(annoMethod,o);
            }
        }else {
            doAspectj(annoMethod,ret);
        }


    }
    private  void  doAspectj(Annotation  annoMethod,Object ret)throws Throwable {
        Field[] fields = ret.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if( field.isAnnotationPresent(ShuaigeCheng.class)){
                Annotation annoField= field.getAnnotation(ShuaigeCheng.class);
                //等级低于conrtoller的属性清空
                if (((ShuaigeCheng) annoField).level()<((ShuaigeCheng) annoMethod).level()){
                    String type= field.getType().toString();
                    if (type.endsWith("boolean")) {
                        field.set(ret, false);
                    }else {
                        field.set(ret, null);
                    }
                }
            }


        }
    }


}

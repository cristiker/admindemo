package com.cristik.common.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 系统服务组件Aspect切面Bean
 * @author Shenghany
 * @date 2013-5-28
 */
@Component
@Aspect
@Order(1001)
public class TestAspect {

    @Pointcut("execution(* com.cristik.modules.service.*Service.*delete*(..))")
    public void aspect(){	}

    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        System.out.println("TestAspect--before");
    }

    @After("aspect()")
    public void after(JoinPoint joinPoint){
        System.out.println("TestAspect--after");
    }

    /*@Around("aspect()")
    public boolean around(JoinPoint joinPoint){
        System.out.println("TestAspect--around");
        return true;
    }*/

    @AfterReturning("aspect()")
    public void afterReturn(JoinPoint joinPoint){
        System.out.println("TestAspect--afterreturning");
    }

    @AfterThrowing(pointcut="aspect()", throwing="ex")
    public void afterThrow(JoinPoint joinPoint, Exception ex){
        System.out.println("TestAspect--afterthrow");
    }

}
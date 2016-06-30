package com.cristik.common.spring.aop;

import com.alibaba.fastjson.JSONArray;
import com.cristik.modules.test.entity.test.OperationLog;
import com.cristik.modules.test.entity.svo.User;
import com.cristik.modules.test.service.impl.OperationLogServiceImpl;
import com.cristik.common.base.SessionHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by zhenghua on 2016/3/29.
 * 前置通知→环绕通知→正常返回通知/异常返回通知→返回通知
 */
@Component
@Aspect
@Order(10003)
public class OperationLogsAspect {

    @Autowired
    OperationLogServiceImpl operationLogService;

    @Pointcut("execution(* com.cristik.modules.service.impl.*ServiceImpl.*insert*(..))")
    public void insertServiceCall(){
    }

    @Pointcut("execution(* com.cristik.modules.service.impl.*ServiceImpl.*delete*(..))")
    public void deleteServiceCall(){
    }

    @Pointcut("execution(* com.cristik.modules.service.impl.*ServiceImpl.*update*(..))")
    public void updateServiceCall(){
    }


    /*Insert*/
    @Before(value = "insertServiceCall()")
    public void insertServiceCallBefore(JoinPoint joinPoint)throws Throwable{
        String str = ArgsResolve(joinPoint);
        User user = SessionHelper.getUser();
        OperationLog log = new OperationLog();
        log.setContent(str);
        log.setCreatedate(new Date());
        log.setUserid(user!=null?user.getUserName():"无用户登录");
        log.setOperation("insert");
        operationLogService.log(log);
        System.out.println("insert操作已记录");
    }

    /*@Around(value = "insertServiceCall()")
    public void insertServiceCallAround()throws Throwable{
        System.out.println("aop-insert-around");
    }*/

    @After(value = "insertServiceCall()")
    public void insertServiceCallAfter(JoinPoint joinPoint)throws Throwable{
        String str = ArgsResolve(joinPoint);
        System.out.println("aop-insert-after");
    }

    @AfterReturning(value="insertServiceCall()")
    public Object insertServiceCallAfterReturnning(JoinPoint joinPoint) throws Throwable{
        String str = ArgsResolve(joinPoint);
        System.out.println("aop-insert-afterreturning");
        return null;
    }

    @AfterThrowing(value="insertServiceCall()")
    public void insertServiceCallAfterThrow(JoinPoint joinPoint) throws Throwable{
        String str = ArgsResolve(joinPoint);
        System.out.println("aop-insert-afterthrow");
    }


    /*delete*/
    @Before(value = "deleteServiceCall()")
    public void deleteServiceCallBefore(JoinPoint joinPoint)throws Throwable{
        String str = ArgsResolve(joinPoint);
        OperationLog log = new OperationLog();
        log.setContent(str);
        log.setCreatedate(new Date());
        log.setUserid(SessionHelper.getUser().getUserName());
        log.setOperation("delete");
        operationLogService.log(log);
        System.out.println("delete操作已记录");
    }


    @After(value = "deleteServiceCall()")
    public void deleteServiceCallAfter(JoinPoint joinPoint)throws Throwable{
        String str = ArgsResolve(joinPoint);
        System.out.println("aop-delete-after");
    }

    /*@Around(value = "deleteServiceCall()")
    public Object deleteServiceCallAround()throws Throwable{
        System.out.println("aop-delete-around");
        return new Object();
    }*/

    @AfterReturning(value="deleteServiceCall()")
    public boolean deleteServiceCallAfterReturnning(JoinPoint joinPoint) throws Throwable{
        String str = ArgsResolve(joinPoint);
        System.out.println("aop-delete-afterreturning");
        return true;
    }

    @AfterThrowing(value="deleteServiceCall()")
    public void deleteServiceCallAfterThrow(JoinPoint joinPoint) throws Throwable{
        String str = ArgsResolve(joinPoint);
        System.out.println("aop-delete-afterthrow");
    }



    /*update*/
    @Before(value = "updateServiceCall()")
    public void updateServiceCallBefore(JoinPoint joinPoint)throws Throwable{
        String str = ArgsResolve(joinPoint);
        OperationLog log = new OperationLog();
        log.setContent(str);
        log.setCreatedate(new Date());
        log.setUserid(SessionHelper.getUser().getUserName());
        log.setOperation("update");
        operationLogService.log(log);
        System.out.println("update操作已记录");
    }


    @After(value = "updateServiceCall()")
    public void updateServiceCallAfter(JoinPoint joinPoint)throws Throwable{
        String str = ArgsResolve(joinPoint);
        System.out.println("aop-update-after");
    }

    @AfterReturning(value="updateServiceCall()")
    public Object updateServiceCallAfterReturnning(JoinPoint joinPoint) throws Throwable{
        String str = ArgsResolve(joinPoint);
        System.out.println("aop-update-afterreturning");
        return null;
    }

    @AfterThrowing(value="updateServiceCall()")
    public void updateServiceCallAfterThrow(JoinPoint joinPoint) throws Throwable{
        String str = ArgsResolve(joinPoint);
        System.out.println("aop-update-afterthrow");
    }

    /**
     * 参数解析
     * @param joinPoint
     * @return
     */
    public String ArgsResolve(JoinPoint joinPoint){
        Object[] objects = joinPoint.getArgs();
        return JSONArray.toJSON(objects).toString();
    }


}

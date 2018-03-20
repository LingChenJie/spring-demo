package com.paxsz.h_annotation_aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//通知类
@Aspect
//表示该类是一个通知类
public class MyAdvice {

    @Pointcut("execution(* com.paxsz.service.*ServiceImpl.*(..))")
    public void pc() {
    }

    //前置通知
    @Before("MyAdvice.pc()")
    public void before() {
        System.out.println("这是前置通知!!");
    }

    //后置通知
    @AfterReturning("MyAdvice.pc()")
    public void afterReturning() {
        System.out.println("这是后置通知(如果出现异常不会调用)!!");
    }

    //环绕通知
    @Around("MyAdvice.pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("这是环绕通知之前的部分!!");
        Object proceed = pjp.proceed();//调用目标方法
        System.out.println("这是环绕通知之后的部分!!");
        return proceed;
    }

    //异常通知
    @AfterThrowing("MyAdvice.pc()")
    public void afterException() {
        System.out.println("出事啦!出现异常了!!");
    }

    //后置通知
    @After("MyAdvice.pc()")
    public void after() {
        System.out.println("这是后置通知(出现异常也会调用)!!");
    }

}

package com.sy.bbs.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component("logInterceptor")
public class LogInterceptor {
//	@Pointcut("execution(public * com.sy.bbs.service.impl..*.*(..))")
//	public void myMethod(){};
	
//	@Before("myMethod()")
	public void before() {
		System.out.println("method before");
	}
	
//	@After("myMethod()")
	public void after() {
		System.out.println("method after");
	}
	
//	@Around("myMethod()")
//	public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("method around start");
//		pjp.proceed();
//		System.out.println("method around end");
//	}
	
}

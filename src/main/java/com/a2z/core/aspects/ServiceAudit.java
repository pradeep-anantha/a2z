package com.a2z.core.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
public class ServiceAudit {

	@Around(  "execution(* com.a2z.rs.elasticsearch.ESController.*(..)) or "
			+ "execution(* com.a2z.core.cache.ICacheService.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around - Before: " + pjp.getSignature());
		Object response = pjp.proceed();
		System.out.println("around - After: " + pjp.getSignature());
		return response;
	}
}

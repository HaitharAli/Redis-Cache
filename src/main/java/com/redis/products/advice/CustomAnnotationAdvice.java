package com.redis.products.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAnnotationAdvice {

	Logger logger = LoggerFactory.getLogger(CustomAnnotationAdvice.class);

	@Around("@annotation(com.redis.products.advice.TrackExecutionTime)")
	public Object methodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object obj = joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		logger.info("Method name " + joinPoint.getSignature() + " execution time : " + (endTime - startTime) + " ms");
		return obj;
	}

}

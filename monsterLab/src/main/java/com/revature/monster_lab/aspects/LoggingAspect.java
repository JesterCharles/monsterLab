package com.revature.monster_lab.aspects;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private final Logger logger = LogManager.getLogger();
	
	@Pointcut("within(com.revature..*)")
	public void logAll() {
	}
	
	@Before("logAll()")
	public void logMethodStart(JoinPoint jp) {
		String methodSignature = extractMethodSignature(jp);
		String methodArguments = Arrays.toString(jp.getArgs());
		logger.info("{} invoked at {} with provided arguments: {}", methodSignature, LocalDateTime.now().toString(), methodArguments);
	}
	
	@AfterReturning(pointcut = "logAll()", returning = "returnedObject")
	public void logMethodReturn(JoinPoint jp, Object returnedObject) {
		String methodSignature = extractMethodSignature(jp);
		logger.info("{} successfully returned at {} with value: {}", methodSignature, LocalDateTime.now().toString(), returnedObject);
	}
	
	@AfterThrowing(pointcut = "logAll()", throwing = "t")
	public void logMethodException(JoinPoint jp, Throwable t) {
		String methodSignature = extractMethodSignature(jp);
		String throwableName = t.getClass().getName();
		logger.info("{} was thrown in method {} at {} with message: {}", throwableName, methodSignature, LocalDateTime.now().toString(), t.getMessage());
	}
	
	private String extractMethodSignature(JoinPoint jp) {
		return jp.getTarget().getClass().toString() + "#" + jp.getSignature().getName();
	}
}
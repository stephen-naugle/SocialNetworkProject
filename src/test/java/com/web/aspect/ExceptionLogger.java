package com.web.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLogger {

	private static Logger logger = Logger.getLogger(ExceptionLogger.class);
	
	@AfterThrowing(pointcut = "execution(* *(..))", throwing = "e")
	public void logException(Exception e) {
		logger.warn("Attempt failed: ", e);
	}
}

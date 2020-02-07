package org.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceAdvice {
	private static final Logger logger = LoggerFactory.getLogger(ServiceAdvice.class);
		
	@AfterReturning(pointcut="execution(* org.spring.service.*Service*.select*(..))", returning="rObj")
	public void afterLog(JoinPoint jp, Object rObj) {
		logger.info("return "+jp.getSignature().getName()+":"+rObj.toString());
	}

	
}

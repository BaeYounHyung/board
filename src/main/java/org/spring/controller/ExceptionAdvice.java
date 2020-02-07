package org.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러에서 발생하는 예외를 전문적으로 처리하는 클래스
@ControllerAdvice
public class ExceptionAdvice {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
	
	//처리하는 예외
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptCommon(Exception e) {
		logger.info("exception");
		logger.info(e.toString());
		ModelAndView MnV = new ModelAndView();
		MnV.setViewName("/errorCommon");
		MnV.addObject("exception", e);
		return MnV;
	}
}

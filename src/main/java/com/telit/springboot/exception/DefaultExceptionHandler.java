package com.telit.springboot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class DefaultExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);
	/**
	 * 只捕捉空指针异常，跳转到指定页面
	 * @param request
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(NullPointerException.class)
	public String urlException(HttpServletRequest request, NullPointerException exception){
		log.info("***************发生空指针异常***************");
		return "exception";
	}
}

package com.dj.sample.app.aop;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ControllerAdvice
@SuppressWarnings("javadoc")
public class SampleExceptionHandler extends ResponseEntityExceptionHandler{
	
	private final Logger slf4jLogger = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExceptionResult> handleConflict(Exception e) {

		this.slf4jLogger.error("Runtime exception occurred", e);
		ExceptionResult result = new ExceptionResult(400, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
				"Server Error", "Error at Content API service", e.getStackTrace());
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);

	}


}

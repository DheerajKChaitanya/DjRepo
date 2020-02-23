package com.dj.sample.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SuppressWarnings("javadoc")
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class LoggingHandler extends ResponseEntityExceptionHandler {

	private final Logger slf4jLogger = LoggerFactory.getLogger(this.getClass());

	private ObjectMapper mapper = new ObjectMapper();

	@Before("execution( *  com.cg.sample.app.controller..*(..))")
	public void controllerLogging(JoinPoint joint) throws Exception {

		this.mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			this.slf4jLogger.info("Begin of - " + joint.getStaticPart().getSignature().getName() + "method");
			this.slf4jLogger.info("Info Input Parameters -: \n "
					+ this.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joint.getArgs()));
		} catch (JsonProcessingException e) {
			this.logger.info(e.getLocalizedMessage());
		}

	}

	@AfterReturning(pointcut = "execution( *  com.cg.sample.app.controller..*(..))", returning = "result")
	public void serviceSetterMethodLogging(JoinPoint joint, Object result) throws Exception {

		this.mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {

			this.slf4jLogger.info("Info Output Parameters -: \n "
					+ this.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(null != result ? result : ""));
			this.slf4jLogger.debug("end of  - " + joint.getStaticPart().getSignature().getName() + " method");
		} catch (JsonProcessingException e) {
			this.logger.info(e.getLocalizedMessage());

		}
	}

}

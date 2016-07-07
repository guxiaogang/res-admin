package com.anz.res.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Description:
 * @author gyg
 * @date 2016
 * @version v1.0
 */

@ControllerAdvice
public class GlobalExceptionHandler {
	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(ServiceFailureException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ServiceFailureResponse handleServiceFailureException(ServiceFailureException exception) {
		ServiceFailureResponse response = new ServiceFailureResponse();
		response.setErrorCode(exception.getErrorCode());
		response.setErrorMessage(exception.getErrorMessage());
		response.setExtInfo(exception.getExtInfo());
		logger.error(exception.getMessage());
		return response;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ServiceFailureResponse handleException(Exception exception) {
		ServiceFailureResponse response = new ServiceFailureResponse();
		response.setErrorCode("500");
		response.setErrorMessage("Server Internal Error!");
		logger.error(exception.getMessage(), exception);
		return response;
	}
}

package com.anz.res.exception;

import java.io.Serializable;

/**
 * @Description:
 * @author gyg
 * @date 2016
 * @version v1.0
 */

public class ServiceFailureResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4532608236434515980L;
	private String errorCode;
	private String errorMessage;
	private Object extInfo;

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Object getExtInfo() {
		return extInfo;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setExtInfo(Object extInfo) {
		this.extInfo = extInfo;
	}
}

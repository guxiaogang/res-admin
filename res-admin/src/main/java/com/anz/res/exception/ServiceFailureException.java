package com.anz.res.exception;

/**
 * @Description:
 * @author gyg
 * @date 2016
 * @version v1.0
 */

public class ServiceFailureException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2332608236434515980L;
	public static ServiceFailureException INVALID_PAR = new ServiceFailureException("SFE_001", "Invalid parameter");

	private String errorCode;
	private String errorMessage;
	private Object extInfo;

	public ServiceFailureException() {
		super();
	}

	public ServiceFailureException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

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

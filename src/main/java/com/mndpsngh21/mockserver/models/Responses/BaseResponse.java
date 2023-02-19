package com.mndpsngh21.mockserver.models.Responses;

/**
 * 
 * @author mandeep
 *
 * Base class for all responses
 */
public class BaseResponse {

	String message;
	int responseCode;
	boolean isSuccess;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	
}

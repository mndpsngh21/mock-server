package com.mndpsngh21.mockserver.models.Responses;

public class SampleResponse extends BaseResponse{

	
	public SampleResponse() {
	}

	public SampleResponse(String value) {
		this.info=value;
	}
	
	String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
}

package com.search.job.rest.response;

public class SucessResponse extends BaseResponse {

	private static final long serialVersionUID = -8971784849628015082L;
	
	private Object payload;
	
	public SucessResponse(){
	}
	
	public SucessResponse(Object payload){
		this.payload = payload;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}
}

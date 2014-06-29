package com.search.job.rest.response;

import java.util.ArrayList;
import java.util.List;

public class FailureResponse extends BaseResponse {

	private static final long serialVersionUID = -4669306872054457073L;

	private List<Error> errors = new ArrayList<Error>();

	public FailureResponse(){
	}
	
	public FailureResponse(int statusCode, List<Error> errors ){
		setStatusCode(statusCode);
		this.errors = errors;
	}
	
	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
}

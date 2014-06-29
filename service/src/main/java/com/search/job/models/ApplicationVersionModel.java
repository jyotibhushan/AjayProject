package com.search.job.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ApplicationVersionModel")
public class ApplicationVersionModel extends SearchJobBaseModel {

	@Id
	private String id;

	@Indexed
	private String apiKey;

	@Indexed
	private String apiVersion;
	
	
	public ApplicationVersionModel(){
	}
	
	public ApplicationVersionModel(String apiKey, String apiVersion){
		this.apiKey = apiKey;
		this.apiVersion = apiVersion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
}

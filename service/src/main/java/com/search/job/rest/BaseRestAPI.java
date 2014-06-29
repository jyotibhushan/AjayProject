package com.search.job.rest;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.search.job.utils.CoreBeanFactory;

public class BaseRestAPI {
	
	public MongoTemplate getMongoTemplate(){
		return (MongoTemplate) CoreBeanFactory.getBean("mongoTemplate");
	}
}

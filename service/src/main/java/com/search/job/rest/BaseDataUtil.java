package com.search.job.rest;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.search.job.utils.CoreBeanFactory;

public class BaseDataUtil {
	
	public static MongoTemplate getMongoTemplate(){
		return (MongoTemplate) CoreBeanFactory.getBean("mongoTemplate");
	}
}

package com.search.job.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CoreBeanFactory implements ApplicationContextAware {
	
	static ApplicationContext appContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		CoreBeanFactory.appContext = applicationContext;
	}

	public static Object getBean(String beanName){
		return appContext.getBean(beanName);
	}
}

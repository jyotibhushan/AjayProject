package com.search.listener.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.search.job.utils.PropertyUtil;

public class ApplicationParamListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("STATIC_RESOURCE_BASE_URL", PropertyUtil.getProperty("static.resource.baseUrl"));
		sce.getServletContext().setAttribute("STATIC_CONTENT_VERSION", PropertyUtil.getProperty("static.content.version"));
	}
}

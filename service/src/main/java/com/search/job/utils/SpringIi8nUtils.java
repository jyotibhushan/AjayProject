package com.search.job.utils;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ResourceBundleMessageSource;

public class SpringIi8nUtils implements ApplicationContextAware, InitializingBean {
	
	public static final String DEFAULT_MESSAGE_BUNDLE = "META-INF/*-bundle/messages";

	private static ApplicationContext appContext;
	private static String messageBundle = DEFAULT_MESSAGE_BUNDLE;

	@Override
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		SpringIi8nUtils.appContext = appContext;
	}
	
	public static String getMessage(String code, String... args) {
		return getMessage(code, args, null);
	}
	
	public static String getMessage(String code) {
		return getMessage(code, new Object[] {}, null);
	}

	protected static String getMessage(String code, Object[] args) {
		return getMessage(code, args, null);
	}

	protected static String getMessage(String code, Object[] args, Locale locale) {
		if (locale == null)
			locale = Locale.US; // Default to US Locale. Locale.getDefault();
		return appContext.getMessage(code, args, locale);
	}

	public void setMessageBundle(String messageBundle) {
		SpringIi8nUtils.messageBundle = messageBundle;
	}

	/**
	 * Hook up a message bundle to the message source.
	 * <p>
	 * Evaluate wildcards before hooking the bundle to the source.
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		String[] s = DiscoverUtils.discoverResource(messageBundle + "*");
		Set<String> set = new HashSet<String>();
		for (String s1 : s) {
			set.add(s1.substring(0, s1.indexOf("_")));
		}
		s = set.toArray(new String[set.size()]);
		ResourceBundleMessageSource messageSource = (ResourceBundleMessageSource) appContext.getBean("messageSource");
		messageSource.setBasenames(s);
	}
}

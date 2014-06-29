package com.search.job.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertyUtil extends PropertyPlaceholderConfigurer {

	private static Map<String, String> propertiesMap;
	private int springSystemPropertiesMode = SYSTEM_PROPERTIES_MODE_FALLBACK;

	@Override
	public void setSystemPropertiesMode(int systemPropertiesMode) {
		super.setSystemPropertiesMode(systemPropertiesMode);
		springSystemPropertiesMode = systemPropertiesMode;
	}

	public void refreshMap(Configuration config) {
		Iterator itr = config.getKeys();
		while (itr.hasNext()) {
			String key = String.valueOf(itr.next());
			String value = String.valueOf(config.getProperty(key));
			logger.debug("Key is - " + key + " and Value - " + value);
			propertiesMap.put(key, value);
		}
	}

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {
		super.processProperties(beanFactory, props);
		propertiesMap = new HashMap<String, String>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String valueStr = resolvePlaceholder(keyStr, props, springSystemPropertiesMode);
			propertiesMap.put(keyStr, valueStr);
		}
	}

	public static boolean getBooleanProperty(String name) {
		if (propertiesMap.get(name) == null) {
			return false;
		}
		return Boolean.parseBoolean(propertiesMap.get(name));
	}

	public static String getProperty(String name) {
		if (propertiesMap.get(name) == null) {
			return null;
		}
		return propertiesMap.get(name).toString();
	}

	public static String getProperty(String name, String defaultValue) {
		final String propValue = propertiesMap.get(name);
		if (StringUtils.isBlank(propValue)) {
			return defaultValue;
		} else {
			return propValue;
		}
	}
}

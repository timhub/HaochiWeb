package com.haochi.service.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertyUtils {

	private Properties prop;
	private InputStream inputStream;
	private Set<Object> keyValues;
	
	private static boolean initialized;
	
	private static PropertyUtils instance;
	
	public static PropertyUtils getInstance() {
		if(!initialized) {
			instance = new PropertyUtils();
		}
		
		return instance;
	}
	
	public PropertyUtils() {
		prop = new Properties();
		inputStream = getClass().getResourceAsStream(CommonConstants.PROPERTY_CN_NAME);
		try {
			prop.load(inputStream);
			keyValues = prop.keySet();
		} catch (IOException e) {
			e.printStackTrace();
		}
		initialized = true;
	}
	
	/**
	 * Return the value of the corresponding key.
	 * @param key key name.
	 * @return
	 */
	public String getProperty(String key) {
		String result = null;
		if(keyValues.contains(key)) {
			result = prop.getProperty(key);
		}
		
		return result;
	}
}

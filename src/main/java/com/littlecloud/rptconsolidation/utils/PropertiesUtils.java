package com.littlecloud.rptconsolidation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtils {
	private static final Logger log = LoggerFactory.getLogger(PropertiesUtils.class);

	public static Properties readPropertiesByJavaRuntimeVariable(String systemRuntimeVariable) {
		Properties properties = null;
		// try to get it from java runtime variable
		try {
			String fileName = System.getProperty(systemRuntimeVariable);
			if (fileName != null && !fileName.isEmpty()){
				File propertyFile = new File(fileName);
				if (propertyFile.exists()) {
					FileInputStream is = new FileInputStream(propertyFile);
					if (is != null){
						properties = new Properties();
						properties.load(is);
						is.close();
					}
				}
			}
		} catch (Exception e){
			log.error("PropertyUtils.readPropertiesByJavaRuntimeVariable() - Exception: ", e);
		}	
		return properties;
	}

	public static Properties readPropertiesBySystemResource(String defaultSystemResource){
		Properties properties = null;
		// try to get it from system resources variable
		try{
			InputStream is = ClassLoader.getSystemResourceAsStream(defaultSystemResource);
			if (is != null){
				properties = new Properties();
				properties.load(is);
				is.close();
			}

		} catch (Exception e) {
			log.error("PropertyUtils.readPropertiesBySystemResource() - Exception: ", e);
		}
		return properties;
	}	
}

package com.littlecloud.rptconsolidation.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.littlecloud.control.json.util.DateUtils;
import com.littlecloud.pool.utils.PropertyLoader;

public class SystemUtils {
	private static final Logger log = LoggerFactory.getLogger(SystemUtils.class);
	public static void loadLittleCloudProperties(){
		try{
			PropertyLoader.getInstance();	
			DateUtils.loadTimeZones();
		} catch (Exception e){
			log.error("SystemUtils.loadLittleCloudProperties() - Exception:", e);
		}
	}
}

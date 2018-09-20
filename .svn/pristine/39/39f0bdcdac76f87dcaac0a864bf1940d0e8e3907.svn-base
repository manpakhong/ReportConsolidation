package com.littlecloud.systems.impls;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.littlecloud.rptconsolidation.eos.DbBundles;
import com.littlecloud.rptconsolidation.utils.PropertiesUtils;
import com.littlecloud.systems.BundlesLoader;

public class BundlesLoaderDbBundlesImpl implements BundlesLoader <DbBundles>{
	private static final Logger log = LoggerFactory.getLogger(BundlesLoaderDbBundlesImpl.class);
	private static final String PROPERTIES_JAVA_RUNTIME = "system.properties";
	private static final String PROPERTIES_SYSTEM_RESOURCE = "system.properties";
	private static Properties properties;
	private static DbBundles dbBundles;
	private void loadInstanceOfSystemProperties(){
		try{
			if (properties == null){
				properties = new Properties();
				properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES_SYSTEM_RESOURCE));
			}
			if (properties == null){
				properties = PropertiesUtils.readPropertiesByJavaRuntimeVariable(PROPERTIES_JAVA_RUNTIME);
			}
			if (properties == null){
				properties = PropertiesUtils.readPropertiesBySystemResource(PROPERTIES_SYSTEM_RESOURCE);
			}
		} catch (Exception e){
			log.error("BundlesLoaderDbBundlesImpl.loadInstanceOfSystemProperties()", e);
		}
	}
	@Override
	public DbBundles getBundleDto() {
		if (dbBundles == null){
			loadInstanceOfSystemProperties();
			if (properties != null){
				dbBundles = new DbBundles();
				dbBundles.setHost(properties.getProperty("db.bscommon.host", "bs1db.dev.pepwave.com"));
				dbBundles.setUser(properties.getProperty("db.bscommon.user", "root"));
				dbBundles.setPassword(properties.getProperty("db.bscommon.password", "pepl2302"));
				dbBundles.setPort(properties.getProperty("db.bscommon.port", "3306"));
				dbBundles.setSchema(properties.getProperty("db.bscommon.schema", "bs_common_db"));
			}
		}
		return dbBundles;
	}
}

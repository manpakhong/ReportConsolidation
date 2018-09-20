package com.littlecloud.systems.impls;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.littlecloud.rptconsolidation.eos.SystemParamsBundles;
import com.littlecloud.rptconsolidation.utils.PropertiesUtils;
import com.littlecloud.systems.BundlesLoader;
import com.littlecloud.utils.CommonUtils;

public class BundlesLoaderSystemBundlesImpl implements BundlesLoader<SystemParamsBundles> {
	private static final Logger log = LoggerFactory.getLogger(BundlesLoaderDbBundlesImpl.class);
	private static final String PROPERTIES_JAVA_RUNTIME = "system.properties";
	private static final String PROPERTIES_SYSTEM_RESOURCE = "system.properties";
	private static Properties properties;
	private static SystemParamsBundles bundleDto;
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
			log.error("BundlesLoaderSystemBundlesImpl.loadInstanceOfSystemProperties()", e);
		}
	}
	@Override
	public SystemParamsBundles getBundleDto() {
		if (bundleDto == null){
			loadInstanceOfSystemProperties();
			if (properties != null){
				bundleDto = new SystemParamsBundles();
				String consumerMaxThreadPool = properties.getProperty("com.littlecloud.rptconsolidation.factories.CONSUMER_MAX_THREAD_POOL", "5");
				String consumerThreadSleep = properties.getProperty("com.littlecloud.rptconsolidation.factories.CONSUMER_THREAD_SLEEP", "10000");
				if (CommonUtils.isInteger(consumerMaxThreadPool)){
					Integer consumerMaxThreadPoolInt = new Integer(consumerMaxThreadPool);
					bundleDto.setConsumerMaxThreadPool(consumerMaxThreadPoolInt);					
				}
				if (CommonUtils.isInteger(consumerThreadSleep)){
					Integer consumerMaxThreadPoolInt = new Integer(consumerThreadSleep);
					bundleDto.setConsumerThreadSleep(consumerMaxThreadPoolInt);						
				}
				
				String providerMaxThreadPool = properties.getProperty("com.littlecloud.rptconsolidation.factories.PROVIDER_MAX_THREAD_POOL", "1");
				String providerThreadSleep = properties.getProperty("com.littlecloud.rptconsolidation.factories.PROVIDER_THREAD_SLEEP", "20000");
				if (CommonUtils.isInteger(providerMaxThreadPool)){
					Integer providerMaxThreadPoolInt = new Integer(providerMaxThreadPool);
					bundleDto.setProviderMaxThreadPool(providerMaxThreadPoolInt);					
				}
				if (CommonUtils.isInteger(providerThreadSleep)){
					Integer providerMaxThreadPoolInt = new Integer(providerThreadSleep);
					bundleDto.setProviderThreadSleep(providerMaxThreadPoolInt);						
				}
				
				
				String blockQueueSize = properties.getProperty("com.littlecloud.rptconsolidation.factories.BLOCK_QUEUE_SIZE", "100");
				if (CommonUtils.isInteger(blockQueueSize)){
					Integer blockQueueSizeInt = new Integer(blockQueueSize);
					bundleDto.setQueueSize(blockQueueSizeInt);						
				}
				
			}
		}
		return bundleDto;
	}
}

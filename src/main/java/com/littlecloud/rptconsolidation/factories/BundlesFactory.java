package com.littlecloud.rptconsolidation.factories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.littlecloud.rptconsolidation.eos.DbBundles;
import com.littlecloud.rptconsolidation.eos.SystemParamsBundles;
import com.littlecloud.systems.BundlesLoader;
import com.littlecloud.systems.impls.BundlesLoaderDbBundlesImpl;
import com.littlecloud.systems.impls.BundlesLoaderSystemBundlesImpl;

public class BundlesFactory {
	private static final Logger log = LoggerFactory.getLogger(BundlesFactory.class);
	private static DbBundles dbBundles;
	private static SystemParamsBundles systemParamsBundles;
	
	public static DbBundles getDbBundlesInstance(){
		try{
			if (dbBundles == null){
				BundlesLoader <DbBundles> bundlesLoader = new BundlesLoaderDbBundlesImpl();
				dbBundles = bundlesLoader.getBundleDto();
			}
		} catch (Exception e){
			log.error("BundlesFactory.getDbBundlesInstance() - Exception: ", e);
		}
		return dbBundles;
	}
	
	public static SystemParamsBundles getSystemParamsBundlesInstance(){
		try{
			if (systemParamsBundles == null){
				BundlesLoader <SystemParamsBundles> bundlesLoader = new BundlesLoaderSystemBundlesImpl();
				systemParamsBundles = bundlesLoader.getBundleDto();
			}
		} catch (Exception e){
			log.error("BundlesFactory.getSystemParamsBundlesInstance() - Exception: ", e);
		}
		return systemParamsBundles;
	}
}

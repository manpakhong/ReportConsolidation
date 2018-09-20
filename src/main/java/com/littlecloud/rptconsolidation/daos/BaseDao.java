package com.littlecloud.rptconsolidation.daos;

import java.sql.Connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.littlecloud.rptconsolidation.factories.CommonBsDbConnFactory;
import com.littlecloud.rptconsolidation.factories.CommonBsDbConnFactoryUnitTest;

public class BaseDao {
	private static final Logger log = LoggerFactory.getLogger(BaseDao.class);
	public static final String MODE_PRODUCTION = "MODE_PRODUCTION";
	public static final String MODE_UNITTEST = "MODE_UNITTEST";
	protected Connection conn;
	protected String mode;
	public BaseDao(){
		mode = MODE_PRODUCTION;
		init();
	}
	public BaseDao(String mode){
		this.mode = mode;
		init();
	}
	private void init(){
		try{
			if (mode.equals(MODE_PRODUCTION)){
				conn = CommonBsDbConnFactory.getConnectionInstance();
			} else {
				conn = CommonBsDbConnFactoryUnitTest.getConnectionInstance();
			}
		} catch (Exception e){
			log.error("BaseDao.init() - ", e);
		}
	}
}

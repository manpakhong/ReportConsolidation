package com.littlecloud.rptconsolidation.factories;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonBsDbConnFactory {
	private static final Logger log = LoggerFactory.getLogger(CommonBsDbConnFactory.class);
	private static Connection conn;
	public static Connection getConnectionInstance(){
		try{
			if (conn == null){
				Context initContext = new InitialContext();
				Context envContext  = (Context)initContext.lookup("java:/comp/env");
				DataSource ds = (DataSource)envContext.lookup("jdbc/mysql_bs_common");
				conn = ds.getConnection();
			}
		} catch (Exception e){
			log.debug("CommonBsDbConnFactory.getConnectionInstance() - ", e);
		}
		return conn;
	}
}

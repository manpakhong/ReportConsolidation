package com.littlecloud.rptconsolidation.factories;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.littlecloud.rptconsolidation.eos.DbBundles;
import com.littlecloud.systems.BundlesLoader;
import com.littlecloud.systems.impls.BundlesLoaderDbBundlesImpl;

public class CommonBsDbConnFactoryUnitTest{
	private static final Logger log = LoggerFactory.getLogger(CommonBsDbConnFactoryUnitTest.class);
	private static Connection conn;

	public static Connection getConnectionInstance() {
		try {
			if (conn == null) {
				BundlesLoader <DbBundles> bundlesFactory = new BundlesLoaderDbBundlesImpl();
				DbBundles dbBundlesDto = bundlesFactory.getBundleDto();
				if (dbBundlesDto != null){
					Class.forName("com.mysql.jdbc.Driver");
					// setup the connection with the DB.
					conn = DriverManager.getConnection("jdbc:mysql://" + dbBundlesDto.getHost() + ":" + dbBundlesDto.getPort()
							+ "/" + dbBundlesDto.getSchema() + "?" + "user=" + dbBundlesDto.getUser() +"&password=" + dbBundlesDto.getPassword());
				}
			}
		} catch (Exception e) {
			log.debug("CommonBsDbConnFactoryImpl.getConnectionInstance() - ", e);
		}
		return conn;
	}
}

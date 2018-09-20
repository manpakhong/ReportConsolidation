package com.littlecloud.rptconsolidation.test.factories;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.junit.Test;

import com.littlecloud.rptconsolidation.factories.CommonBsDbConnFactoryUnitTest;

public class CommonBsDbConnFactoryUnitTestImplUnitTest {

	@Test
	public void test() {
		Connection conn = CommonBsDbConnFactoryUnitTest.getConnectionInstance();
		
		assertTrue(conn != null);
	}

}

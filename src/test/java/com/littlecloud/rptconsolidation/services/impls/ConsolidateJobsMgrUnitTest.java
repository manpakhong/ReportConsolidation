package com.littlecloud.rptconsolidation.services.impls;

import java.util.Calendar;

import org.jboss.logging.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.littlecloud.rptconsolidation.daos.BaseDao;
import com.littlecloud.rptconsolidation.eos.ConsolidateJob;
import com.littlecloud.rptconsolidation.services.ConsolidateJobsMgr;
import com.littlecloud.utils.CalendarUtils;

public class ConsolidateJobsMgrUnitTest {
	private static final Logger log = Logger.getLogger(ConsolidateJobsMgrUnitTest.class);
	@Ignore
	public void testConsolidateJobsMgrImpl() {
		//fail("Not yet implemented");
	}

	@Ignore
	public void testGetAllConsolidateJobList() {
		//fail("Not yet implemented");
	}

	@Test
	public void testInsertConsolidateJob(){
		try{
			ConsolidateJobsMgr consolidateJobsMgr = new ConsolidateJobsMgrImpl(BaseDao.MODE_UNITTEST);
			
			Calendar calStart = CalendarUtils.getUtcCalendarToday();
			Thread.sleep(10000);
			Calendar calEnd = CalendarUtils.getUtcCalendarToday();
			ConsolidateJob consolidateJob = new ConsolidateJob();
			consolidateJob.setActive(true);
			consolidateJob.setCreatedDate(calStart.getTime());
			consolidateJob.setEndDateTime(calEnd.getTime());
			consolidateJob.setJobName("test");
			consolidateJob.setOrgId("testOrg");
			consolidateJob.setServer("bs-test");
			consolidateJob.setStartDateTime(calStart.getTime());
			consolidateJob.setStatus("pending");
			consolidateJob.setType(ConsolidateJob.TYPE_WEBSERVICE);
			consolidateJob.setUpdatedDate(calEnd.getTime());
			
			int lastInsertId = consolidateJobsMgr.insertConsolidateJob(consolidateJob);
			assert(lastInsertId > 0);
		} catch (Exception e){
			log.error("ConsolidateJobsMgrUnitTest.testInsertConsolidateJob() - Exception: ", e);
		}
	}
}

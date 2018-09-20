package com.littlecloud.rptconsolidation.test.factories;

import org.jboss.logging.Logger;
import org.junit.Test;

import com.littlecloud.rptconsolidation.eos.ConsolidateJob;
import com.littlecloud.rptconsolidation.factories.ExecutorsFactory;
import com.littlecloud.rptconsolidation.test.threads.executors.ConsolidateJobsExecutorUnitTest;
import com.littlecloud.rptconsolidation.threads.executors.RptConsolidationExecutor;

public class ExecutorsFactoryUnitTest {
	private static final Logger log = Logger.getLogger(ConsolidateJobsExecutorUnitTest.class);
	@Test
	public void testGetConsolidateJobsExecutorInstance() {
		try{
			RptConsolidationExecutor<ConsolidateJob> consolidateJobsProviderExecutor = ExecutorsFactory.getConsolidateJobsProviderExecutorInstance();
			RptConsolidationExecutor<ConsolidateJob> consolidateJobsConsumerExecutor = ExecutorsFactory.getConsolidateJobsConsumerExecutorInstance();
			assert(consolidateJobsConsumerExecutor != null && consolidateJobsProviderExecutor != null);
		} catch (Exception e){
			log.error("ConsolidateJobsExecutorUnitTest.testRun() - Exception", e);
		}
	}

}

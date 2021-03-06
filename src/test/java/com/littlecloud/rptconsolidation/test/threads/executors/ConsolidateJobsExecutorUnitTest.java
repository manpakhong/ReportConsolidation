package com.littlecloud.rptconsolidation.test.threads.executors;

import static org.junit.Assert.fail;

import org.jboss.logging.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.littlecloud.rptconsolidation.eos.ConsolidateJob;
import com.littlecloud.rptconsolidation.factories.ExecutorsFactoryUnitTest;
import com.littlecloud.rptconsolidation.threads.executors.RptConsolidationExecutor;

public class ConsolidateJobsExecutorUnitTest {
	private static final Logger log = Logger.getLogger(ConsolidateJobsExecutorUnitTest.class);
	@Ignore
	public void testGetExecutor() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testConsolidateJobsExecutor() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testGetQueue() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testEnqueue() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testGetRunningEnabled() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testSetRunningEnabled() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testShutdown() {
		fail("Not yet implemented");
	}

	@Test
	public void testRun() {
		try{
			RptConsolidationExecutor<ConsolidateJob> consolidateJobsProviderExecutor = ExecutorsFactoryUnitTest.getConsolidateJobsProviderExecutorUnitTestInstance();
			RptConsolidationExecutor<ConsolidateJob> consolidateJobsConsumerExecutor = ExecutorsFactoryUnitTest.getConsolidateJobsConsumerExecutorUnitTestInstance();
			Thread providerThread = new Thread(consolidateJobsProviderExecutor);
			providerThread.start();
			Thread consumerThread = new Thread(consolidateJobsConsumerExecutor);
			consumerThread.start();


			assert(consolidateJobsConsumerExecutor.getQueue() != null && consolidateJobsProviderExecutor.getQueue() != null);
		} catch (Exception e){
			log.error("ConsolidateJobsExecutorUnitTest.testRun() - Exception", e);
		}
	}

}

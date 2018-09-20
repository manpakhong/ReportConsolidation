package com.littlecloud.rptconsolidation.test.threads.executors;

import org.jboss.logging.Logger;

import com.littlecloud.rptconsolidation.eos.ConsolidateJob;
import com.littlecloud.rptconsolidation.factories.ExecutorsFactoryUnitTest;
import com.littlecloud.rptconsolidation.threads.executors.RptConsolidationExecutor;

public class TestConsolidateJobsExecutor {
	private static final Logger log = Logger.getLogger(ConsolidateJobsExecutorUnitTest.class);
	public static void main(String[] args) {
		try{
			RptConsolidationExecutor<ConsolidateJob> consolidateJobsProviderExecutor = ExecutorsFactoryUnitTest.getConsolidateJobsProviderExecutorUnitTestInstance();
			RptConsolidationExecutor<ConsolidateJob> consolidateJobsConsumerExecutor = ExecutorsFactoryUnitTest.getConsolidateJobsConsumerExecutorUnitTestInstance();
			Thread providerThread = new Thread(consolidateJobsProviderExecutor);
			providerThread.start();
			Thread consumerThread = new Thread(consolidateJobsConsumerExecutor);
			consumerThread.start();
			
			Thread.sleep(10000);
			consolidateJobsProviderExecutor.setRunningEnabled(false);
			consolidateJobsConsumerExecutor.setRunningEnabled(false);
			
			Thread.sleep(10000);
			consolidateJobsProviderExecutor.setRunningEnabled(true);
			consolidateJobsConsumerExecutor.setRunningEnabled(true);
			
		} catch (Exception e){
			log.error("TestConsolidateJobsExecutor.main() - Exception:", e);
		}
	}

}

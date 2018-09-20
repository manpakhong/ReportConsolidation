package com.littlecloud.rptconsolidation.factories;

import org.jboss.logging.Logger;

import com.littlecloud.rptconsolidation.eos.ConsolidateJob;
import com.littlecloud.rptconsolidation.threads.executors.RptConsolidationExecutor;
import com.littlecloud.rptconsolidation.threads.executors.impls.ConsolidateJobsConsumerExecutorImplUnitTest;
import com.littlecloud.rptconsolidation.threads.executors.impls.ConsolidateJobsProviderExecutorImplUnitTest;

public class ExecutorsFactoryUnitTest extends ExecutorsFactory{
	private static final Logger log = Logger.getLogger(ExecutorsFactoryUnitTest.class);
	public static RptConsolidationExecutor<ConsolidateJob> getConsolidateJobsConsumerExecutorUnitTestInstance(){
		try{
			if (consolidateConsumerJobsExecutor == null){
				consolidateConsumerJobsExecutor = new ConsolidateJobsConsumerExecutorImplUnitTest(getConsolidateJobQueueInstance());
			}
		} catch (Exception e){
			log.debug("ExecutorsFactoryUnitTest.getConsolidateJobsConsumerExecutorUnitTestInstance() - ", e);
		}
		return consolidateConsumerJobsExecutor;
	}
	
	public static RptConsolidationExecutor<ConsolidateJob> getConsolidateJobsProviderExecutorUnitTestInstance(){
		try{
			if (consolidateProviderJobsExecutor == null){
				consolidateProviderJobsExecutor = new ConsolidateJobsProviderExecutorImplUnitTest(getConsolidateJobQueueInstance());
			}
		} catch (Exception e){
			log.debug("ExecutorsFactoryUnitTest.getConsolidateJobsProviderExecutorUnitTestInstance() - ", e);
		}
		return consolidateProviderJobsExecutor;
	}
}

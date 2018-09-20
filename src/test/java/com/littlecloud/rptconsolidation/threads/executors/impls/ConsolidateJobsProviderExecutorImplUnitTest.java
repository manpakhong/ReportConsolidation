package com.littlecloud.rptconsolidation.threads.executors.impls;

import java.util.concurrent.BlockingQueue;

import org.jboss.logging.Logger;

import com.littlecloud.rptconsolidation.eos.ConsolidateJob;
import com.littlecloud.rptconsolidation.threads.providers.ConsolidateJobsProviderThread;
import com.littlecloud.rptconsolidation.threads.providers.impls.ConsolidateJobsProviderThreadImplUnitTest;

public class ConsolidateJobsProviderExecutorImplUnitTest extends ConsolidateJobsProviderExecutorImpl{
	private static final Logger log = Logger.getLogger(ConsolidateJobsProviderExecutorImpl.class);

	public ConsolidateJobsProviderExecutorImplUnitTest(BlockingQueue<ConsolidateJob> q){
		super(q);
	}

	@Override
	public void run() {
		try{
			while (true){
				if (runningEnabled){
					if (q != null){
						ConsolidateJobsProviderThread<ConsolidateJob> providerThread = new ConsolidateJobsProviderThreadImplUnitTest(ConsolidateJobsProviderExecutorImplUnitTest.q);
						execute(providerThread);
					}
					if (log.isDebugEnabled()){
						log.debugf("ConsolidateJobsProviderExecutorImplUnitTest.run(), ConsolidateJobsExecutor.q: %s", ConsolidateJobsProviderExecutorImplUnitTest.q);					
					}
					Thread.sleep(bundlesDto.getProviderThreadSleep());
				}else {
					if (log.isDebugEnabled()){
						log.debug("ConsolidateJobsProviderExecutorImplUnitTest.run(), runningEnabled: " + runningEnabled);					
					}
					Thread.sleep(bundlesDto.getProviderThreadSleep());
				}
			}
		} catch (Exception e){
			log.error("ConsolidateJobsProviderExecutorImplUnitTest.run() - ", e );
		}
	}

}

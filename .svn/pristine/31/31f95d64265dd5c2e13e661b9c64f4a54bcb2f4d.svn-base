package com.littlecloud.rptconsolidation.threads.executors.impls;

import java.util.concurrent.BlockingQueue;

import org.jboss.logging.Logger;

import com.littlecloud.rptconsolidation.eos.ConsolidateJob;
import com.littlecloud.rptconsolidation.threads.consumers.ConsolidateJobsConsumerThread;
import com.littlecloud.rptconsolidation.threads.consumers.impls.ConsolidateJobsConsumerThreadImplUnitTest;

public class ConsolidateJobsConsumerExecutorImplUnitTest extends ConsolidateJobsConsumerExecutorImpl {
	private static final Logger log = Logger.getLogger(ConsolidateJobsConsumerExecutorImplUnitTest.class);
	public ConsolidateJobsConsumerExecutorImplUnitTest(BlockingQueue<ConsolidateJob> q) {
		super(q);
	}

	public void run() {
		try{
			while (true){
				if (runningEnabled){
					if (q != null && q.size() > 0){
						ConsolidateJobsConsumerThread<ConsolidateJob> consumerThread = new ConsolidateJobsConsumerThreadImplUnitTest(q);
						execute(consumerThread);
					}
					if (log.isDebugEnabled()){
						log.debugf("ConsolidateJobsConsumerExecutorImplUnitTest.run(), ConsolidateJobsExecutor.q: %s", q.size());					
					}
					Thread.sleep(bundlesDto.getConsumerThreadSleep());
				}else {
					if (log.isDebugEnabled()){
						log.debug("ConsolidateJobsConsumerExecutorImplUnitTest.run(), runningEnabled: " + runningEnabled);					
					}
					Thread.sleep(bundlesDto.getConsumerThreadSleep());
				}
			}
		} catch (Exception e){
			log.error("ConsolidateJobsConsumerExecutorImplUnitTest.run() - ", e );
		}
	}

}

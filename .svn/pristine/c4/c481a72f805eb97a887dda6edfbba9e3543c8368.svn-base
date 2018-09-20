package com.littlecloud.rptconsolidation.threads.consumers.impls;

import java.util.concurrent.BlockingQueue;

import org.jboss.logging.Logger;

import com.littlecloud.rptconsolidation.daos.BaseDao;
import com.littlecloud.rptconsolidation.eos.ConsolidateJob;

public class ConsolidateJobsConsumerThreadImplUnitTest extends ConsolidateJobsConsumerThreadImpl{
	private static final Logger log = Logger.getLogger(ConsolidateJobsConsumerThreadImplUnitTest.class);
	public ConsolidateJobsConsumerThreadImplUnitTest(BlockingQueue<ConsolidateJob> q) {
		super(q, BaseDao.MODE_UNITTEST);
	}
	public void run() {
		try {
			if (queue.size() > 0) {
				consume(queue.poll());
			}
		} catch (Exception e) {
			log.error("ConsolidateJobsConsumerThread.run() - ", e);
		}
	}
}

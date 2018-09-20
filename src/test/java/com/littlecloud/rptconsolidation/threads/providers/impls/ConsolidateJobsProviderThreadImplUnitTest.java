package com.littlecloud.rptconsolidation.threads.providers.impls;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.jboss.logging.Logger;

import com.littlecloud.rptconsolidation.daos.BaseDao;
import com.littlecloud.rptconsolidation.eos.ConsolidateJob;
import com.littlecloud.rptconsolidation.threads.providers.impls.ConsolidateJobsProviderThreadImpl;


public class ConsolidateJobsProviderThreadImplUnitTest extends ConsolidateJobsProviderThreadImpl {
	private static final Logger log = Logger.getLogger(ConsolidateJobsProviderThreadImplUnitTest.class);

	public ConsolidateJobsProviderThreadImplUnitTest(BlockingQueue<ConsolidateJob> q) {
		super(q, BaseDao.MODE_UNITTEST);
	}
	@Override
	public void run() {
		try {
			if (queue != null) {
				List<ConsolidateJob> consolidateJobList = provide();
				if (consolidateJobList != null && consolidateJobList.size() > 0){
					changeStatus2Waiting(consolidateJobList);
					consolidateJobsMgr.updateConsolidateJobList(consolidateJobList);
					for (ConsolidateJob consolidateJob: consolidateJobList){
						if (consolidateJob != null){
							queue.put(consolidateJob);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error("ConsolidateJobsProviderThreadImplUnitTest.run() - ", e);
		}
	}

}

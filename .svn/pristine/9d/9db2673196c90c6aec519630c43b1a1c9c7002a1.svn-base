package com.littlecloud.rptconsolidation.threads.providers.impls;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.jboss.logging.Logger;

import com.littlecloud.rptconsolidation.eos.ConsolidateJob;
import com.littlecloud.rptconsolidation.eos.SystemParamsBundles;
import com.littlecloud.rptconsolidation.factories.BundlesFactory;
import com.littlecloud.rptconsolidation.services.ConsolidateJobsMgr;
import com.littlecloud.rptconsolidation.services.impls.ConsolidateJobsMgrImpl;
import com.littlecloud.rptconsolidation.threads.providers.ConsolidateJobsProviderThread;
import com.littlecloud.utils.CalendarUtils;

public class ConsolidateJobsProviderThreadImpl implements Runnable, ConsolidateJobsProviderThread <ConsolidateJob>{
	private static final Logger log = Logger.getLogger(ConsolidateJobsProviderThreadImpl.class);
	protected static BlockingQueue<ConsolidateJob> queue;
	protected ConsolidateJobsMgr consolidateJobsMgr;
	protected static SystemParamsBundles systemParamsBundles;
	public ConsolidateJobsProviderThreadImpl(BlockingQueue<ConsolidateJob> q) {
		init(q, null);
	}
	public ConsolidateJobsProviderThreadImpl(BlockingQueue<ConsolidateJob> q, String mode) {
		init(q, mode);
	}
	private void init(BlockingQueue<ConsolidateJob> q, String mode){
		ConsolidateJobsProviderThreadImpl.queue = q;
		consolidateJobsMgr = new ConsolidateJobsMgrImpl(mode);	
		systemParamsBundles = BundlesFactory.getSystemParamsBundlesInstance();
	}
	public void run() {
		try {
			if (ConsolidateJobsProviderThreadImpl.queue != null) {
				List<ConsolidateJob> consolidateJobList = provide();
				changeStatus2Waiting(consolidateJobList);
				if (consolidateJobList != null && consolidateJobList.size() > 0){
					consolidateJobsMgr.updateConsolidateJobList(consolidateJobList);
					for (ConsolidateJob consolidateJob: consolidateJobList){
						if (consolidateJob != null){
							ConsolidateJobsProviderThreadImpl.queue.put(consolidateJob);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error("ConsolidateJobsProviderThread.run() - ", e);
		}
	}
	protected void changeStatus2Waiting(List<ConsolidateJob>consolidateJobList){
		if (consolidateJobList != null && consolidateJobList.size() > 0){
			for (ConsolidateJob consolidateJob: consolidateJobList){
				consolidateJob.setStatus(ConsolidateJob.STATUS_WAITING);
				Calendar cal = CalendarUtils.getUtcCalendarToday();
				consolidateJob.setUpdatedDate(cal.getTime());
			}
		}
	}
	
	protected List<ConsolidateJob> provide() {
		List<ConsolidateJob> consolidateJobList = null;
		try{
			consolidateJobList = consolidateJobsMgr.getPendingConsolidateJobList(systemParamsBundles.getProviderMaxThreadPool());
		} catch (Exception e){
			log.error("ConsolidateJobsConsumerThread.consume() - ", e);
		}
		return consolidateJobList;
	}

}

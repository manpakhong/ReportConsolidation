package com.littlecloud.systems.impls;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.jboss.logging.Logger;

import com.littlecloud.rptconsolidation.eos.ConsolidateJob;
import com.littlecloud.rptconsolidation.factories.ExecutorsFactory;
import com.littlecloud.rptconsolidation.threads.executors.RptConsolidationExecutor;
import com.littlecloud.rptconsolidation.utils.SystemUtils;

@SuppressWarnings("serial")
public class InitializerImpl extends HttpServlet{
	private static final Logger log = Logger.getLogger(InitializerImpl.class);
	public void init() throws ServletException{
		try{
			SystemUtils.loadLittleCloudProperties();
			RptConsolidationExecutor<ConsolidateJob> consolidateJobsProviderExecutor = ExecutorsFactory.getConsolidateJobsProviderExecutorInstance();
			RptConsolidationExecutor<ConsolidateJob> consolidateJobsConsumerExecutor = ExecutorsFactory.getConsolidateJobsConsumerExecutorInstance();
			Thread providerThread = new Thread(consolidateJobsProviderExecutor);
			providerThread.start();
			Thread consumerThread = new Thread(consolidateJobsConsumerExecutor);
			consumerThread.start();
			
//			Thread.sleep(10000);
//			consolidateJobsProviderExecutor.setRunningEnabled(false);
//			consolidateJobsConsumerExecutor.setRunningEnabled(false);
//			
//			Thread.sleep(10000);
//			consolidateJobsProviderExecutor.setRunningEnabled(true);
//			consolidateJobsConsumerExecutor.setRunningEnabled(true);
		} catch (Exception e){
			log.error("InitializerImpl.init()", e);
		}
	}
}

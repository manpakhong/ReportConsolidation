package com.littlecloud.rptconsolidation.webservices;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.littlecloud.rptconsolidation.eos.ConsolidateJob;
import com.littlecloud.rptconsolidation.services.ConsolidateJobsMgr;
import com.littlecloud.rptconsolidation.services.impls.ConsolidateJobsMgrImpl;
import com.littlecloud.rptconsolidation.utils.SystemUtils;
@Path("/consolidateJobWs")
public class ConsolidateThreadsControlWs {
	private static final Logger log = LoggerFactory.getLogger(ConsolidateThreadsControlWs.class);
	
	public ConsolidateThreadsControlWs(){
		init();
	}
	private void init(){
		try{
			SystemUtils.loadLittleCloudProperties();			
		} catch (Exception e){
			log.error("ConsolidateThreadsControlWs.init() - Exception: ", e);
		}
	}
	@GET
	@Path("/startConsolidateJobExecutor")
	@Produces("text/plain")
	public String startConsolidateJobExecutor(){ 
		String returnString = "";
		try{
			ConsolidateJobsMgr consolidateJobMgr = new ConsolidateJobsMgrImpl();
			List<ConsolidateJob> consolidateJobList = consolidateJobMgr.getAllConsolidateJobList();
			StringBuilder sb = new StringBuilder();
			for (ConsolidateJob consolidateJob: consolidateJobList){
				sb.append(consolidateJob + "\n");
			}
			returnString = sb.toString();
		}catch (Exception e){
			log.error("ConsolidateJobsWs.getAllConsolidateJob() - Exception: ", e);
		}
		return returnString;
	}
	
}

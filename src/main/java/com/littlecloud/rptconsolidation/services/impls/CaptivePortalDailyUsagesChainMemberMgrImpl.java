package com.littlecloud.rptconsolidation.services.impls;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.littlecloud.control.dao.NetworksDAO;
import com.littlecloud.control.entity.Networks;
import com.littlecloud.rptconsolidation.dtos.ConsolidateJobCommonParamsDto;
import com.littlecloud.rptconsolidation.eos.ConsolidateJob;
import com.littlecloud.rptconsolidation.helpers.ConsolidateJobsHelper;
import com.littlecloud.rptconsolidation.services.ConsolidateJobsChainMemberMgr;
import com.littlecloud.services.CaptivePortalDailyUsagesMgr;
import com.littlecloud.services.DeviceDailyUsagesMgr;
import com.littlecloud.utils.CalendarUtils;
import com.littlecloud.utils.CommonUtils;

public class CaptivePortalDailyUsagesChainMemberMgrImpl implements ConsolidateJobsChainMemberMgr {
	private static final Logger log = LoggerFactory.getLogger(CaptivePortalDailyUsagesChainMemberMgrImpl.class);
	private ConsolidateJobsChainMemberMgr consolidateJobsChainMgr;
	@Override
	public void setNextChain(ConsolidateJobsChainMemberMgr nextChain) {
		this.consolidateJobsChainMgr=nextChain;
	}

	@Override
	public void responseJobOrPass(ConsolidateJobCommonParamsDto consolidateJobCommonParamsDto) {
		try{
			if (consolidateJobCommonParamsDto != null){
				if (consolidateJobCommonParamsDto.getJobName() != null && 
						consolidateJobCommonParamsDto.getJobName().equals(ConsolidateJob.JOB_NAME_CAPTIVE_PORTAL_DAILY_USAGES_CONSOLIDATION)){
					boolean areParamsValided = areParamsValided(consolidateJobCommonParamsDto);
					if (!areParamsValided){
						log.warn("CaptivePortalDailyUsagesChainMemberMgrImpl.responseJobOrPass() - areParamsValided:" + areParamsValided);
						return;
					}
					Calendar calFrom = consolidateJobCommonParamsDto.getCalFrom();
					CalendarUtils.trimCalendar2Minimum(calFrom);
					Calendar calTo = consolidateJobCommonParamsDto.getCalTo();
					CalendarUtils.trimCalendar2Maximum(calTo);
					String orgId = consolidateJobCommonParamsDto.getOrgId();
					String server = consolidateJobCommonParamsDto.getServer();
					String networkId = consolidateJobCommonParamsDto.getNetworkId();
					

					long tstart = System.currentTimeMillis();
					

					String jobName = consolidateJobCommonParamsDto.getJobName();
					ConsolidateJobsHelper consolidateJobsWsHelper = null;
					if (consolidateJobCommonParamsDto.getConsolidateJob() != null){
						consolidateJobsWsHelper = new ConsolidateJobsHelper(consolidateJobCommonParamsDto.getConsolidateJob());
					} else {
						consolidateJobsWsHelper = new ConsolidateJobsHelper(orgId, jobName, server);
					}
					consolidateJobsWsHelper.markProcessStartTime();
					
					CaptivePortalDailyUsagesMgr captivePortalDailyUsagesMgr = new CaptivePortalDailyUsagesMgr(orgId);
					int noOfRecordsDone = 0;
					if (networkId != null){ 
						NetworksDAO networksDao = new NetworksDAO(orgId);
						if (CommonUtils.isInteger(networkId)){
							Integer networkIdInt = new Integer(networkId);
							Networks network= networksDao.getNetworksById(networkIdInt);
							if (network != null){
								List<Networks> networkList = new ArrayList<Networks>();
								networkList.add(network);
								noOfRecordsDone = captivePortalDailyUsagesMgr.doCaptivePortalDailyUsagesConsolidation(calFrom, calTo, networkList);
							}
						}
					} else {
						noOfRecordsDone = captivePortalDailyUsagesMgr.doCaptivePortalDailyUsagesConsolidation(calFrom, calTo);						
					}
					

					long tused = (System.currentTimeMillis() - tstart) / 1000;
					StringBuilder sb = new StringBuilder(); 
					sb.append("CaptivePortalDailyUsagesChainMemberMgrImpl - no of records:" + noOfRecordsDone + ", ");
					sb.append("time: " + tused);
					consolidateJobCommonParamsDto.setResultString(sb.toString());
					consolidateJobsWsHelper.markDoDateFrom(calFrom);
					consolidateJobsWsHelper.markDoDateTo(calTo);
					consolidateJobsWsHelper.markProcessEndTime();
					consolidateJobsWsHelper.markNoOfRecordsProcessed(noOfRecordsDone);
					consolidateJobsWsHelper.saveConsolidateJob();
				} else {
					consolidateJobsChainMgr.responseJobOrPass(consolidateJobCommonParamsDto);
				}
			}
		} catch (Exception e){
			log.error("CaptivePortalDailyUsagesChainMemberMgrImpl.responseJobOrPass() - Exception: ", e);
		}
	}

	private boolean areParamsValided(ConsolidateJobCommonParamsDto consolidateJobCommonParamsDto){
		boolean areValided = true;
		if (consolidateJobCommonParamsDto.getCalFrom() == null ||
				consolidateJobCommonParamsDto.getCalTo() == null || 
				consolidateJobCommonParamsDto.getJobName() == null || consolidateJobCommonParamsDto.getJobName().isEmpty() ||
				consolidateJobCommonParamsDto.getOrgId() == null || consolidateJobCommonParamsDto.getOrgId().isEmpty() ||
				consolidateJobCommonParamsDto.getServer() == null || consolidateJobCommonParamsDto.getServer().isEmpty()){
			areValided = false;
		}
		return areValided;
	}
}

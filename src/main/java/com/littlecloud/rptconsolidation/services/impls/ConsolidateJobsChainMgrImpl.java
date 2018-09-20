package com.littlecloud.rptconsolidation.services.impls;

import com.littlecloud.rptconsolidation.dtos.ConsolidateJobCommonParamsDto;
import com.littlecloud.rptconsolidation.services.ConsolidateJobsChainMemberMgr;
import com.littlecloud.rptconsolidation.services.ConsolidateJobsChainMgr;

public class ConsolidateJobsChainMgrImpl implements ConsolidateJobsChainMgr {
    private ConsolidateJobsChainMemberMgr c1;
    
    public ConsolidateJobsChainMgrImpl() {
        // initialize the chain
    	
        this.c1 = new DeviceDailyUsagesChainMemberMgrImpl();
        ConsolidateJobsChainMemberMgr c2 = new DeviceMonthlyUsagesChainMemberMgrImpl();
        ConsolidateJobsChainMemberMgr c3 = new DeviceDpiDailyUsagesChainMemberMgrImpl();
        ConsolidateJobsChainMemberMgr c4 = new DeviceDpiMonthlyUsagesChainMemberMgrImpl();
        ConsolidateJobsChainMemberMgr c5 = new DeviceSsidDailyUsagesChainMemberMgrImpl();
        ConsolidateJobsChainMemberMgr c6 = new CaptivePortalDailyUsagesChainMemberMgrImpl();
        ConsolidateJobsChainMemberMgr c7 = new CaptivePortalUserDailyUsagesChainMemberMgrImpl();

        // set the chain of responsibility
        this.c1.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);
        c4.setNextChain(c5);
        c5.setNextChain(c6);
        c6.setNextChain(c7);

    }
 
	public String passJob(ConsolidateJobCommonParamsDto consolidateJobCommonParamsDto) {
		String resultString = "";
		c1.responseJobOrPass(consolidateJobCommonParamsDto);
		resultString = consolidateJobCommonParamsDto.getResultString();
		return resultString;
    }
}

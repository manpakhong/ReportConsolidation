package com.littlecloud.rptconsolidation.services;

import com.littlecloud.rptconsolidation.dtos.ConsolidateJobCommonParamsDto;

public interface ConsolidateJobsChainMemberMgr {
    public void setNextChain(ConsolidateJobsChainMemberMgr nextChain);
    public void responseJobOrPass(ConsolidateJobCommonParamsDto consolidateJobCommonParamsDto);
}

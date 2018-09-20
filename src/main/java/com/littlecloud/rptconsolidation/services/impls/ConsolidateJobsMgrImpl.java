package com.littlecloud.rptconsolidation.services.impls;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.littlecloud.rptconsolidation.criterias.ConsolidateJobCriteria;
import com.littlecloud.rptconsolidation.daos.impls.ConsolidateJobsDaoImpl;
import com.littlecloud.rptconsolidation.eos.ConsolidateJob;
import com.littlecloud.rptconsolidation.services.ConsolidateJobsMgr;

public class ConsolidateJobsMgrImpl implements ConsolidateJobsMgr {
	private static final Logger log = LoggerFactory.getLogger(ConsolidateJobsMgrImpl.class);
	private ConsolidateJobsDaoImpl consolidateJobsDao;
	private String mode;
	public ConsolidateJobsMgrImpl(){
		init();
	}
	public ConsolidateJobsMgrImpl(String mode){
		this.mode = mode;
		init();
	}
	private void init(){
		try{
			if (this.mode != null){
				consolidateJobsDao = new ConsolidateJobsDaoImpl(this.mode);
			} else {
				consolidateJobsDao = new ConsolidateJobsDaoImpl();
			}
		} catch (Exception e){
			log.error("ConsolidateJobsMgrImpl.init() - ", e);
		}
	}
	public int updateConsolidateJob(ConsolidateJob consolidateJob){
		int noOfRecords = 0;
		try{
			if (consolidateJob != null){
				List<ConsolidateJob> consolidateJobList = new ArrayList<ConsolidateJob>();
				consolidateJobList.add(consolidateJob);
				noOfRecords = consolidateJobsDao.updateConsolidateJobList(consolidateJobList);
			}
		} catch (Exception e){
			log.error("ConsolidateJobsMgrImpl.updateConsolidateJobList() - Exception: ", e);
		}
		return noOfRecords;
	}
	public int updateConsolidateJobList(List<ConsolidateJob> consolidateJobList){
		int noOfRecords = 0;
		try{
			noOfRecords = consolidateJobsDao.updateConsolidateJobList(consolidateJobList);
		} catch (Exception e){
			log.error("ConsolidateJobsMgrImpl.updateConsolidateJobList() - Exception: ", e);
		}
		return noOfRecords;
	}
	
	public List<ConsolidateJob> getPendingConsolidateJobList(Integer limit){
		List<ConsolidateJob> consolidateJobList = null;
		try{
			ConsolidateJobCriteria criteria = new ConsolidateJobCriteria();
			criteria.setLimit(limit);
			criteria.setStatus(ConsolidateJob.STATUS_PENDING);
			consolidateJobList = consolidateJobsDao.getConsolidateJobList(criteria);
		} catch (Exception e){
			log.error("ConsolidateJobsMgrImpl.getConsolidateJobList() - Exception: ", e);
		}
		return consolidateJobList;
	}
	public List<ConsolidateJob> getAllConsolidateJobList(){
		List<ConsolidateJob> consolidateJobList = null;
		try{
			ConsolidateJobCriteria criteria = new ConsolidateJobCriteria();
			consolidateJobList = consolidateJobsDao.getConsolidateJobList(criteria);
		} catch (Exception e){
			log.error("ConsolidateJobsMgrImpl.getConsolidateJobList() - Exception: ", e);
		}
		return consolidateJobList;
	}
	@Override
	public int insertConsolidateJob(ConsolidateJob consolidateJob) {
		int lastGeneratedKey = 0;
		try{
			lastGeneratedKey = consolidateJobsDao.insertConsolidateJob(consolidateJob);
		} catch (Exception e){
			log.error("ConsolidateJobsMgrImpl.insertConsolidateJob() - Exception: ", e);
		}
		return lastGeneratedKey;
	}
}

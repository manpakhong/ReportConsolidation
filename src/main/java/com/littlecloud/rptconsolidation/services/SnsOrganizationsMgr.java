package com.littlecloud.rptconsolidation.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.littlecloud.control.dao.branch.SnsOrganizationsDAO;

public class SnsOrganizationsMgr {
	private static final Logger log = LoggerFactory.getLogger(SnsOrganizationsMgr.class);
	private SnsOrganizationsDAO snsOrganizationsDao;
	private List<String> orgIdList;
	public SnsOrganizationsMgr(){
		init();
	}
	private void init(){
		try{
			snsOrganizationsDao = new SnsOrganizationsDAO(true);
			orgIdList = snsOrganizationsDao.getDistinctOrgList();
		} catch (Exception e){
			log.error("SnsOrganizationsMgr.init() - Exception: ",e);
		}
	}
	public boolean isOrganizationIdValid(String orgId){
		boolean isValid = false;
		try{
			if (orgIdList != null){
				for (String id: orgIdList){
					if (orgId.equals(id)){
						isValid = true;
						break;
					}
				}
			}
		} catch (Exception e){
			log.error("SnsOrganizationsMgr.init() - Exception: ",e);
		}
		return isValid;
	}
}

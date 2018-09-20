package com.littlecloud.rptconsolidation.dtos;

import java.util.Calendar;

import com.littlecloud.rptconsolidation.eos.ConsolidateJob;

public class ConsolidateJobCommonParamsDto {
	public final static String JOB_NAME_DEVICE_DAILY_USAGES_CONSOLIDATION = ConsolidateJob.JOB_NAME_CAPTIVE_PORTAL_DAILY_USAGES_CONSOLIDATION;
	public final static String JOB_NAME_DEVICE_MONTHLY_USAGES_CONSOLIDATION = ConsolidateJob.JOB_NAME_DEVICE_MONTHLY_USAGES_CONSOLIDATION;
	public final static String JOB_NAME_DEVICE_SSID_DAILY_USAGES_CONSOLIDATION = ConsolidateJob.JOB_NAME_DEVICE_SSID_DAILY_USAGES_CONSOLIDATION;
	public final static String JOB_NAME_DEVICE_DPI_DAILY_USAGES_CONSOLIDATION = ConsolidateJob.JOB_NAME_DEVICE_DPI_DAILY_USAGES_CONSOLIDATION;
	public final static String JOB_NAME_DEVICE_DPI_MONTHLY_USAGES_CONSOLIDATION = ConsolidateJob.JOB_NAME_DEVICE_DPI_MONTHLY_USAGES_CONSOLIDATION;
	public final static String JOB_NAME_CAPTIVE_PORTAL_DAILY_USAGES_CONSOLIDATION = ConsolidateJob.JOB_NAME_CAPTIVE_PORTAL_DAILY_USAGES_CONSOLIDATION;
	public final static String JOB_NAME_CAPTIVE_PORTAL_DAILY_USER_USAGES_CONSOLIDATION = ConsolidateJob.JOB_NAME_CAPTIVE_PORTAL_DAILY_USER_USAGES_CONSOLIDATION;
	
	private Calendar calFrom;
	private Calendar calTo;
	private String orgId;
	private String networkId;
	private String jobName;
	private String server;
	private String resultString;
	private ConsolidateJob consolidateJob;

	public Calendar getCalFrom() {
		return calFrom;
	}
	public void setCalFrom(Calendar calFrom) {
		this.calFrom = calFrom;
	}
	public Calendar getCalTo() {
		return calTo;
	}
	public void setCalTo(Calendar calTo) {
		this.calTo = calTo;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getNetworkId() {
		return networkId;
	}
	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	

	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getResultString() {
		return resultString;
	}
	public void setResultString(String resultString) {
		this.resultString = resultString;
	}
	
	
	public ConsolidateJob getConsolidateJob() {
		return consolidateJob;
	}
	public void setConsolidateJob(ConsolidateJob consolidateJob) {
		this.consolidateJob = consolidateJob;
		
		this.orgId = consolidateJob.getOrgId();
		this.jobName = consolidateJob.getJobName();
		this.server = consolidateJob.getServer();
		
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConsolidateJobCommonParamsDto [calFrom=");
		builder.append(calFrom);
		builder.append(", calTo=");
		builder.append(calTo);
		builder.append(", orgId=");
		builder.append(orgId);
		builder.append(", networkId=");
		builder.append(networkId);
		builder.append(", jobName=");
		builder.append(jobName);
		builder.append(", server=");
		builder.append(server);
		builder.append(", resultString=");
		builder.append(resultString);
		builder.append(", consolidateJob=");
		builder.append(consolidateJob);
		builder.append("]");
		return builder.toString();
	}



}

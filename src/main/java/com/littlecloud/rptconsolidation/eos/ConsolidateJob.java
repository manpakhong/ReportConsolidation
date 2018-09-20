package com.littlecloud.rptconsolidation.eos;

import java.util.Date;

public class ConsolidateJob {
	public final static String STATUS_PROCESSING = "processing";
	public final static String STATUS_FINISHED = "finished";
	public final static String STATUS_WAITING = "waiting";
	public final static String STATUS_MIGRATING = "migrating";
	public final static String STATUS_PENDING = "pending";
		
	public final static String JOB_NAME_DEVICE_DAILY_USAGES_CONSOLIDATION = "device_daily_usages";
	public final static String JOB_NAME_DEVICE_MONTHLY_USAGES_CONSOLIDATION = "device_monthly_usages";
	public final static String JOB_NAME_DEVICE_SSID_DAILY_USAGES_CONSOLIDATION = "device_ssid_daily_usages";
	public final static String JOB_NAME_DEVICE_DPI_DAILY_USAGES_CONSOLIDATION = "device_dpi_daily_usages";
	public final static String JOB_NAME_DEVICE_DPI_MONTHLY_USAGES_CONSOLIDATION = "device_dpi_monthly_usages";
	public final static String JOB_NAME_CAPTIVE_PORTAL_DAILY_USAGES_CONSOLIDATION = "captive_portal_daily_usages";
	public final static String JOB_NAME_CAPTIVE_PORTAL_DAILY_USER_USAGES_CONSOLIDATION = "captive_portal_daily_user_usages";
	
	public final static String TYPE_EXECUTOR = "executor";
	public final static String TYPE_WEBSERVICE = "webservice";
	protected Integer id;
	protected Date createdDate;
	protected Date updatedDate;
	protected String server;
	protected String orgId;
	protected Date doDateFrom;
	protected Date doDateTo;
	protected String jobName;
	protected String status;
	protected Integer noOfRecords;
	protected Date startDateTime;
	protected Date endDateTime;
	protected Boolean active;
	protected String type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
	
	public Date getDoDateFrom() {
		return doDateFrom;
	}
	public void setDoDateFrom(Date doDateFrom) {
		this.doDateFrom = doDateFrom;
	}
	public Date getDoDateTo() {
		return doDateTo;
	}
	public void setDoDateTo(Date doDateTo) {
		this.doDateTo = doDateTo;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}
	public Date getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	
	public Integer getNoOfRecords() {
		return noOfRecords;
	}
	public void setNoOfRecords(Integer noOfRecords) {
		this.noOfRecords = noOfRecords;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConsolidateJob [id=");
		builder.append(id);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", updatedDate=");
		builder.append(updatedDate);
		builder.append(", server=");
		builder.append(server);
		builder.append(", orgId=");
		builder.append(orgId);
		builder.append(", doDateFrom=");
		builder.append(doDateFrom);
		builder.append(", doDateTo=");
		builder.append(doDateTo);
		builder.append(", jobName=");
		builder.append(jobName);
		builder.append(", status=");
		builder.append(status);
		builder.append(", noOfRecords=");
		builder.append(noOfRecords);
		builder.append(", startDateTime=");
		builder.append(startDateTime);
		builder.append(", endDateTime=");
		builder.append(endDateTime);
		builder.append(", active=");
		builder.append(active);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}




}

package com.littlecloud.rptconsolidation.criterias;

import com.littlecloud.rptconsolidation.eos.ConsolidateJob;

public class ConsolidateJobCriteria extends ConsolidateJob {
	protected Integer limit;

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConsolidateJobCriteria [limit=");
		builder.append(limit);
		builder.append("]");
		return builder.toString();
	}
	
}

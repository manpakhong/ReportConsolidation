package com.littlecloud.rptconsolidation.threads.executors;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import com.littlecloud.rptconsolidation.eos.ConsolidateJob;

public interface RptConsolidationExecutor <T> extends Runnable{
	public ThreadPoolExecutor getExecutor();
	public BlockingQueue<ConsolidateJob> getQueue();
	public boolean enqueue(ConsolidateJob consolidateJob);
	public boolean getRunningEnabled();
	public void setRunningEnabled(boolean runningEnabled);
	public void shutdown();
	public void run();
}

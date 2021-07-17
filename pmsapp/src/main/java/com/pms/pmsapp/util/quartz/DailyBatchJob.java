package com.pms.pmsapp.util.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.watchlist.service.WatchlistService;

@Service
public class DailyBatchJob implements Job{
	
	@Autowired
	private WatchlistService watchlistService;

	@Override
	public void execute(JobExecutionContext context) {
		
		Logger log = LoggerFactory.getLogger(UpdateWatchlistEntryJob.class);
		
		log.info("executing dailyBatchJob..");
	
		watchlistService.deleteAllOtherNoti();
	}
	
}

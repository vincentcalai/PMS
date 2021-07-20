package com.pms.pmsapp.util.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.common.service.MessageService;

@Service
public class NotificationMessageJob implements Job{
	
	@Autowired
	private MessageService messageService;

	@Override
	public void execute(JobExecutionContext context) {
		
		Logger log = LoggerFactory.getLogger(UpdateWatchlistEntryJob.class);
		
		log.info("executing notificationMessageJob..");
	
		messageService.genWatchlistNotiMsg();
	}
	
}

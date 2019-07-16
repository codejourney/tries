package com.example.Jobs;


import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Scheduled Job
 *
 */
public class ScheduleJob extends QuartzJobBean {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private ExecutorService service = Executors.newSingleThreadExecutor(); 
	
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		JobDataMap dataMap = context.getMergedJobDataMap();
		ScheduleJobEntity scheduleJob = null;
		if ( dataMap != null ) {

			try {
//			scheduleJob = (ScheduleJobEntity) dataMap.get(ScheduleJobEntity.JOB_PARAM_KEY);
				Object entity = dataMap.get(ScheduleJobEntity.JOB_PARAM_KEY);
				scheduleJob = (ScheduleJobEntity) entity;

			} catch (Exception e) {
				//e.printStackTrace();
			}
		}

		if ( scheduleJob == null ) {
			logger.error("任务执行失败!" );
			return;
		}
    }
}

package com.example.Jobs;

import org.quartz.*;

import java.util.Date;

public class QuartzHelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("执行时间：" + new Date() + " FXP");

        JobDataMap dataMap = jobExecutionContext.getMergedJobDataMap();
        ScheduleJobEntity scheduleJob = null;
        if ( dataMap != null ) {
            try {
//			scheduleJob = (ScheduleJobEntity) dataMap.get(ScheduleJobEntity.JOB_PARAM_KEY);
                Object entity = dataMap.get(ScheduleJobEntity.JOB_PARAM_KEY);
                scheduleJob = (ScheduleJobEntity) entity;
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Object entity = dataMap.get(ScheduleJobEntity.JOB_PARAM_KEY);

            } catch (Exception e) {
                //e.printStackTrace();
            }
        }

        if ( scheduleJob == null ) {
            System.out.println("获取上下文失败：" + new Date() + " FXP");
            return;
        }
    }
}
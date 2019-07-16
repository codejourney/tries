package com.example.Jobs;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class QuartzDemo {
    public static void main(String[] args) {

        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            //Mode1(scheduler);

            ScheduleJobEntity scheduleJob = new ScheduleJobEntity();
            Date now = new Date();
            scheduleJob.setBeanName( "testTask");
            scheduleJob.setMethodName( "test");

            scheduleJob.setCronExpression( "0/30 * * * * ?" );
            scheduleJob.setParams( "params");
            scheduleJob.setRemark("no remark");
            scheduleJob.setStatus(0); //暂停1
            scheduleJob.setCreateTime( now);

            createScheduleJob(scheduler, scheduleJob);

            // and start it off
            scheduler.start();

            try {
                Thread.sleep(65L * 1000L);
            } catch (Exception e) {
            }

            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }

    static void Mode1(Scheduler scheduler) throws SchedulerException {
        // define the job and tie it to our HelloJob class
        JobDetail job = newJob(QuartzHelloJob.class)
                .withIdentity("job1", "group1")
                .build();

        // Trigger the job to run now, and then repeat every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(40)
                        .repeatForever())
                .build();

// Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);
    }


    /**
     * 创建定时任务
     */
    public static void createScheduleJob(Scheduler scheduler, ScheduleJobEntity scheduleJob) throws SchedulerException {

        //构建job信息
        JobDetail jobDetail = JobBuilder.newJob(QuartzHelloJob.class)
                .withIdentity("job2", "group1")
                .build();

        String cornExpression = "0/10 * * * * ?";
        //表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cornExpression)
                .withMisfireHandlingInstructionDoNothing();

        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger2", "group1")
                .withSchedule(scheduleBuilder)
                .build();

            //放入参数，运行时的方法可以获取
        jobDetail.getJobDataMap().put("JOB_PARAM_KEY", scheduleJob);

        scheduler.scheduleJob(jobDetail, trigger);

//        //暂停任务
//        if (scheduleJob.getStatus() == ScheduleStatus.PAUSE.getValue()) {
//            pauseJob(scheduler, scheduleJob.getJobId());
//        }
    }

}

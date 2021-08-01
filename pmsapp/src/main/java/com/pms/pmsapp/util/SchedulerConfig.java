package com.pms.pmsapp.util;

import java.io.IOException;
import java.util.Properties;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.pms.pmsapp.util.quartz.ComputeHoldingsJob;
import com.pms.pmsapp.util.quartz.DailyBatchJob;
import com.pms.pmsapp.util.quartz.ForexValueJob;
import com.pms.pmsapp.util.quartz.IndexValueJob;
import com.pms.pmsapp.util.quartz.NotificationMessageJob;
import com.pms.pmsapp.util.quartz.UpdateWatchlistEntryJob;


@Configuration
public class SchedulerConfig {
 
    private static final Logger log = LoggerFactory.getLogger(SchedulerConfig.class);
 
    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext) {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }
 
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory, Trigger[] jobTriggers)
            throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setJobFactory(jobFactory);
        factory.setQuartzProperties(quartzProperties());
        factory.setTriggers(jobTriggers);
        log.info("starting jobs....");
        return factory;
    }
 
    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/application.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }
    
    //Setup ComputeHoldingsJob
    
    @Bean
    public CronTriggerFactoryBean computeHoldingsJobTrigger(@Qualifier("computeHoldingsJobDetail") JobDetail jobDetail) {
    	log.info("computeHoldingsJobTrigger");
 
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setStartDelay(0L);
        factoryBean.setCronExpression("0 */45 * ? * *");
        return factoryBean;
    }
 
    @Bean
    public JobDetailFactoryBean computeHoldingsJobDetail() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(ComputeHoldingsJob.class);
        factoryBean.setDurability(true);
        return factoryBean;
    }
    
    //Setup IndexValueJob
    
    @Bean
    public CronTriggerFactoryBean indexValueJobTrigger(@Qualifier("indexValueJobDetail") JobDetail jobDetail) {
    	log.info("indexValueJobTrigger");
 
    	CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setStartDelay(0L);
    	factoryBean.setCronExpression("0 */45 * ? * *");
        return factoryBean;
    }
    
    @Bean
    public JobDetailFactoryBean indexValueJobDetail() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(IndexValueJob.class);
        factoryBean.setDurability(true);
        return factoryBean;
    }
    
    //Setup ForexValueJob
    
    @Bean
    public CronTriggerFactoryBean forexValueJobTrigger(@Qualifier("forexValueJobDetail") JobDetail jobDetail) {
    	log.info("forexValueJobTrigger");
 
    	CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setStartDelay(0L);
    	factoryBean.setCronExpression("0 */45 * ? * *");
        return factoryBean;
    }
    
    @Bean
    public JobDetailFactoryBean forexValueJobDetail() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(ForexValueJob.class);
        factoryBean.setDurability(true);
        return factoryBean;
    }
    
    //setup UpdateWatchlistEntryJob
    @Bean
    public CronTriggerFactoryBean updateWatchlistEntryJobTrigger(@Qualifier("updateWatchlistEntryJobDetail") JobDetail jobDetail) {
    	log.info("updateWatchlistEntryJobTrigger");
 
    	CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setStartDelay(0L);
    	factoryBean.setCronExpression("0 */45 * ? * *");
        return factoryBean;
    }
    
    @Bean
    public JobDetailFactoryBean updateWatchlistEntryJobDetail() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(UpdateWatchlistEntryJob.class);
        factoryBean.setDurability(true);
        return factoryBean;
    }
    
    //setup NotificationMessageJob
    @Bean
    public CronTriggerFactoryBean notificationMessageJobTrigger(@Qualifier("notificationMessageJobDetail") JobDetail jobDetail) {
    	log.info("notificationMessageJobTrigger");
 
    	CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setStartDelay(0L);
    	factoryBean.setCronExpression("0 */45 * ? * *");
        return factoryBean;
    }
    
    @Bean
    public JobDetailFactoryBean notificationMessageJobDetail() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(NotificationMessageJob.class);
        factoryBean.setDurability(true);
        return factoryBean;
    }
    
    //setup DailyBatchJob
    @Bean
    public CronTriggerFactoryBean dailyBatchJobTrigger(@Qualifier("dailyBatchJobDetail") JobDetail jobDetail) {
    	log.info("dailyBatchJobTrigger");
 
    	CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setStartDelay(0L);
    	factoryBean.setCronExpression("0 0 9 ? * * *");
        return factoryBean;
    }
    
    @Bean
    public JobDetailFactoryBean dailyBatchJobDetail() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(DailyBatchJob.class);
        factoryBean.setDurability(true);
        return factoryBean;
    }
    
}
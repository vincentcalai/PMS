package com.pms.pmsapp;

import org.hibernate.SessionFactory;
import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.pms.pmsapp.util.HibernateUtil;

@SpringBootApplication
@EnableAsync
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, 
		DataSourceTransactionManagerAutoConfiguration.class, 
		HibernateJpaAutoConfiguration.class, 
		JpaRepositoriesAutoConfiguration.class})
public class PmsappApplication {
	
	public static void main(String[] args) throws SchedulerException {
		
		SpringApplication.run(PmsappApplication.class, args);
	
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	}

}

package com.pms.pmsapp;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import com.pms.pmsapp.util.HibernateUtil;

@SpringBootApplication
@EnableAsync
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
//		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class,
//		JpaRepositoriesAutoConfiguration.class })
@EntityScan
@EnableJpaRepositories
public class PmsappApplication {

	public static void main(String[] args) {

		SpringApplication.run(PmsappApplication.class, args);

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	}

}

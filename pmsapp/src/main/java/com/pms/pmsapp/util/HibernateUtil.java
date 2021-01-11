package com.pms.pmsapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static synchronized SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
        	sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                    buildSessionFactory();
        }
        return sessionFactory;
    }
}

package com.pms.pmsapp.common.repository.dao;

import java.sql.CallableStatement;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.pms.pmsapp.util.HibernateUtil;

@Repository
public class MessageDaoImpl implements MessageDao {

	private static final Logger log = LoggerFactory.getLogger(MessageDaoImpl.class);

	@Override
	public void genWatchlistNotiMsg() {
		log.info("genWatchlistNotiMsg in DaoImpl..");

		CallableStatement callableStatement = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String callPkg = "{call PG_NOTIFICATION_MSG.gen_watchlist_noti_msg()}";
			callableStatement = ((SessionImpl) session).connection().prepareCall(callPkg);
			callableStatement.executeUpdate();
			((SessionImpl) session).connection().commit();

			session.close();

		} catch (Exception e) {
			log.info("exception = " + e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

}

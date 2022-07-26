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

//	@Override
//	public List<Message> retrieveMsg(String loginUser) {
//		log.info("retrieveMsg in DaoImpl..");
//		try {
//			Session session = HibernateUtil.getSessionFactory().openSession();
//
//			String sql = "select * from PMS_MSG where username = :user ORDER BY gen_dt desc ";
//
//			NativeQuery sqlQuery = session.createSQLQuery(sql);
//
//			sqlQuery.addEntity(Message.class).setParameter("user", loginUser);
//
//			List<Message> messages = sqlQuery.list();
//
//			return messages;
//		} catch (Exception e) {
//			// convert to HibernateException then to DataAccessException
//			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
//		}
//	}

//	@Override
//	public int retrieveMsgCnt(String loginUser) {
//		log.info("retrieveMsgCnt in DaoImpl..");
//		try {
//			Session session = HibernateUtil.getSessionFactory().openSession();
//
//			String sql = "select count(*) from PMS_MSG where username = :user AND del_ind = 'N' ";
//
//			NativeQuery sqlQuery = session.createSQLQuery(sql);
//
//			sqlQuery.setParameter("user", loginUser);
//
//			int msgCnt = ((BigDecimal) sqlQuery.uniqueResult()).intValue();
//
//			return msgCnt;
//		} catch (Exception e) {
//			// convert to HibernateException then to DataAccessException
//			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
//		}
//	}

//	@Override
//	public void softDelReadMsg(String loginUser) {
//		log.info("softDelReadMsg in DaoImpl..");
//		try {
//			Session session = HibernateUtil.getSessionFactory().openSession();
//			Transaction transaction = session.beginTransaction();
//
//			String sql = "update PMS_MSG set DEL_IND = 'Y' where USERNAME = :user ";
//
//			NativeQuery query = session.createSQLQuery(sql);
//			query.setParameter("user", loginUser);
//			query.executeUpdate();
//
//			transaction.commit();
//			session.close();
//
//		} catch (Exception e) {
//			// convert to HibernateException then to DataAccessException
//			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
//		}
//	}

//	@Override
//	public void deleteAllMsg(String loginUser) {
//		log.info("deleteAllMsg in DaoImpl..");
//		try {
//			Session session = HibernateUtil.getSessionFactory().openSession();
//			Transaction transaction = session.beginTransaction();
//
//			String sql = "delete from PMS_MSG where USERNAME = :user ";
//
//			NativeQuery query = session.createSQLQuery(sql);
//			query.setParameter("user", loginUser);
//			query.executeUpdate();
//
//			transaction.commit();
//			session.close();
//
//		} catch (Exception e) {
//			// convert to HibernateException then to DataAccessException
//			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
//		}
//	}

}

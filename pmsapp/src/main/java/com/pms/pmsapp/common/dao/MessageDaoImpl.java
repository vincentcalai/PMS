package com.pms.pmsapp.common.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionImpl;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.pms.pmsapp.portfolio.data.PortfolioTrans;
import com.pms.pmsapp.portfolio.data.StockWrapper;
import com.pms.pmsapp.sysadmin.data.User;
import com.pms.pmsapp.util.HibernateUtil;
import com.pms.pmsapp.watchlist.data.Watchlist;
import com.pms.pmsapp.watchlist.data.WatchlistEntry;
import com.pms.pmsapp.watchlist.data.WatchlistNotification;

import yahoofinance.YahooFinance;

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
		callableStatement = ((SessionImpl)session).connection().prepareCall(callPkg);
		callableStatement.executeUpdate();
		((SessionImpl)session).connection().commit();
		
		session.close();

		} catch (Exception e) {
			log.info("exception = " + e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

}

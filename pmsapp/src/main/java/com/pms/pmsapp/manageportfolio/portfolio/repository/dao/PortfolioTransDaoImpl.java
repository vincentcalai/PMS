package com.pms.pmsapp.manageportfolio.portfolio.repository.dao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.pms.pmsapp.manageportfolio.portfolio.data.PortfolioTrans;
import com.pms.pmsapp.util.HibernateUtil;

@Repository
public class PortfolioTransDaoImpl implements PortfolioTransDao {

	private static final Logger log = LoggerFactory.getLogger(PortfolioTransDaoImpl.class);

	public List<PortfolioTrans> findAll(long portId, Pageable pageable) {
		log.info("findAll Trans in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT * FROM PMS_PORT_TRANS where port_id = :portId order by created_dt desc,ID desc";

			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.addEntity(PortfolioTrans.class);
			sqlQuery.setParameter("portId", portId);
			sqlQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
			sqlQuery.setMaxResults(pageable.getPageSize());

			List<PortfolioTrans> portfolioTrans = sqlQuery.list();

			session.close();

			return portfolioTrans;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	public void populateToHolding(long id, long portId) {
		log.info("populate to holdings in DaoImpl..");

		CallableStatement callableStatement = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String callStoreProc = "{call SP_POPULATE_PORT_HOLD(?,?,?)}";
			callableStatement = ((SessionImpl) session).connection().prepareCall(callStoreProc);
			callableStatement.setLong(1, id);
			callableStatement.setLong(2, portId);
			callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
			callableStatement.executeUpdate();
			String result = callableStatement.getString(3);
			((SessionImpl) session).connection().commit();

			session.close();

		} catch (Exception e) {
			log.info("exception = " + e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	public int validateSellAction(PortfolioTrans portfolioTrans) {
		long portId = portfolioTrans.getPortId();
		String stockSym = portfolioTrans.getStockSymbol();
		int transShare = portfolioTrans.getNoOfShare();

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT NVL(MIN(total_share), 0) - :transShare "
					+ "FROM pms_port_hold where port_id = :portId and stock_sym = :stockSym";

			Query query = session.createSQLQuery(sql);
			query.setParameter("portId", portId);
			query.setParameter("stockSym", stockSym);
			query.setParameter("transShare", transShare);
			int result = ((BigDecimal) query.uniqueResult()).intValue();
			return result;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	public int findCurrentStockHold(PortfolioTrans portfolioTrans) {
		long portId = portfolioTrans.getPortId();
		String stockSym = portfolioTrans.getStockSymbol();

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT NVL(MIN(total_share), 0) "
					+ "FROM pms_port_hold where port_id = :portId and stock_sym = :stockSym";

			Query query = session.createSQLQuery(sql);
			query.setParameter("portId", portId);
			query.setParameter("stockSym", stockSym);
			int result = ((BigDecimal) query.uniqueResult()).intValue();
			return result;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

}

package com.pms.pmsapp.manageportfolio.portfolio.repository.dao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

	public void addPortfolioTrans(PortfolioTrans portfolioTrans) {
		log.info("adding portfolio trans in DaoImpl..");

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			String sql = "insert into PMS_PORT_TRANS (ID,PORT_ID,STOCK_NAM,STOCK_SYM,"
					+ "STOCK_EXCHG,NO_OF_SHARE,TRANS_PRICE,TOTAL_AMT,ACTION,CREATED_BY,"
					+ "CREATED_DT,REMARKS) values (:id, " + ":portfolioId, :stockName, :stockSymbol,"
					+ " :stockExchg, :noOfShare, "
					+ "to_char(:transPrice,'9999.99'), (:transPrice * :noOfShare), :action, "
					+ ":createdBy, :backDatedDate, :remarks) ";

			Query query = session.createSQLQuery(sql);
			query.setParameter("id", portfolioTrans.getId());
			query.setParameter("portfolioId", portfolioTrans.getPortId());
			query.setParameter("stockName", portfolioTrans.getStockName());
			query.setParameter("stockSymbol", portfolioTrans.getStockSymbol());
			query.setParameter("stockExchg", portfolioTrans.getStockExchg());
			query.setParameter("noOfShare", portfolioTrans.getNoOfShare());
			query.setParameter("transPrice", portfolioTrans.getTransPrice());
			query.setParameter("action", portfolioTrans.getAction());
			query.setParameter("backDatedDate", portfolioTrans.getBackDatedDate());
			query.setParameter("createdBy", portfolioTrans.getCreatedBy());
			query.setParameter("remarks", portfolioTrans.getRemarks());
			query.executeUpdate();

			transaction.commit();
			session.close();
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

	@Override
	public List<PortfolioTrans> searchTrans(long portId, String searchText, Pageable pageable) {
		log.info("searchTrans Trans in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT * FROM PMS_PORT_TRANS where port_id = :portId and "
					+ "(UPPER(stock_nam) like :searchText "
					+ "or stock_sym like :searchText) order by created_dt desc,ID desc";

			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.addEntity(PortfolioTrans.class);
			sqlQuery.setParameter("portId", portId);
			sqlQuery.setParameter("searchText", searchText);
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

}

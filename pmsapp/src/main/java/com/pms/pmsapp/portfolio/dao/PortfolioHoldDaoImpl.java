package com.pms.pmsapp.portfolio.dao;

import java.io.IOException;
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

import com.pms.pmsapp.portfolio.data.MktExchg;
import com.pms.pmsapp.portfolio.data.PortfolioHold;
import com.pms.pmsapp.portfolio.data.PortfolioTrans;
import com.pms.pmsapp.portfolio.data.StockWrapper;
import com.pms.pmsapp.util.HibernateUtil;

import yahoofinance.YahooFinance;


@Repository
public class PortfolioHoldDaoImpl implements PortfolioHoldDao {
	
	private static final Logger log = LoggerFactory.getLogger(PortfolioHoldDaoImpl.class);
	
	public List<PortfolioHold> findAllHold(long id, Pageable pageable){
		log.info("findAllHold Holding in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			String sql = "SELECT * FROM PMS_PORT_HOLD where port_id = :id order by last_trans_dt desc ";				
					
			SQLQuery sqlQuery = session.createSQLQuery(sql);
	
			sqlQuery.addEntity(PortfolioHold.class).setParameter("id", id);
			sqlQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
			sqlQuery.setMaxResults(pageable.getPageSize());
	
			List<PortfolioHold> portfolioHold = sqlQuery.list();
			
			
			return portfolioHold;
		
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}
	
	@Override
	public List<MktExchg> findAllMktExchg(){
		log.info("findAllMktExchg Hold in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
	
			String sql = "SELECT * FROM PMS_MKT_EXCHG order by MKT_EXCHG_NAME desc";
	
			SQLQuery sqlQuery = session.createSQLQuery(sql);
	
			sqlQuery.addEntity(MktExchg.class);
	
			List<MktExchg> mktExchg = sqlQuery.list();
	
			session.close();
	
			return mktExchg;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public StockWrapper findStock(String stockSym) {
		try {
			return new StockWrapper(YahooFinance.get(stockSym));
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void computeHoldingsJob(String stock, BigDecimal lastTransPrice) {
		log.info("computeHoldingsJob in DaoImpl..");

		CallableStatement callableStatement = null;

		try {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String callStoreProc = "{call SP_COMPUTE_HOLD(?,?)}";
		callableStatement = ((SessionImpl)session).connection().prepareCall(callStoreProc);
		callableStatement.setString(1, stock);
		callableStatement.setBigDecimal(2, lastTransPrice);
		callableStatement.executeUpdate();
		((SessionImpl)session).connection().commit();
		
		session.close();

		} catch (Exception e) {
			log.info("exception = " + e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public List<String> findAllStockSym() {
		log.info("findAllStockSym Holding in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			String sql = "select distinct stock_sym from pms_port_hold";				
					
			SQLQuery sqlQuery = session.createSQLQuery(sql);
	
			List<String> stockSymList = sqlQuery.list();
			
			return stockSymList;
		
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public long findAllCount(long id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			String sql = "SELECT count(*) FROM PMS_PORT_HOLD where port_id = :id";				
					
			SQLQuery sqlQuery = session.createSQLQuery(sql);
	
			sqlQuery.setParameter("id", id);
	
			long result = ((BigDecimal) sqlQuery.uniqueResult()).longValue();
			
			
			return result;
		
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}
	
}

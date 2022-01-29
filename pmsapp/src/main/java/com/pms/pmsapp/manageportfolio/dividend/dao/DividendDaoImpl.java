package com.pms.pmsapp.manageportfolio.dividend.dao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionImpl;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.pms.pmsapp.manageportfolio.dividend.data.Dividend;
import com.pms.pmsapp.manageportfolio.dividend.data.DividendDet;
import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;
import com.pms.pmsapp.util.HibernateUtil;


@Repository
public class DividendDaoImpl implements DividendDao {
	
	private static final Logger log = LoggerFactory.getLogger(DividendDaoImpl.class);

	@Override
	public List<Portfolio> getPortfolios() {
		String sql = "SELECT * FROM PMS_PORT order by ID";
		Session session = HibernateUtil.getSessionFactory().openSession();
		NativeQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.addEntity(Portfolio.class);
		List<Portfolio> portfolios = sqlQuery.list();
		return portfolios;
	}

	@Override
	public long saveDivRec(Dividend dividend) {
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
		    
			Long id = (Long) session.save(dividend);
			
			transaction.commit();
			return id;
		}catch(Exception e){
			log.error(e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public void populateDivRec(long id, Date exDate, BigDecimal adjDiv) {
		log.info("populate dividend records in DaoImpl..");

		java.sql.Date sqlExDate = new java.sql.Date(exDate.getTime());
		
		CallableStatement callableStatement = null;

		try {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String callStoreProc = "{call PG_DIV_PROCESS.SP_POPULATE_DIV_REC(?,?,?)}";
		callableStatement = ((SessionImpl)session).connection().prepareCall(callStoreProc);
		callableStatement.setLong(1, id);
		callableStatement.setDate(2, sqlExDate);
		callableStatement.setBigDecimal(3, adjDiv);
		callableStatement.executeUpdate();
		((SessionImpl)session).connection().commit();
		
		session.close();

		} catch (Exception e) {
			log.info("exception = " + e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public List<String> retrieveDivYears(long portId) {
		String sql = "SELECT DISTINCT TO_CHAR(EX_DATE, 'YYYY') from PMS_PORT_DIV_DET "
				+ "WHERE PORT_ID = :portId ORDER BY TO_CHAR(EX_DATE, 'YYYY') DESC";
		Session session = HibernateUtil.getSessionFactory().openSession();
		NativeQuery sqlQuery = session.createSQLQuery(sql).setParameter("portId", portId);
		List<String> divYearsList = sqlQuery.list();
		return divYearsList;
	}

	@Override
	public List<DividendDet> retrieveDivDet(Long portId, String divYear) {
		String sql = "SELECT ID, DIV_ID, PORT_ID, STOCK_NAM, STOCK_SYM, STOCK_EXCHG, EX_DATE, NO_OF_SHARE, ADJ_DIV, DIV_PAYOUT, SGD_DIV_PAYOUT "
				+ "FROM PMS_PORT_DIV_DET WHERE PORT_ID = :portId AND TO_CHAR(EX_DATE,'YYYY') = :year ORDER BY ID DESC";
		Session session = HibernateUtil.getSessionFactory().openSession();
		NativeQuery sqlQuery = session.createSQLQuery(sql)
				.addEntity(DividendDet.class)
				.setParameter("portId", portId)
				.setParameter("year", divYear);
		List<DividendDet> divDetList = sqlQuery.list();
		return divDetList;
	}

	@Override
	public BigDecimal retrieveTotalDiv(long portId) {
		String sql = "SELECT SUM(SGD_DIV_PAYOUT) FROM PMS_PORT_DIV_DET WHERE PORT_ID = :portId";
		Session session = HibernateUtil.getSessionFactory().openSession();
		NativeQuery sqlQuery = session.createSQLQuery(sql).setParameter("portId", portId);
		BigDecimal totalDiv = (BigDecimal) sqlQuery.uniqueResult();
		return totalDiv;
	}

	@Override
	public BigDecimal retrieveTotalYearDiv(long portId, String divYear) {
		String sql = "SELECT SUM(SGD_DIV_PAYOUT) FROM PMS_PORT_DIV_DET WHERE PORT_ID = :portId AND TO_CHAR(EX_DATE,'YYYY') = :divYear";
		Session session = HibernateUtil.getSessionFactory().openSession();
		NativeQuery sqlQuery = session.createSQLQuery(sql)
				.setParameter("portId", portId)
				.setParameter("divYear", divYear);
		BigDecimal totalDiv = (BigDecimal) sqlQuery.uniqueResult();
		return totalDiv;
	}

	@Override
	public List<Dividend> findAllCurrHoldDiv() {
		String sql = "select * from PMS_PORT_DIV where CURR_HOLD_IND = 'Y' order by PORT_ID, STOCK_SYM";
		Session session = HibernateUtil.getSessionFactory().openSession();
		NativeQuery sqlQuery = session.createSQLQuery(sql)
				.addEntity(Dividend.class);
		List<Dividend> divList = sqlQuery.list();
		return divList;
	}

	@Override
	public void updateDailyDivRec(Dividend divRec, Date exDate, BigDecimal adjDiv) {
		log.info("update daily dividend records- id: " + divRec.getId() + " portId: " + divRec.getPortId() + " exDate: " + exDate + " adjDiv: " + adjDiv);

		java.sql.Date sqlExDate = new java.sql.Date(exDate.getTime());
		
		CallableStatement callableStatement = null;

		try {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String callStoreProc = "{call PG_DIV_PROCESS.SP_POPULATE_DIV_REC(?,?,?,?)}";
		callableStatement = ((SessionImpl)session).connection().prepareCall(callStoreProc);
		callableStatement.setLong(1, divRec.getId());
		callableStatement.setLong(2, divRec.getPortId());
		callableStatement.setDate(3, sqlExDate);
		callableStatement.setBigDecimal(4, adjDiv);
		callableStatement.executeUpdate();
		((SessionImpl)session).connection().commit();
		
		session.close();

		} catch (Exception e) {
			log.info("exception = " + e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public void updateDivRec(long portId, String stockSym, int noOfShare) {
		
		log.info("updateDivRec - portId: " + portId +  " stockSym: " + stockSym);
		CallableStatement callableStatement = null;

		try {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String callStoreProc = "{call PG_DIV_PROCESS.SP_UPDATE_DIV_REC(?,?,?)}";
		callableStatement = ((SessionImpl)session).connection().prepareCall(callStoreProc);
		callableStatement.setLong(1, portId);
		callableStatement.setString(2, stockSym);
		callableStatement.setInt(3, noOfShare);
		callableStatement.executeUpdate();
		((SessionImpl)session).connection().commit();
		
		session.close();

		} catch (Exception e) {
			log.info("exception = " + e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

}

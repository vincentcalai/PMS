package com.pms.pmsapp.profitloss.dao;

import java.sql.CallableStatement;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.pms.pmsapp.portfolio.data.PortfolioHold;
import com.pms.pmsapp.profitloss.data.RealPL;
import com.pms.pmsapp.profitloss.data.RealTotalPL;
import com.pms.pmsapp.profitloss.data.UnrealPL;
import com.pms.pmsapp.profitloss.data.UnrealTotalPL;
import com.pms.pmsapp.util.HibernateUtil;


@Repository
public class ProfitLossDaoImpl implements ProfitLossDao {
	
	private static final Logger log = LoggerFactory.getLogger(ProfitLossDaoImpl.class);

	@Override
	public List<String> getPortfolios() {
		String sqlQuery = "SELECT PORT_NAME FROM PMS_PORT order by ID";
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<String> portfolios = session.createSQLQuery(sqlQuery).list();
		return portfolios;
	}

	@Override
	public List<String> getAllCurr() {
		String sqlQuery = "select distinct CURR from PMS_MKT_EXCHG";
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<String> currencys = session.createSQLQuery(sqlQuery).list();
		return currencys;
	}

	@Override
	public List<UnrealPL> getUnrealisedList() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			String sql = "SELECT PORT_ID, STOCK_NAM, STOCK_SYM, STOCK_EXCHG, DOM_CURR, TOTAL_SHARE, AVG_PRICE, TOTAL_AMT, "
					+ "LAST_TRANS_PRICE, MKT_VALUE, PROFIT_LOSS, CONV_PROFIT_LOSS, PROFIT_LOSS_PCT from PMS_UNREAL_PL order by STOCK_NAM";				
					
			SQLQuery sqlQuery = session.createSQLQuery(sql);
	
			sqlQuery.addEntity(UnrealPL.class);
	
			List<UnrealPL> unrealPLList = sqlQuery.list();
			
			return unrealPLList;
		
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
		
	}

	@Override
	public void computeUnrealisedList(String portfolio, String currency) {
		log.info("computeUnrealisedList in DaoImpl..");

		CallableStatement callableStatement = null;

		try {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String callStoreProc = "{call PG_COMPUTE_PL.compute_unreal_pl(?,?)}";
		callableStatement = ((SessionImpl)session).connection().prepareCall(callStoreProc);
		callableStatement.setString(1, portfolio);
		callableStatement.setString(2, currency);
		callableStatement.executeUpdate();
		((SessionImpl)session).connection().commit();
		
		session.close();

		} catch (Exception e) {
			log.info("exception = " + e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public List<RealPL> getRealisedList(String portfolio, String currency) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			String sql = "select r.* from pms_real_pl r  inner join pms_port p  "
					+ "on r.port_id = p.id where p.port_name = :portfolio " 
					+ "order by sell_dt desc";				
					
			SQLQuery sqlQuery = session.createSQLQuery(sql);
	
			sqlQuery.addEntity(RealPL.class)
			.setParameter("portfolio", portfolio);
	
			List<RealPL> realPLList = sqlQuery.list();
			
			return realPLList;
			
//			String sqlQuery = "SELECT * FROM PMS_REAL_PL";
//			Session session = HibernateUtil.getSessionFactory().openSession();
//			List<RealPL> realPLList = session.createSQLQuery(sqlQuery).list();
//			return realPLList;
		
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}
	
	@Override
	public void computeRealisedList(String portfolio, String currency) {
		log.info("computeRealisedList in DaoImpl..");

		CallableStatement callableStatement = null;

		try {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String callStoreProc = "{call PG_COMPUTE_PL.compute_real_pl(?,?)}";
		callableStatement = ((SessionImpl)session).connection().prepareCall(callStoreProc);
		callableStatement.setString(1, portfolio);
		callableStatement.setString(2, currency);
		callableStatement.executeUpdate();
		((SessionImpl)session).connection().commit();
		
		session.close();

		} catch (Exception e) {
			log.info("exception = " + e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public UnrealTotalPL getUnrealisedTotalList(String portfolio) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String sql = "select r.* from pms_unreal_total_pl r  inner join pms_port p "
				+ "on r.port_id = p.id where p.port_name = :portfolio";				
				
		SQLQuery sqlQuery = session.createSQLQuery(sql)
				.setParameter("portfolio", portfolio);

		sqlQuery.addEntity(UnrealTotalPL.class);
		
		UnrealTotalPL unrealTotalPLList = (UnrealTotalPL) sqlQuery.uniqueResult();
		
		return unrealTotalPLList;
	}

	@Override
	public RealTotalPL getRealisedTotalList(String portfolio) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			String sql = "select r.* from pms_real_total_pl r  inner join pms_port p "
					+ "on r.port_id = p.id where p.port_name = :portfolio";				
					
			SQLQuery sqlQuery = session.createSQLQuery(sql)
					.setParameter("portfolio", portfolio);
	
			sqlQuery.addEntity(RealTotalPL.class);
	
			RealTotalPL realTotalPLList = (RealTotalPL) sqlQuery.uniqueResult();
			
			return realTotalPLList;
		
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}
	
	
}

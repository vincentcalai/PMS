package com.pms.pmsapp.performance.dao;

import com.pms.pmsapp.performance.data.ETFPerformance;
import com.pms.pmsapp.performance.data.GphyPerformance;
import com.pms.pmsapp.performance.data.StockPerformance;
import com.pms.pmsapp.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

@Repository
public class PerformanceDaoImpl implements PerformanceDao {

	public ETFPerformance findEtfPerformance(String portfolio) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String sql = "select sum(CONVERT_TO_SGD(total_amt, dom_curr)) as INVESTAMT, sum(CONVERT_TO_SGD(mkt_value, dom_curr)) as CURRENTVAL, "
				+ "sum(CONVERT_TO_SGD(mkt_value, dom_curr)) - sum(CONVERT_TO_SGD(total_amt, dom_curr)) as PROFIT, "
				+ "(sum(CONVERT_TO_SGD(mkt_value, dom_curr)) - sum(CONVERT_TO_SGD(total_amt, dom_curr))) / sum(CONVERT_TO_SGD(mkt_value, dom_curr)) * 100 as PROFITPCT "
				+ "from pms_unreal_pl r " + "inner join pms_port p " + "on r.port_id = p.id  "
				+ "where p.port_name = :portfolio and r.stock_nam like '%ETF%'";

		SQLQuery sqlQuery = session.createSQLQuery(sql).setParameter("portfolio", portfolio);

		BigDecimal investAmt = new BigDecimal(0);
		BigDecimal currentVal = new BigDecimal(0);
		BigDecimal profit = new BigDecimal(0);
		BigDecimal profitPct = new BigDecimal(0);

		List<Object> result = (List<Object>) sqlQuery.list();
		Iterator itr = result.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			if (obj[0] != null) {
				investAmt = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[0])));
			}
			if (obj[1] != null) {
				currentVal = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[1])));
			}
			if (obj[2] != null) {
				profit = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[2])));
			}
			if (obj[3] != null) {
				profitPct = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[3])));
			}
		}

		ETFPerformance etfPerformance = new ETFPerformance(ETFPerformance.etfName, investAmt, currentVal, profit,
				profitPct);

		return etfPerformance;
	}

	public StockPerformance findStockPerformance(String portfolio) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String sql = "select sum(CONVERT_TO_SGD(total_amt, dom_curr)) as INVESTAMT, sum(CONVERT_TO_SGD(mkt_value, dom_curr)) as CURRENTVAL, "
				+ "sum(CONVERT_TO_SGD(mkt_value, dom_curr)) - sum(CONVERT_TO_SGD(total_amt, dom_curr)) as PROFIT, "
				+ "(sum(CONVERT_TO_SGD(mkt_value, dom_curr)) - sum(CONVERT_TO_SGD(total_amt, dom_curr))) / sum(CONVERT_TO_SGD(mkt_value, dom_curr)) * 100 as PROFITPCT "
				+ "from pms_unreal_pl r " + "inner join pms_port p " + "on r.port_id = p.id  "
				+ "where p.port_name = :portfolio and r.stock_nam not like '%ETF%'";

		SQLQuery sqlQuery = session.createSQLQuery(sql).setParameter("portfolio", portfolio);

		BigDecimal investAmt = new BigDecimal(0);
		BigDecimal currentVal = new BigDecimal(0);
		BigDecimal profit = new BigDecimal(0);
		BigDecimal profitPct = new BigDecimal(0);

		List<Object> result = (List<Object>) sqlQuery.list();
		Iterator itr = result.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			if (obj[0] != null) {
				investAmt = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[0])));
			}
			if (obj[1] != null) {
				currentVal = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[1])));
			}
			if (obj[2] != null) {
				profit = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[2])));
			}
			if (obj[3] != null) {
				profitPct = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[3])));
			}
		}

		StockPerformance stockPerformance = new StockPerformance(StockPerformance.stockName, investAmt, currentVal,
				profit, profitPct);

		return stockPerformance;
	}

	public GphyPerformance findGphyPerformance(String selectedPortfolio) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String sql = "select CONVERT_TO_SGD(sum(h.mkt_value), m.CURR) as SGDCURR, m.gphy from pms_port_hold h "
				+ "inner join pms_port p on p.id = h.port_id inner join pms_mkt_exchg m on h.stock_exchg = m.mkt_exchg_name where port_name = :portfolio group by m.gphy, m.CURR";

		SQLQuery sqlQuery = session.createSQLQuery(sql).setParameter("portfolio", selectedPortfolio);

		BigDecimal usAllocation = new BigDecimal(0);
		BigDecimal hkAllocation = new BigDecimal(0);
		BigDecimal sgAllocation = new BigDecimal(0);

		List<Object> result = (List<Object>) sqlQuery.list();
		Iterator itr = result.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			if (obj[1] != null && obj[1].equals("US") && obj[0] != null) {
				usAllocation = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[0])));
			} else if (obj[1] != null && obj[1].equals("HK") && obj[0] != null) {
				hkAllocation = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[0])));
			} else if (obj[1] != null && obj[1].equals("SG") && obj[0] != null) {
				sgAllocation = BigDecimal.valueOf(Double.valueOf(String.valueOf(obj[0])));
			}
		}
		return new GphyPerformance(usAllocation, hkAllocation, sgAllocation);

	}

	@Override
	public BigDecimal findUserBankBal(String username) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "select bank_bal from pms_cash_sol where usr_nam = :username ";

			NativeQuery sqlQuery = session.createSQLQuery(sql);

			sqlQuery.setParameter("username", username);

			BigDecimal bankBal = (BigDecimal) sqlQuery.uniqueResult();

			return bankBal;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}

	}

	@Override
	public BigDecimal findUserTotalInvestment(String username) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "select sum(convert_to_sgd(mkt_value, coalesce(spec.dom_curr, hold.curr))) from ( "
					+ "select h.port_id, h.stock_sym, h.stock_nam, convert_to_sgd(mkt_value, e.curr), mkt_value, e.curr  "
					+ "from pms_usr u, pms_port p, pms_port_hold h, pms_mkt_exchg e \r\n"
					+ "where u.usr_nam = p.created_by and p.id = h.port_id and h.stock_exchg = e.mkt_exchg_name and usr_nam = :username "
					+ ") hold " + "left join " + "( " + "select p.stock_sym, s.dom_curr from pms_port_hold p  "
					+ "inner join pms_stock_curr_exchg_spec s " + "on p.stock_sym = s.stock_sym " + ") spec "
					+ "on hold.stock_sym = spec.stock_sym";

			NativeQuery sqlQuery = session.createSQLQuery(sql);

			sqlQuery.setParameter("username", username);

			BigDecimal totalInvesment = (BigDecimal) sqlQuery.uniqueResult();

			return totalInvesment;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public String updateCashBal(int newCashBal, String username) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			String sql = "update pms_cash_sol set bank_bal = :cashbal where usr_nam = :username";
			
			
			NativeQuery query = session.createSQLQuery(sql);
			query.setParameter("cashbal", newCashBal);
			query.setParameter("username", username);		
			query.executeUpdate();
			
			transaction.commit();
			session.close();
		
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
		
		return "Update Successful!";
	}
}

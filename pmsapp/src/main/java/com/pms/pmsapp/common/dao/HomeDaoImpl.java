package com.pms.pmsapp.common.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.pms.pmsapp.common.data.Forex;
import com.pms.pmsapp.common.data.Index;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.util.HibernateUtil;

import yahoofinance.YahooFinance;

@Repository
public class HomeDaoImpl implements HomeDao {

	private static final Logger log = LoggerFactory.getLogger(HomeDaoImpl.class);

	@Override
	public List<Index> findAllIndex() {
		log.info("findAllIndex in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT * FROM PMS_INDEX order by ID asc ";

			NativeQuery sqlQuery = session.createSQLQuery(sql);

			sqlQuery.addEntity(Index.class);

			List<Index> indexList = sqlQuery.list();

			return indexList;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public StockWrapper findStock(String indexSym) {
		try {
			return new StockWrapper(YahooFinance.get(indexSym));
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void updateLastVal(Index index) {
		log.info("updateLastVal index in DaoImpl..");

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			String sql = "update PMS_INDEX set last = :last, change = :change, "
					+ "change_pct = :changePct, last_updated_dt = sysdate " + "where index_sym = :indexSym";

			NativeQuery query = session.createSQLQuery(sql);
			query.setParameter("last", index.getLast());
			query.setParameter("change", index.getChange());
			query.setParameter("changePct", index.getChangePct());
			query.setParameter("indexSym", index.getIdxSym());
			query.executeUpdate();

			transaction.commit();
			session.close();

		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public void updateLastVal(Forex forex) {
		log.info("updateLastVal forex in DaoImpl..");

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			String sql = "update pms_forex set last = :last, change = :change, "
					+ "change_pct = :changePct, last_updated_dt = sysdate where forex_sym = :forexSymbol";

			NativeQuery query = session.createSQLQuery(sql);
			query.setParameter("last", forex.getLast());
			query.setParameter("change", forex.getChange());
			query.setParameter("changePct", forex.getChangePct());
			query.setParameter("forexSymbol", forex.getForexSymbol());
			query.executeUpdate();

			transaction.commit();
			session.close();

		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}

	}

	@Override
	public List<Forex> findAllForex() {
		log.info("findAllForex in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT * FROM PMS_FOREX order by ID asc ";

			NativeQuery sqlQuery = session.createSQLQuery(sql);

			sqlQuery.addEntity(Forex.class);

			List<Forex> forexList = sqlQuery.list();

			return forexList;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public StockWrapper findForex(String forexSym) {
		try {
			return new StockWrapper(YahooFinance.get(forexSym));
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return null;
	}

}

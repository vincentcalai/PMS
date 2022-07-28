package com.pms.pmsapp.manageportfolio.portfolio.repository.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;
import com.pms.pmsapp.util.HibernateUtil;

@Repository
public class PortfolioDaoImpl implements PortfolioDao {

	private static final Logger log = LoggerFactory.getLogger(PortfolioDaoImpl.class);

	public List<Portfolio> findAll(Pageable pageable) {
		log.info("findAll in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT * FROM PMS_PORT order by ID desc ";

			NativeQuery sqlQuery = session.createSQLQuery(sql);

			sqlQuery.addEntity(Portfolio.class);
			sqlQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
			sqlQuery.setMaxResults(pageable.getPageSize());

			List<Portfolio> portfolio = sqlQuery.list();

			return portfolio;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	public Portfolio updatePortfolio(Portfolio portfolioForm) {
		log.info("updating portfolio in DaoImpl..");

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			String sql = "update PMS_PORT set port_name =:portfolioName, remarks = :remarks, "
					+ "last_mdfy_by = :lastMdfyBy, last_mdfy_dt = sysdate where id = :id";

			log.info("id: " + portfolioForm.getId().toString());

			NativeQuery query = session.createSQLQuery(sql);
			query.setParameter("id", portfolioForm.getId());
			query.setParameter("portfolioName", portfolioForm.getPortfolioName());
			query.setParameter("remarks", portfolioForm.getRemarks());
			query.setParameter("lastMdfyBy", portfolioForm.getLastMdfyBy());
			query.executeUpdate();

			transaction.commit();
			session.close();

			return portfolioForm;

		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	public void deletePortfolio(long id) {
		log.info("deleting portfolio in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			String sql1 = "delete from PMS_PORT where id = :id";
			String sql2 = "delete from PMS_PORT_TRANS where port_id = :id";
			String sql3 = "delete from PMS_PORT_HOLD where port_id = :id";
			String sql4 = "delete from PMS_UNREAL_PL where port_id = :id";
			String sql5 = "delete from PMS_REAL_PL where port_id = :id";

			NativeQuery query = session.createSQLQuery(sql1);
			query.setParameter("id", id);
			query.executeUpdate();

			NativeQuery query2 = session.createSQLQuery(sql2);
			query2.setParameter("id", id);
			query2.executeUpdate();

			NativeQuery query3 = session.createSQLQuery(sql3);
			query3.setParameter("id", id);
			query3.executeUpdate();

			NativeQuery query4 = session.createSQLQuery(sql4);
			query4.setParameter("id", id);
			query4.executeUpdate();

			NativeQuery query5 = session.createSQLQuery(sql5);
			query5.setParameter("id", id);
			query5.executeUpdate();

			transaction.commit();
			session.close();

		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	public boolean checkPortfolioExist(String portfolioName) {
		boolean portfolioExist = false;

		String sqlQuery = "SELECT count(*) FROM PMS_PORT where port_name = :portfolioName";
		Session session = HibernateUtil.getSessionFactory().openSession();

		NativeQuery query = session.createSQLQuery(sqlQuery);
		query.setParameter("portfolioName", portfolioName);

		Integer totalRec = ((BigDecimal) query.uniqueResult()).intValue();
		if (totalRec > 0)
			portfolioExist = true;

		return portfolioExist;
	}

	public boolean checkPortfolioExist(Long portfolioId, String portfolioName) {
		boolean portfolioExist = false;

		String sqlQuery = "SELECT count(*) FROM PMS_PORT where port_name = :portfolioName and id <> :id";
		Session session = HibernateUtil.getSessionFactory().openSession();

		NativeQuery query = session.createSQLQuery(sqlQuery);
		query.setParameter("portfolioName", portfolioName);
		query.setParameter("id", portfolioId);

		Integer totalRec = ((BigDecimal) query.uniqueResult()).intValue();
		if (totalRec > 0)
			portfolioExist = true;

		return portfolioExist;
	}

	@Override
	public long findAllCount() {
		log.info("findAllCount Trans in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT count(*) FROM PMS_PORT";

			SQLQuery sqlQuery = session.createSQLQuery(sql);

			long result = ((BigDecimal) sqlQuery.uniqueResult()).longValue();

			session.close();

			return result;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public long getPortIdFromPortName(String portfolioName) {
		log.info("getPortIdFromPortName in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT ID FROM PMS_PORT WHERE PORT_NAME = :portName";

			SQLQuery sqlQuery = session.createSQLQuery(sql).setParameter("portName", portfolioName);

			long result = ((BigDecimal) sqlQuery.uniqueResult()).longValue();

			session.close();

			return result;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

}

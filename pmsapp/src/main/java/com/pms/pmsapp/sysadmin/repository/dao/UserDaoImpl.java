package com.pms.pmsapp.sysadmin.repository.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.pms.pmsapp.util.HibernateUtil;
import com.pms.pmsapp.util.constant.ConstantUtil;

@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

	@Override
	public void addUserRole(String username, String newUserRole) {
		log.info("addUserRole in DaoImpl..");

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			String sql = "Insert into PMS_USR_ROLE (ID,ROLE) "
					+ "select id, :newUserRole from PMS_USR where usr_nam = :username";

			NativeQuery query = session.createSQLQuery(sql);
			query.setParameter("username", username);
			query.setParameter("newUserRole", newUserRole);
			query.executeUpdate();

			transaction.commit();
			session.close();

		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}

	}

	@Override
	public void updateUserRole(Long id, String newUserRole) {
		log.info("updateUserRole in DaoImpl..");

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			String sql = "Insert into PMS_USR_ROLE (ID,ROLE) values " + "(:id, :newUserRole) ";

			NativeQuery query = session.createSQLQuery(sql);
			query.setParameter("id", id);
			query.setParameter("newUserRole", newUserRole);
			query.executeUpdate();

			transaction.commit();
			session.close();

		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public void deleteUser(long id) throws Exception {
		log.info("deleteUser in DaoImpl..");

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			String sql1 = "update PMS_USR set del_ind =:delInd where id = :id ";
			String sql2 = "delete from PMS_USR_ROLE where id = :id ";

			NativeQuery query1 = session.createSQLQuery(sql1);
			query1.setParameter("delInd", ConstantUtil.IND_YES);
			query1.setParameter("id", id);
			query1.executeUpdate();

			NativeQuery query2 = session.createSQLQuery(sql2);
			query2.setParameter("id", id);
			query2.executeUpdate();

			transaction.commit();
			session.close();

		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public List<String> findUserRoles(String username) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT ROLE FROM PMS_USR_ROLE r " + "inner join PMS_USR u " + "on u.id = r.id "
					+ "where USR_NAM = :username and DEL_IND = :delInd";

			SQLQuery sqlQuery = session.createSQLQuery(sql).setParameter("username", username).setParameter("delInd",
					ConstantUtil.IND_NO);

			// sqlQuery.addEntity(User.class);

			List<String> user = sqlQuery.list();

			return user;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public void clearUserRole(Long id) {
		log.info("clearUserRole in DaoImpl..");

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			String sql = "delete from PMS_USR_ROLE where id = :id ";

			NativeQuery query = session.createSQLQuery(sql);
			query.setParameter("id", id);
			query.executeUpdate();

			transaction.commit();
			session.close();

		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}

	}

}

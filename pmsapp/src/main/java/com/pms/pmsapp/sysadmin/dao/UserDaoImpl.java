package com.pms.pmsapp.sysadmin.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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

import com.pms.pmsapp.sysadmin.data.User;
import com.pms.pmsapp.util.HibernateUtil;

@Repository
public class UserDaoImpl implements UserDao {
	
	private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);
	
	private final String IND_NO = "N";
	private final String IND_YES = "Y";

	@Override
	public Optional<User> findUser(String username) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			String sql = "SELECT * FROM PMS_USR where USR_NAM = :username and DEL_IND = :delInd order by id asc";				
					
			SQLQuery sqlQuery = session.createSQLQuery(sql)
					.setParameter("username", username)
					.setParameter("delInd", IND_NO);
	
			sqlQuery.addEntity(User.class);
	
			Optional<User> user = Optional.ofNullable((User) sqlQuery.uniqueResult());
			
			return user;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public List<User> findAllUsers(Pageable pageable) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			String sql = "SELECT * FROM PMS_USR where del_ind = :delInd order by id asc";				
					
			SQLQuery sqlQuery = session.createSQLQuery(sql)
					.setParameter("delInd", IND_NO);
	
			sqlQuery.addEntity(User.class);
			sqlQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
			sqlQuery.setMaxResults(pageable.getPageSize());
	
			List<User> userList =sqlQuery.list();
			
			return userList;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}
	
	@Override
	public boolean checkUserExist(String username) {
		boolean userExist = false;
		
		String sqlQuery = "SELECT count(*) FROM PMS_USR where usr_nam = :username";
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		NativeQuery query = session.createSQLQuery(sqlQuery);
		query.setParameter("username",username);
		
		Integer totalRec = ((BigDecimal) query.uniqueResult()).intValue();
		if (totalRec > 0)
			userExist = true;
		
		return userExist;
	}
	
	@Override
	public void addUser(User userForm) {
		log.info("addUser in DaoImpl..");
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			String sql = "Insert into PMS_USR (ID,USR_NAM,PWD,ROLES,EMAIL,CONTACT_NO,CREATED_BY, CREATED_DT,DEL_IND) values "
					+ "(SQ_PMS_USR.nextval,:username,:password,:roles,:email,:contactNo,:createdBy,sysdate,'N')" ; 
			
			NativeQuery query = session.createSQLQuery(sql);
			query.setParameter("username", userForm.getUsername());
			query.setParameter("password", userForm.getPassword());
			query.setParameter("roles", userForm.getRoles());
			query.setParameter("email", userForm.getEmail());
			query.setParameter("contactNo", userForm.getContactNo());
			query.setParameter("createdBy", userForm.getCreatedBy());
			query.executeUpdate();
			
			transaction.commit();
			session.close();
			
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public void addUserRole(String username, String newUserRole) {
		log.info("addUserRole in DaoImpl..");
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			String sql = "Insert into PMS_USR_ROLE (ID,ROLE) "
					+ "select id, :newUserRole from PMS_USR where usr_nam = :username" ; 
			
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
	public long findAllUserCount() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			String sql = "SELECT count(*) FROM PMS_USR where del_ind = :delInd";
			
			SQLQuery sqlQuery = session.createSQLQuery(sql)
			.setParameter("delInd", IND_NO);
			
			long result = ((BigDecimal) sqlQuery.uniqueResult()).longValue();
	
			session.close();
		
			return result;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public void updateUser(User userForm) {
		log.info("updateUser in DaoImpl..");
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			String sql = "update PMS_USR set email = :email, contact_no = :contactNo, "
					+ "roles = :roles where id = :id "; 
			
			NativeQuery query = session.createSQLQuery(sql);
			query.setParameter("email", userForm.getEmail());
			query.setParameter("contactNo", userForm.getContactNo());
			query.setParameter("roles", userForm.getRoles());
			query.setParameter("id", userForm.getId());
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
			
			String sql = "Insert into PMS_USR_ROLE (ID,ROLE) values "
					+ "(:id, :newUserRole) " ;
			
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
	public void deleteUser(long id) {
		log.info("deleteUser in DaoImpl..");
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			String sql1 = "update PMS_USR set del_ind =:delInd where id = :id " ;
			String sql2 = "delete from PMS_USR_ROLE where id = :id " ;
			
			NativeQuery query1 = session.createSQLQuery(sql1);
			query1.setParameter("delInd", IND_YES);
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
			
			String sql = "SELECT ROLE FROM PMS_USR_ROLE r "
					+ "inner join PMS_USR u "
					+ "on u.id = r.id "
					+ "where USR_NAM = :username and DEL_IND = :delInd";				
					
			SQLQuery sqlQuery = session.createSQLQuery(sql)
					.setParameter("username", username)
					.setParameter("delInd", IND_NO);
	
			//sqlQuery.addEntity(User.class);
	
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
			
			String sql = "delete from PMS_USR_ROLE where id = :id " ; 
			
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

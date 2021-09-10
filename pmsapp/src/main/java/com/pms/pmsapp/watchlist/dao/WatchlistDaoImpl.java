package com.pms.pmsapp.watchlist.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionImpl;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.util.HibernateUtil;
import com.pms.pmsapp.watchlist.data.Watchlist;
import com.pms.pmsapp.watchlist.data.WatchlistEntry;
import com.pms.pmsapp.watchlist.data.WatchlistNotification;

import yahoofinance.YahooFinance;

@Repository
public class WatchlistDaoImpl implements WatchlistDao {
	
	private static final Logger log = LoggerFactory.getLogger(WatchlistDaoImpl.class);
	
	private final String IND_NO = "N";
	private final String IND_YES = "Y";

	@Override
	public List<Watchlist> findAllWatchlist(Pageable pageable) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			String sql = "SELECT * FROM PMS_WATCHLIST order by id asc";				
					
			SQLQuery sqlQuery = session.createSQLQuery(sql);
					
			sqlQuery.addEntity(Watchlist.class);
			sqlQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
			sqlQuery.setMaxResults(pageable.getPageSize());
	
			List<Watchlist> watchlists =sqlQuery.list();
			
			return watchlists;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public long findAllWatchlistCount() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			String sql = "SELECT count(*) FROM PMS_WATCHLIST";
			
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
	public boolean checkWatchlistExist(String watchlistName) {
		boolean watchlistExist = false;
		
		String sqlQuery = "SELECT count(*) FROM PMS_WATCHLIST where name = :watchlistName";
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		NativeQuery query = session.createSQLQuery(sqlQuery);
		query.setParameter("watchlistName",watchlistName);
		
		Integer totalRec = ((BigDecimal) query.uniqueResult()).intValue();
		if (totalRec > 0)
			watchlistExist = true;
		
		return watchlistExist;
	}

	@Override
	public void addWatchlist(Watchlist watchlistForm) {
		log.info("adding watchlist in DaoImpl..");
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			String sql = "insert into PMS_WATCHLIST (ID,NAME,CREATED_BY,CREATED_DT,LAST_MDFY_BY,LAST_MDFY_DT,REMARKS) values "
					+ "(SQ_PMS_WATCHLIST.nextval, :name, :createdBy, sysdate, :lastMdfyBy, sysdate, :remarks)" ; 
			
			NativeQuery query = session.createSQLQuery(sql);
			query.setParameter("name", watchlistForm.getName());
			query.setParameter("createdBy", watchlistForm.getCreatedBy());
			query.setParameter("lastMdfyBy", watchlistForm.getLastMdfyBy());
			query.setParameter("remarks", watchlistForm.getRemarks());
			query.executeUpdate();
			
			transaction.commit();
			session.close();
			
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
		
	}

	@Override
	public void deleteWatchlist(long id) {
		log.info("deleting watchlist in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			String sql1 = "delete from PMS_WATCHLIST where id = :id";
			String sql2 = "delete from PMS_WATCHLIST_ENTRY where watch_id = :id";
			String sql3 = "delete from PMS_WATCHLIST_NOTI where watch_id = :id";
			
			NativeQuery query1 = session.createSQLQuery(sql1);
			query1.setParameter("id",id);
			query1.executeUpdate();
			
			NativeQuery query2 = session.createSQLQuery(sql2);
			query2.setParameter("id",id);
			query2.executeUpdate();
			
			NativeQuery query3 = session.createSQLQuery(sql3);
			query3.setParameter("id",id);
			query3.executeUpdate();
			
			
			transaction.commit();
			session.close();
		
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public List<WatchlistEntry> findAllEntry(Long watchId, Pageable pageable) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			String sql = "SELECT * FROM PMS_WATCHLIST_ENTRY where WATCH_ID = :watchId order by id asc";				
					
			SQLQuery sqlQuery = session.createSQLQuery(sql);
					
			sqlQuery.addEntity(WatchlistEntry.class);
			sqlQuery.setParameter("watchId", watchId);
			sqlQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
			sqlQuery.setMaxResults(pageable.getPageSize());
	
			List<WatchlistEntry> entrys =sqlQuery.list();
			
			return entrys;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public long findAllEntryCount(Long watchId) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			String sql = "SELECT count(*) FROM PMS_WATCHLIST_ENTRY where WATCH_ID = :watchId";
			
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setParameter("watchId", watchId);
			
			long result = ((BigDecimal) sqlQuery.uniqueResult()).longValue();
	
			session.close();
		
			return result;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public boolean checkEntryExist(WatchlistEntry entryForm) {
		boolean entryExist = false;
		
		String sqlQuery = "SELECT count(*) FROM PMS_WATCHLIST_ENTRY where STOCK_SYM = :stockSym and WATCH_ID = :watchId";
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		NativeQuery query = session.createSQLQuery(sqlQuery);
		query.setParameter("stockSym", entryForm.getStockSym());
		query.setParameter("watchId", entryForm.getWatchId());
		
		Integer totalRec = ((BigDecimal) query.uniqueResult()).intValue();
		if (totalRec > 0)
			entryExist = true;
		
		return entryExist;
	}

	@Override
	public void addWatchlistEntry(WatchlistEntry entryForm) {
		log.info("adding watchlist entry in DaoImpl..");
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			String sql = "insert into PMS_WATCHLIST_ENTRY (ID, WATCH_ID, STOCK_NAM, STOCK_SYM, STOCK_EXCHG, LAST_PRICE, CHANGE, CHANGE_PCT, TARGET_PRICE, PREMIUM_DISC, REMARKS, LAST_MDFY_BY,LAST_MDFY_DT) values "
					+ "(:id, :watchId, :stockName, :stockSym, :stockExchg, :lastPrice, :change, :changePct, :targetPrice, :premiumDisc, :remarks, :lastMdfyBy, sysdate)" ; 
			
			NativeQuery query = session.createSQLQuery(sql);
			query.setParameter("id", entryForm.getId());
			query.setParameter("watchId", entryForm.getWatchId());
			query.setParameter("stockName", entryForm.getStockName());
			query.setParameter("stockSym", entryForm.getStockSym());
			query.setParameter("stockExchg", entryForm.getStockExchg());
			query.setParameter("lastPrice", entryForm.getLastPrice());
			query.setParameter("change", entryForm.getChange());
			query.setParameter("changePct", entryForm.getChangePct());
			query.setParameter("targetPrice", entryForm.getTargetPrice());
			query.setParameter("premiumDisc", entryForm.getPremiumDisc());
			query.setParameter("remarks", entryForm.getRemarks());
			query.setParameter("lastMdfyBy", entryForm.getLastMdfyBy());
			query.executeUpdate();
			
			transaction.commit();
			session.close();
			
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
		
	}

	@Override
	public List<WatchlistEntry> searchEntry(long watchId, String searchText, Pageable pageable) {
		log.info("searchEntry in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
	
			String sql = "SELECT * FROM PMS_WATCHLIST_ENTRY where watch_id = :watchId and "
					+ "(UPPER(stock_nam) like :searchText "
					+ "or stock_sym like :searchText) order by ID desc";
			
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.addEntity(WatchlistEntry.class);
			sqlQuery.setParameter("watchId", watchId);
			sqlQuery.setParameter("searchText", searchText);
			sqlQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
			sqlQuery.setMaxResults(pageable.getPageSize());
			
			List<WatchlistEntry> entryList = sqlQuery.list();
	
			session.close();
		
			return entryList;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public long searchEntryCount(long watchId, String searchText) {
		log.info("searchEntryCount in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
	
			String sql = "SELECT count(*) FROM PMS_WATCHLIST_ENTRY where watch_id = :watchId "
					+ "and (UPPER(stock_nam) like :searchText or stock_sym like :searchText)";
			
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setParameter("watchId", watchId);
			sqlQuery.setParameter("searchText", searchText);
			
			long result = ((BigDecimal) sqlQuery.uniqueResult()).longValue();
	
			session.close();
		
			return result;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public void deleteWatchlistEntry(Long entryId, Long watchId) {
		log.info("deleting watchlist entry in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			String sql = "delete from PMS_WATCHLIST_ENTRY where id = :id and watch_id = :watchId";
			
			NativeQuery query = session.createSQLQuery(sql);
			query.setParameter("id",entryId);
			query.setParameter("watchId",watchId);
			query.executeUpdate();
			
			transaction.commit();
			session.close();
		
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public void initNotification(Long id, Long watchId, BigDecimal targetPrice, String username) {
		log.info("initNotification in DaoImpl..");

		CallableStatement callableStatement = null;

		try {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String callStoreProc = "{call PG_WATCHLIST_NOTI.init_notification(?,?,?,?)}";
		callableStatement = ((SessionImpl)session).connection().prepareCall(callStoreProc);
		callableStatement.setLong(1, id);
		callableStatement.setLong(2, watchId);
		callableStatement.setBigDecimal(3, targetPrice);
		callableStatement.setString(4, username);
		callableStatement.executeUpdate();
		((SessionImpl)session).connection().commit();
		
		session.close();

		} catch (Exception e) {
			log.info("exception = " + e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
		
	}

	@Override
	public Long findNextEntrySeq() {
		log.info("findNextEntrySeq in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
	
			String sql = "select SQ_PMS_WATCHLIST_ENTRY.nextval from dual";
			
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
	public WatchlistNotification findNotification(Long id, Long watchId) {
		log.info("findNotification in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
	
			String sql = "SELECT * FROM PMS_WATCHLIST_NOTI where id = :id and "
					+ "watch_id = :watchId";
			
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.addEntity(WatchlistNotification.class);
			sqlQuery.setParameter("id", id);
			sqlQuery.setParameter("watchId", watchId);
			
			WatchlistNotification watchlistNoti = (WatchlistNotification) sqlQuery.uniqueResult();
	
			session.close();
		
			return watchlistNoti;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public void updateNotification(WatchlistNotification watchlistNotification) {
		log.info("updateNotification in DaoImpl..");

		CallableStatement callableStatement = null;

		try {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String callStoreProc = "{call PG_WATCHLIST_NOTI.update_notification(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		callableStatement = ((SessionImpl)session).connection().prepareCall(callStoreProc);
		callableStatement.setLong(1, watchlistNotification.getId());
		callableStatement.setLong(2, watchlistNotification.getWatchId());
		callableStatement.setString(3, watchlistNotification.getTrigger1Ind());
		callableStatement.setBigDecimal(4, watchlistNotification.getTrigger1Price());
		callableStatement.setString(5, watchlistNotification.getTrigger2Ind());
		callableStatement.setBigDecimal(6, watchlistNotification.getTrigger2Price());
		callableStatement.setString(7, watchlistNotification.getTrigger3Ind());
		callableStatement.setBigDecimal(8, watchlistNotification.getTrigger3Price());
		callableStatement.setString(9, watchlistNotification.getUp5PctInd());
		callableStatement.setString(10, watchlistNotification.getDown5PctInd());
		callableStatement.setString(11, watchlistNotification.getUp10PctInd());
		callableStatement.setString(12, watchlistNotification.getDown10PctInd());
		callableStatement.setString(13, watchlistNotification.getCustomUpInd());
		callableStatement.setBigDecimal(14, watchlistNotification.getCustomUpPct());
		callableStatement.setString(15, watchlistNotification.getCustomDownInd());
		callableStatement.setBigDecimal(16, watchlistNotification.getCustomDownPct());
		callableStatement.setString(17, watchlistNotification.getDiscPremType());
		callableStatement.setBigDecimal(18, watchlistNotification.getDiscPremPct());
		callableStatement.setString(19, watchlistNotification.getLastMdfyBy());
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
		log.info("findAllStockSym Watchlist in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			String sql = "select distinct stock_sym from pms_watchlist_entry";				
					
			SQLQuery sqlQuery = session.createSQLQuery(sql);
	
			List<String> stockSymList = sqlQuery.list();
			
			return stockSymList;
		
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
	public void updateWatchlistEntryPrice(String stock, BigDecimal lastPrice, BigDecimal change, BigDecimal changePct) {
		log.info("updateWatchlistEntryPrice in DaoImpl..");

		CallableStatement callableStatement = null;

		try {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String callPkg = "{call PG_WATCHLIST_NOTI.update_watchlist_entry_price(?,?,?,?)}";
		callableStatement = ((SessionImpl)session).connection().prepareCall(callPkg);
		callableStatement.setString(1, stock);
		callableStatement.setBigDecimal(2, lastPrice);
		callableStatement.setBigDecimal(3, change);
		callableStatement.setBigDecimal(4, changePct);
		callableStatement.executeUpdate();
		((SessionImpl)session).connection().commit();
		
		session.close();

		} catch (Exception e) {
			log.info("exception = " + e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
		
	}

	@Override
	public void updateOtherNoti() {
		log.info("updateOtherNoti in DaoImpl..");

		CallableStatement callableStatement = null;

		try {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String callPkg = "{call PG_WATCHLIST_NOTI.update_other_noti()}";
		callableStatement = ((SessionImpl)session).connection().prepareCall(callPkg);
		callableStatement.executeUpdate();
		((SessionImpl)session).connection().commit();
		
		session.close();

		} catch (Exception e) {
			log.info("exception = " + e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
		
	}
	
	@Override
	public void deleteAllOtherNoti() {
		log.info("deleteAllOtherNoti in DaoImpl..");

		CallableStatement callableStatement = null;

		try {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String callPkg = "{call PG_WATCHLIST_NOTI.delete_all_other_noti()}";
		callableStatement = ((SessionImpl)session).connection().prepareCall(callPkg);
		callableStatement.executeUpdate();
		((SessionImpl)session).connection().commit();
		
		session.close();

		} catch (Exception e) {
			log.info("exception = " + e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
		
	}
	
	@Override
	public void updateTriggerNoti() {
		log.info("updateTriggerNoti in DaoImpl..");

		CallableStatement callableStatement = null;

		try {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String callPkg = "{call PG_WATCHLIST_NOTI.update_trigger_noti()}";
		callableStatement = ((SessionImpl)session).connection().prepareCall(callPkg);
		callableStatement.executeUpdate();
		((SessionImpl)session).connection().commit();
		
		session.close();

		} catch (Exception e) {
			log.info("exception = " + e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
		
	}
	
}

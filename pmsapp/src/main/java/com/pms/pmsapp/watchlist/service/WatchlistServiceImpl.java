package com.pms.pmsapp.watchlist.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.portfolio.data.StockWrapper;
import com.pms.pmsapp.watchlist.dao.WatchlistDao;
import com.pms.pmsapp.watchlist.data.Watchlist;
import com.pms.pmsapp.watchlist.data.WatchlistEntry;
import com.pms.pmsapp.watchlist.data.WatchlistNotification;

@Service
public class WatchlistServiceImpl implements WatchlistService {
	
	@Autowired
	private WatchlistDao watchlistDao;

	@Override
	public List<Watchlist> findAllWatchlist(Pageable pageable) {
		return watchlistDao.findAllWatchlist(pageable);
	}

	@Override
	public long findAllWatchlistCount() {
		return watchlistDao.findAllWatchlistCount();
	}

	@Override
	public boolean checkWatchlistExist(String watchlistName) {
		return watchlistDao.checkWatchlistExist(watchlistName);
	}

	@Override
	public void addWatchlist(Watchlist watchlistForm) {
		watchlistDao.addWatchlist(watchlistForm);
	}

	@Override
	public void deleteWatchlist(long id) {
		watchlistDao.deleteWatchlist(id);
	}

	@Override
	public List<WatchlistEntry> findAllEntry(Long watchId, Pageable pageable) {
		return watchlistDao.findAllEntry(watchId, pageable);
	}

	@Override
	public long findAllEntryCount(Long watchId) {
		return watchlistDao.findAllEntryCount(watchId);
	}

	@Override
	public boolean checkEntryExist(WatchlistEntry entryForm) {
		return watchlistDao.checkEntryExist(entryForm);
	}

	@Override
	public void addWatchlistEntry(WatchlistEntry entryForm) {
		watchlistDao.addWatchlistEntry(entryForm);
	}

	@Override
	public List<WatchlistEntry> searchEntry(long watchId, String searchText, Pageable pageable) {
		return watchlistDao.searchEntry(watchId, searchText, pageable);
	}

	@Override
	public long searchEntryCount(long watchId, String searchText) {
		return watchlistDao.searchEntryCount(watchId, searchText);
	}

	@Override
	public void deleteWatchlistEntry(Long entryId, Long watchId) {
		watchlistDao.deleteWatchlistEntry(entryId, watchId);
	}

	@Override
	public void initNotification(Long id, Long watchId, BigDecimal targetPrice, String username) {
		watchlistDao.initNotification(id, watchId, targetPrice, username);
	}

	@Override
	public Long findNextEntrySeq() {
		return watchlistDao.findNextEntrySeq();
	}

	@Override
	public WatchlistNotification findNotification(Long id, Long watchId) {
		return watchlistDao.findNotification(id, watchId);
	}

	@Override
	public void updateNotification(WatchlistNotification watchlistNotification) {
		watchlistDao.updateNotification(watchlistNotification);
	}

	@Override
	public List<String> findAllStockSym() {
		return watchlistDao.findAllStockSym();
	}

	@Override
	public StockWrapper findStock(String stock) {
		return watchlistDao.findStock(stock);
	}

	@Override
	public void updateWatchlistEntryPrice(String stock, BigDecimal lastPrice, BigDecimal change,
			BigDecimal changePct) {
		watchlistDao.updateWatchlistEntryPrice(stock, lastPrice, change, changePct);
	}

	@Override
	public void updateOtherNoti() {
		watchlistDao.updateOtherNoti();
	}
	
	@Override
	public void deleteAllOtherNoti() {
		watchlistDao.deleteAllOtherNoti();
	}

	@Override
	public void updateTriggerNoti() {
		watchlistDao.updateTriggerNoti();
	}
}

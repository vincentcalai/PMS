package com.pms.pmsapp.watchlist.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.watchlist.data.Watchlist;
import com.pms.pmsapp.watchlist.data.WatchlistEntry;
import com.pms.pmsapp.watchlist.data.WatchlistNotification;



public interface WatchlistDao {

	List<Watchlist> findAllWatchlist(Pageable pageable);

	long findAllWatchlistCount();

	boolean checkWatchlistExist(String watchlistName);

	void addWatchlist(Watchlist watchlistForm);

	void deleteWatchlist(long id);

	List<WatchlistEntry> findAllEntry(Long watchId, Pageable pageable);

	long findAllEntryCount(Long watchId);

	boolean checkEntryExist(WatchlistEntry entryForm);

	void addWatchlistEntry(WatchlistEntry entryForm);

	List<WatchlistEntry> searchEntry(long watchId, String searchText, Pageable pageable);

	long searchEntryCount(long watchId, String searchText);

	void deleteWatchlistEntry(Long entryId, Long watchId);

	void initNotification(Long id, Long watchId, BigDecimal targetPrice, String username);

	Long findNextEntrySeq();

	WatchlistNotification findNotification(Long id, Long watchId);

	void updateNotification(WatchlistNotification watchlistNotification);

	List<String> findAllStockSym();

	StockWrapper findStock(String stockSym);

	void updateWatchlistEntryPrice(String stock, BigDecimal lastPrice, BigDecimal change, BigDecimal changePct);

	void updateOtherNoti();

	void deleteAllOtherNoti();

	void updateTriggerNoti();
}

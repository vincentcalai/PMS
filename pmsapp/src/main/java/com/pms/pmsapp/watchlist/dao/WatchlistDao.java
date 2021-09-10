package com.pms.pmsapp.watchlist.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.watchlist.data.Watchlist;
import com.pms.pmsapp.watchlist.data.WatchlistEntry;
import com.pms.pmsapp.watchlist.data.WatchlistNotification;



public interface WatchlistDao {

	public List<Watchlist> findAllWatchlist(Pageable pageable);

	public long findAllWatchlistCount();

	public boolean checkWatchlistExist(String watchlistName);

	public void addWatchlist(Watchlist watchlistForm);

	public void deleteWatchlist(long id);

	public List<WatchlistEntry> findAllEntry(Long watchId, Pageable pageable);

	public long findAllEntryCount(Long watchId);

	public boolean checkEntryExist(WatchlistEntry entryForm);

	public void addWatchlistEntry(WatchlistEntry entryForm);

	public List<WatchlistEntry> searchEntry(long watchId, String searchText, Pageable pageable);

	public long searchEntryCount(long watchId, String searchText);

	public void deleteWatchlistEntry(Long entryId, Long watchId);

	public void initNotification(Long id, Long watchId, BigDecimal targetPrice, String username);

	public Long findNextEntrySeq();

	public WatchlistNotification findNotification(Long id, Long watchId);

	public void updateNotification(WatchlistNotification watchlistNotification);

	public List<String> findAllStockSym();

	public StockWrapper findStock(String stockSym);

	public void updateWatchlistEntryPrice(String stock, BigDecimal lastPrice, BigDecimal change, BigDecimal changePct);

	public void updateOtherNoti();

	public void deleteAllOtherNoti();

	public void updateTriggerNoti();
}

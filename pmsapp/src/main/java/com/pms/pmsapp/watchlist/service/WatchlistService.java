package com.pms.pmsapp.watchlist.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.watchlist.data.Watchlist;
import com.pms.pmsapp.watchlist.data.WatchlistEntry;
import com.pms.pmsapp.watchlist.data.WatchlistNotification;
import com.pms.pmsapp.watchlist.web.NotificationForm;
import com.pms.pmsapp.watchlist.web.WatchlistEntryForm;
import com.pms.pmsapp.watchlist.web.WatchlistForm;

public interface WatchlistService {

	List<Watchlist> findAllWatchlist(Pageable pageable);

	long findAllWatchlistCount();

	boolean checkWatchlistExist(String watchlistName);

	void addWatchlist(Watchlist watchlistForm);

	WatchlistForm deleteWatchlist(long id, WatchlistForm watchlist);

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

	void updateWatchlistEntryPrice(String stock, BigDecimal lastPrice, BigDecimal change, BigDecimal changePct);

	void updateOtherNoti();

	void deleteAllOtherNoti();

	void updateTriggerNoti();

	WatchlistForm addWatchlist(WatchlistForm watchlistForm, String username);

	WatchlistEntryForm addWatchlistEntry(WatchlistEntryForm entryForm, String username);

	WatchlistEntryForm retrieveStockInfo(WatchlistEntryForm watchlistEntry);

	WatchlistForm deleteWatchlistEntry(NotificationForm form);

	NotificationForm initPage(NotificationForm form);

	NotificationForm updateNotification(NotificationForm form, String username);

}

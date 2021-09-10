package com.pms.pmsapp.watchlist.web;

import com.pms.pmsapp.watchlist.data.Watchlist;
import com.pms.pmsapp.watchlist.data.WatchlistEntry;
import com.pms.pmsapp.watchlist.data.WatchlistNotification;

public class NotificationForm {
	
	private Watchlist watchlist;
	private WatchlistEntry entry;
	private WatchlistNotification watchlistNotification;
	
	private String errMsg;
	private String sysMsg;
	
	public NotificationForm() {
	}

	public Watchlist getWatchlist() {
		return watchlist;
	}

	public void setWatchlist(Watchlist watchlist) {
		this.watchlist = watchlist;
	}

	public WatchlistEntry getEntry() {
		return entry;
	}

	public void setEntry(WatchlistEntry entry) {
		this.entry = entry;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getSysMsg() {
		return sysMsg;
	}

	public void setSysMsg(String sysMsg) {
		this.sysMsg = sysMsg;
	}

	public WatchlistNotification getWatchlistNotification() {
		return watchlistNotification;
	}

	public void setWatchlistNotification(WatchlistNotification watchlistNotification) {
		this.watchlistNotification = watchlistNotification;
	}

	
	
	

	
}
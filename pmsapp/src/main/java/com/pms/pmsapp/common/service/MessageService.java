package com.pms.pmsapp.common.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.common.data.Message;
import com.pms.pmsapp.portfolio.data.StockWrapper;
import com.pms.pmsapp.watchlist.data.Watchlist;
import com.pms.pmsapp.watchlist.data.WatchlistEntry;
import com.pms.pmsapp.watchlist.data.WatchlistNotification;

public interface MessageService {

	public void genWatchlistNotiMsg();
	
	public List<Message> retrieveMsg(String loginUser);
	
	public int retrieveMsgCnt(String loginUser);

	public void softDelReadMsg(String loginUser);
	
	public void deleteAllMsg(String loginUser);
}

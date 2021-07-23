package com.pms.pmsapp.common.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import com.pms.pmsapp.common.data.Message;
import com.pms.pmsapp.portfolio.data.StockWrapper;
import com.pms.pmsapp.sysadmin.data.User;
import com.pms.pmsapp.watchlist.data.Watchlist;
import com.pms.pmsapp.watchlist.data.WatchlistEntry;
import com.pms.pmsapp.watchlist.data.WatchlistNotification;



public interface MessageDao {

	public void genWatchlistNotiMsg();

	public List<Message> retrieveMsg(String loginUser);
	
	public int retrieveMsgCnt(String loginUser);

	public void softDelReadMsg(String loginUser);
	
	public void deleteAllMsg(String loginUser);

}
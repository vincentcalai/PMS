package com.pms.pmsapp.watchlist.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioHoldService;
import com.pms.pmsapp.util.constant.ConstantUtil;
import com.pms.pmsapp.watchlist.dao.WatchlistDao;
import com.pms.pmsapp.watchlist.data.Watchlist;
import com.pms.pmsapp.watchlist.data.WatchlistEntry;
import com.pms.pmsapp.watchlist.data.WatchlistNotification;
import com.pms.pmsapp.watchlist.web.NotificationForm;
import com.pms.pmsapp.watchlist.web.WatchlistEntryForm;
import com.pms.pmsapp.watchlist.web.WatchlistForm;

@Service
public class WatchlistServiceImpl implements WatchlistService {

	private static final Logger log = LoggerFactory.getLogger(WatchlistServiceImpl.class);

	@Autowired
	private WatchlistDao watchlistDao;

	@Autowired
	private PortfolioHoldService portfolioHoldService;

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
	public WatchlistForm deleteWatchlist(long id, WatchlistForm watchlistForm) {
		watchlistDao.deleteWatchlist(id);
		watchlistForm.setSystemMsg("Watchlist deleted successfully.");
		return watchlistForm;
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
	public void updateWatchlistEntryPrice(String stock, BigDecimal lastPrice, BigDecimal change, BigDecimal changePct) {
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

	@Override
	public WatchlistForm addWatchlist(WatchlistForm watchlistForm, String username) {
		boolean nameExist = false;
		String watchlistName = watchlistForm.getName();

		if (username != null) {
			watchlistForm.setCreatedBy(username);
			watchlistForm.setLastMdfyBy(username);
		}

		nameExist = checkWatchlistExist(watchlistName);
		if (nameExist) {
			watchlistForm.setErrMsg("Watchlist name already exist. Please create watchlist with different name.");
		} else {

			Watchlist watchlist = new Watchlist(watchlistForm.getId(), watchlistForm.getName(),
					watchlistForm.getRemarks(), watchlistForm.getCreatedBy(), watchlistForm.getCreatedDt(),
					watchlistForm.getLastMdfyBy(), watchlistForm.getLastMdfyDt());

			addWatchlist(watchlist);
			watchlistForm.setSystemMsg("Watchlist added Successfully.");
		}
		return watchlistForm;
	}

	@Override
	public WatchlistEntryForm addWatchlistEntry(WatchlistEntryForm entryForm, String username) {
		Long watchId = entryForm.getWatchId();
		BigDecimal targetPrice = entryForm.getTargetPrice();

		boolean nameExist = false;

		if (username != null) {
			entryForm.setLastMdfyBy(username);
		}

		StockWrapper stockWrapper = portfolioHoldService.findStock(entryForm.getStockSym());

		WatchlistEntry watchlistEntry = new WatchlistEntry(entryForm.getId(), entryForm.getWatchId(),
				entryForm.getStockName(), entryForm.getStockSym(), entryForm.getStockExchg(), entryForm.getLastPrice(),
				entryForm.getChange(), entryForm.getChangePct(), entryForm.getTargetPrice(), entryForm.getPremiumDisc(),
				entryForm.getRemarks(), entryForm.getLastMdfyBy(), entryForm.getLastMdfyDt());

		nameExist = checkEntryExist(watchlistEntry);

		if (nameExist) {
			entryForm.setErrMsg("Stock entry already exist in this watchlist.");
		} else if ((stockWrapper == null || stockWrapper.getStock().getQuote().getPrice() == null)) {
			entryForm.setErrMsg("Stock Symbol is invalid, Save transaction failed. Please enter a valid Stock Symbol.");
		} else {

			try {
				// BigDecimal targetPrice = entryForm.getTargetPrice();
				BigDecimal lastPrice = stockWrapper.getStock().getQuote(true).getPrice();
				BigDecimal change = stockWrapper.getStock().getQuote(true).getChange();
				BigDecimal changePct = stockWrapper.getStock().getQuote(true).getChangeInPercent();
				log.info("Stock: " + watchlistEntry.getStockSym() + " Last Price: " + lastPrice);
				// watchlistService.update(entryForm.getStockSym(), lastPrice);
				BigDecimal premiumDisc = ((lastPrice.subtract(targetPrice)).divide(lastPrice, 10,
						RoundingMode.HALF_DOWN)).multiply(new BigDecimal(100));
				watchlistEntry.setPremiumDisc(premiumDisc);
				watchlistEntry.setLastPrice(lastPrice);
				watchlistEntry.setChange(change);
				watchlistEntry.setChangePct(changePct);
			} catch (Exception e) {
				entryForm.setErrMsg(
						"An unexpected error occurred while updating real time price. Update of real time price failed.");
				log.error(e.getMessage());
				return entryForm;
			}

			Long id = findNextEntrySeq();
			watchlistEntry.setId(id);

			addWatchlistEntry(watchlistEntry);

			// add stock entry notifications

			initNotification(id, watchId, targetPrice, username);

			entryForm.setSystemMsg("Stock entry added to watchlist successfully.");

			entryForm.setPremiumDisc(watchlistEntry.getPremiumDisc());
			entryForm.setLastPrice(watchlistEntry.getLastPrice());
			entryForm.setChange(watchlistEntry.getChange());
			entryForm.setChangePct(watchlistEntry.getChangePct());

		}

		return entryForm;
	}

	@Override
	public WatchlistEntryForm retrieveStockInfo(WatchlistEntryForm watchlistEntryForm) {

		String stockSym = watchlistEntryForm.getStockSym();
		StockWrapper stockWrapper = portfolioHoldService.findStock(stockSym);
		try {
			String stockExchg = stockWrapper.getStock().getStockExchange();
			String stockName = stockWrapper.getStock().getName();
			BigDecimal lastPrice = stockWrapper.getStock().getQuote(true).getPrice();
			watchlistEntryForm.setStockExchg(ConstantUtil.exchgSuffmap.get(stockExchg));
			log.info("Stock: " + stockName + " Last Price: " + lastPrice);
			watchlistEntryForm.setStockName(stockName);
			watchlistEntryForm.setLastPrice(lastPrice);
		} catch (Exception e) {
			watchlistEntryForm.setErrMsg("Stock symbol not found. Fail to get stock info.");
			log.error(e.getMessage());
		}

		return watchlistEntryForm;
	}

	@Override
	public WatchlistForm deleteWatchlistEntry(NotificationForm form) {

		Watchlist watchlist = form.getWatchlist();

		Long entryId = form.getEntry().getId();
		Long watchId = form.getWatchlist().getId();

		deleteWatchlistEntry(entryId, watchId);

		WatchlistForm watchlistForm = new WatchlistForm(watchlist.getId(), watchlist.getName(), watchlist.getRemarks(),
				watchlist.getCreatedBy(), watchlist.getCreatedDt(), watchlist.getLastMdfyBy(),
				watchlist.getLastMdfyDt(), null, null);
		watchlistForm.setSystemMsg("Stock entry deleted in watchlist successfully.");

		return watchlistForm;
	}

	@Override
	public NotificationForm initPage(NotificationForm form) {
		WatchlistNotification watchlistNoti = findNotification(form.getEntry().getId(), form.getWatchlist().getId());
		form.setWatchlistNotification(watchlistNoti);
		return form;
	}

	@Override
	public NotificationForm updateNotification(NotificationForm form, String username) {

		if (username != null) {
			form.getWatchlistNotification().setLastMdfyBy(username);
		}

		updateNotification(form.getWatchlistNotification());

		form.setSysMsg("Notification Setting updated successfully.");

		return form;
	}

}

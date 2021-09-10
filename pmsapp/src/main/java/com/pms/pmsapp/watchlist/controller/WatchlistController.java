package com.pms.pmsapp.watchlist.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioHoldService;
import com.pms.pmsapp.watchlist.data.Watchlist;
import com.pms.pmsapp.watchlist.data.WatchlistEntry;
import com.pms.pmsapp.watchlist.data.WatchlistNotification;
import com.pms.pmsapp.watchlist.service.WatchlistService;
import com.pms.pmsapp.watchlist.web.NotificationForm;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class WatchlistController {
	
	private final String EXCHG_HKEX = "HKSE";
	private final String EXCHG_SGX = "SES";
	private final String EXCHG_NYSE = "NYSE";
	private final String EXCHG_NASDAQ = "NasdaqGS";
	
	private final String RENAM_EXCHG_HKEX = "HKEX";
	private final String RENAM_EXCHG_SGX = "SGX";
	private final String RENAM_EXCHG_NYSE = "NYSE";
	private final String RENAM_EXCHG_NASDAQ = "NASDAQ";
	
	private final String YES = "Y";
	private final String NO = "N";
	
	private static final Logger log = LoggerFactory.getLogger(WatchlistController.class);
	
	@Autowired
	private WatchlistService watchlistService;
	
	@Autowired
	private PortfolioHoldService portfolioHoldService;
	
	@RequestMapping(value="/watchlist", method=RequestMethod.GET)
	public Page<Watchlist> findAllWatchlist(@RequestParam("page") int page, @RequestParam("size") int size) {
		log.info("findAllWatchlist in Controller");
		Pageable pageable = PageRequest.of(page-1, size);
		
		List<Watchlist> watchlists= watchlistService.findAllWatchlist(pageable);
		long totalRec = watchlistService.findAllWatchlistCount();
		
		PageImpl<Watchlist> watchlistPage = new PageImpl((List<Watchlist>) watchlists, pageable, totalRec);
		return watchlistPage;
	}
	
	@RequestMapping(value="/watchlist/entry", method=RequestMethod.POST)
	public Page<Watchlist> findAllEntry(@RequestParam("page") int page, @RequestParam("size") int size, 
			@RequestBody Watchlist watchlist) {
		log.info("findAllEntry in Controller");
		Pageable pageable = PageRequest.of(page-1, size);
		
		List<WatchlistEntry> entry= watchlistService.findAllEntry(watchlist.getId(), pageable);
		long totalRec = watchlistService.findAllEntryCount(watchlist.getId());
		
		PageImpl<Watchlist> watchlistPage = new PageImpl((List<WatchlistEntry>) entry, pageable, totalRec);
		return watchlistPage;
	}
	
	@RequestMapping(value="/watchlist/add", method=RequestMethod.POST)
	public Watchlist addWatchlist(@RequestBody Watchlist watchlistForm, Authentication authentication) {
		 
		boolean nameExist = false;
		 String watchlistName = watchlistForm.getName();
		 
		 String username = authentication.getName();
		 
		 if(username != null) {
			 watchlistForm.setCreatedBy(username);
			 watchlistForm.setLastMdfyBy(username);
		 }
		 
		 log.info("addWatchlist in Controller.. ");
		 log.info("watchlistName:  " + watchlistName);
		 
		 nameExist = watchlistService.checkWatchlistExist(watchlistName);
		 if(nameExist) {
			 watchlistForm.setErrMsg("Watchlist name already exist. Please create watchlist with different name.");
		 } else {
			 watchlistService.addWatchlist(watchlistForm);
			 watchlistForm.setSystemMsg("Watchlist added Successfully.");
		 }
		 return watchlistForm;
	}
	
	@RequestMapping(value="/watchlist/entry/add", method=RequestMethod.POST)
	public WatchlistEntry addWatchlistEntry(@RequestBody WatchlistEntry entryForm, Authentication authentication) {
		 log.info("addWatchlistEntry in Controller.. ");
		 Long watchId = entryForm.getWatchId();
		 BigDecimal targetPrice = entryForm.getTargetPrice();
		 
		 boolean nameExist = false;
		 
		 String username = authentication.getName();
		 
		 if(username != null) {
			 entryForm.setLastMdfyBy(username);
		 }
		 
		 StockWrapper stockWrapper = portfolioHoldService.findStock(entryForm.getStockSym());
		 
		 nameExist = watchlistService.checkEntryExist(entryForm);
		 if(nameExist) {
			 entryForm.setErrMsg("Stock entry already exist in this watchlist.");
		 } else if ((stockWrapper == null || stockWrapper.getStock().getQuote().getPrice() == null)) {
			 entryForm.setErrMsg("Stock Symbol is invalid, Save transaction failed. Please enter a valid Stock Symbol.");
		 } else {
			 
			 try {
				 	//BigDecimal targetPrice = entryForm.getTargetPrice();
					BigDecimal lastPrice = stockWrapper.getStock().getQuote(true).getPrice();
					BigDecimal change = stockWrapper.getStock().getQuote(true).getChange();
					BigDecimal changePct = stockWrapper.getStock().getQuote(true).getChangeInPercent();
					log.info("Stock: " + entryForm.getStockSym() + " Last Price: " + lastPrice);
					//watchlistService.update(entryForm.getStockSym(), lastPrice);
					BigDecimal premiumDisc = ((lastPrice.subtract(targetPrice)).divide(lastPrice, 10, RoundingMode.HALF_DOWN)).multiply(new BigDecimal(100));
					entryForm.setPremiumDisc(premiumDisc);
					entryForm.setLastPrice(lastPrice);
					entryForm.setChange(change);
					entryForm.setChangePct(changePct);
			 } catch (Exception e) {
				 	entryForm.setErrMsg("An unexpected error occurred while updating real time price. Update of real time price failed."); 
					log.error(e.getMessage());
			 }
			 
			 Long id = watchlistService.findNextEntrySeq();
			 entryForm.setId(id);
			 
			 watchlistService.addWatchlistEntry(entryForm);
			 
			 //add stock entry notifications
			 
			 watchlistService.initNotification(id, watchId, targetPrice, username);
			 
			 entryForm.setSystemMsg("Stock entry added to watchlist successfully.");
		 }
		 return entryForm;
	}

	@RequestMapping(value="/watchlist/deletewatchlist/{id}", method=RequestMethod.DELETE)
	public Watchlist deleteWatchlist(@PathVariable long id) {
		Watchlist watchlist = new Watchlist();
		log.info("deleteWatchlist in Controller");
		watchlistService.deleteWatchlist(id);
		
		watchlist.setSystemMsg("Watchlist deleted successfully.");
		
		return watchlist;
	}
	
	@RequestMapping(value="/watchlist/entry/retrieveStockInfo", method=RequestMethod.POST)
	public WatchlistEntry retrieveStockInfo(@RequestBody WatchlistEntry watchlistEntry) {
		log.info("retrieveStockInfo in Controller");
		
		Map<String, String> exchgSuffmap = new HashMap<String, String>();
		exchgSuffmap.put(EXCHG_HKEX, RENAM_EXCHG_HKEX);
		exchgSuffmap.put(EXCHG_SGX, RENAM_EXCHG_SGX);
		exchgSuffmap.put(EXCHG_NYSE, RENAM_EXCHG_NYSE);
		exchgSuffmap.put(EXCHG_NASDAQ, RENAM_EXCHG_NASDAQ);
		
		String stockSym = watchlistEntry.getStockSym();
		StockWrapper stockWrapper = portfolioHoldService.findStock(stockSym);
		try {
			String stockExchg = stockWrapper.getStock().getStockExchange();
			String stockName = stockWrapper.getStock().getName();
			BigDecimal lastPrice = stockWrapper.getStock().getQuote(true).getPrice();
			watchlistEntry.setStockExchg(exchgSuffmap.get(stockExchg));
			log.info("Stock: " + stockName + " Last Price: " + lastPrice);
			watchlistEntry.setStockName(stockName);
			watchlistEntry.setLastPrice(lastPrice);
		} catch (Exception e) {
			watchlistEntry.setErrMsg("Stock symbol not found. Fail to get stock info.");
			log.error(e.getMessage());
		}
		return watchlistEntry;
	}
	
	@RequestMapping(value="/watchlist/entry/search/{watchId}", method=RequestMethod.POST)
	public Page<WatchlistEntry> searchEntry(@RequestParam("page") int page, @RequestParam("size") int size, 
			@PathVariable long watchId, @RequestBody(required = false) String searchText) {
		log.info("searchText Watchlist Entry in Controller");
		log.info("searchText: " + searchText);
		
		Pageable pageable = PageRequest.of(page-1, size);
		
		if (searchText == null || "".equals(searchText)) {
			searchText = "%";
		}else{
			searchText = searchText + "%";
		}
		
		List<WatchlistEntry> entryList= watchlistService.searchEntry(watchId, searchText, pageable);
		long totalRec = watchlistService.searchEntryCount(watchId, searchText);
		
		PageImpl<WatchlistEntry> transPage = new PageImpl((List<WatchlistEntry>) entryList, pageable, totalRec);
		return transPage;
	}
	
	@RequestMapping(value="/watchlist/entry/delete", method=RequestMethod.POST)
	public Watchlist deleteEntry(@RequestBody NotificationForm form ) {
		Watchlist watchlist = form.getWatchlist();
		
		Long entryId = form.getEntry().getId();
		Long watchId = form.getWatchlist().getId();
		
		log.info("deleteWatchlistEntry in Controller");
		
		watchlistService.deleteWatchlistEntry(entryId, watchId);
		
		watchlist.setSystemMsg("Stock entry deleted in watchlist successfully.");
		
		return watchlist;
	}
	
	@RequestMapping(value="/watchlist/noti/init", method=RequestMethod.POST)
	public NotificationForm initNotification(@RequestBody NotificationForm form ) {
		WatchlistNotification watchlistNoti = watchlistService.findNotification(form.getEntry().getId(), form.getWatchlist().getId());
		form.setWatchlistNotification(watchlistNoti);
		return form;
	}
	
	@RequestMapping(value="/watchlist/noti/update", method=RequestMethod.POST)
	public NotificationForm updateNotification(@RequestBody NotificationForm form, Authentication authentication) {
		 log.info("updateNotification in Controller.. ");
		 
		 String username = authentication.getName();
		 
		 if(username != null) {
			 form.getWatchlistNotification().setLastMdfyBy(username);
		 }
		 
		 watchlistService.updateNotification(form.getWatchlistNotification());
			 
		 form.setSysMsg("Notification Setting updated successfully.");
		 
		 return form;
	}
	
}

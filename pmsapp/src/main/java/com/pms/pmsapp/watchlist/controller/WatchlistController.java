package com.pms.pmsapp.watchlist.controller;

import java.util.List;

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

import com.pms.pmsapp.watchlist.data.Watchlist;
import com.pms.pmsapp.watchlist.data.WatchlistEntry;
import com.pms.pmsapp.watchlist.service.WatchlistService;
import com.pms.pmsapp.watchlist.web.NotificationForm;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class WatchlistController {

	private static final Logger log = LoggerFactory.getLogger(WatchlistController.class);

	@Autowired
	private WatchlistService watchlistService;

	@RequestMapping(value = "/watchlist", method = RequestMethod.GET)
	public Page<Watchlist> findAllWatchlist(@RequestParam("page") int page, @RequestParam("size") int size) {
		log.info("findAllWatchlist in Controller");
		Pageable pageable = PageRequest.of(page - 1, size);

		List<Watchlist> watchlists = watchlistService.findAllWatchlist(pageable);
		long totalRec = watchlistService.findAllWatchlistCount();

		PageImpl<Watchlist> watchlistPage = new PageImpl(watchlists, pageable, totalRec);
		return watchlistPage;
	}

	@RequestMapping(value = "/watchlist/entry", method = RequestMethod.POST)
	public Page<Watchlist> findAllEntry(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestBody Watchlist watchlist) {
		log.info("findAllEntry in Controller");
		Pageable pageable = PageRequest.of(page - 1, size);

		List<WatchlistEntry> entry = watchlistService.findAllEntry(watchlist.getId(), pageable);
		long totalRec = watchlistService.findAllEntryCount(watchlist.getId());

		PageImpl<Watchlist> watchlistPage = new PageImpl(entry, pageable, totalRec);
		return watchlistPage;
	}

	@RequestMapping(value = "/watchlist/add", method = RequestMethod.POST)
	public Watchlist addWatchlist(@RequestBody Watchlist watchlistForm, Authentication authentication) {

		String username = authentication.getName();

		return watchlistService.addWatchlist(watchlistForm, username);
	}

	@RequestMapping(value = "/watchlist/entry/add", method = RequestMethod.POST)
	public WatchlistEntry addWatchlistEntry(@RequestBody WatchlistEntry entryForm, Authentication authentication) {
		log.info("addWatchlistEntry in Controller.. ");

		String username = authentication.getName();

		return watchlistService.addWatchlistEntry(entryForm, username);
	}

	@RequestMapping(value = "/watchlist/deletewatchlist/{id}", method = RequestMethod.DELETE)
	public Watchlist deleteWatchlist(@PathVariable long id) {
		Watchlist watchlist = new Watchlist();
		log.info("deleteWatchlist in Controller");

		return watchlistService.deleteWatchlist(id, watchlist);
	}

	@RequestMapping(value = "/watchlist/entry/retrieveStockInfo", method = RequestMethod.POST)
	public WatchlistEntry retrieveStockInfo(@RequestBody WatchlistEntry watchlistEntry) {
		log.info("retrieveStockInfo in Controller");

		return watchlistService.retrieveStockInfo(watchlistEntry);
	}

	@RequestMapping(value = "/watchlist/entry/search/{watchId}", method = RequestMethod.POST)
	public Page<WatchlistEntry> searchEntry(@RequestParam("page") int page, @RequestParam("size") int size,
			@PathVariable long watchId, @RequestBody(required = false) String searchText) {
		log.info("searchText Watchlist Entry in Controller");
		log.info("searchText: " + searchText);

		Pageable pageable = PageRequest.of(page - 1, size);

		if (searchText == null || "".equals(searchText)) {
			searchText = "%";
		} else {
			searchText = searchText + "%";
		}

		List<WatchlistEntry> entryList = watchlistService.searchEntry(watchId, searchText, pageable);
		long totalRec = watchlistService.searchEntryCount(watchId, searchText);

		PageImpl<WatchlistEntry> transPage = new PageImpl(entryList, pageable, totalRec);
		return transPage;
	}

	@RequestMapping(value = "/watchlist/entry/delete", method = RequestMethod.POST)
	public Watchlist deleteEntry(@RequestBody NotificationForm form) {

		log.info("deleteWatchlistEntry in Controller");

		return watchlistService.deleteWatchlistEntry(form);
	}

	@RequestMapping(value = "/watchlist/noti/init", method = RequestMethod.POST)
	public NotificationForm initNotification(@RequestBody NotificationForm form) {
		return watchlistService.initPage(form);
	}

	@RequestMapping(value = "/watchlist/noti/update", method = RequestMethod.POST)
	public NotificationForm updateNotification(@RequestBody NotificationForm form, Authentication authentication) {
		log.info("updateNotification in Controller.. ");

		String username = authentication.getName();

		return watchlistService.updateNotification(form, username);
	}

}

package com.pms.pmsapp.watchlist.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.pms.pmsapp.watchlist.data.Watchlist;
import com.pms.pmsapp.watchlist.repository.WatchlistRepository;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class TestWatchlistRepository {

	@Autowired
	private WatchlistRepository watchlistRepository;

	@BeforeAll
	private void setup() {
		Watchlist watchlist1 = new Watchlist(1L, "Watchlist 1", "test watchlist remarks 1", "user1", new Date(),
				"user1", new Date());
		Watchlist watchlist2 = new Watchlist(2L, "Watchlist 2", "test watchlist remarks 2", "user2", new Date(),
				"user2", new Date());
		Watchlist watchlist3 = new Watchlist(3L, "Watchlist 3", "test watchlist remarks 3", "user3", new Date(),
				"user3", new Date());
		List<Watchlist> list = Arrays.asList(watchlist1, watchlist2, watchlist3);
		watchlistRepository.saveAll(list);
	}

	@AfterAll
	private void tearDown() {
		watchlistRepository.deleteAll();
	}

	@Test
	@Order(1)
	void testFindAllWatchlistPageable() {
		int page = 1;
		int size = 10;
		Pageable pageable = PageRequest.of(page - 1, size, Sort.by("id").ascending());

		Page<Watchlist> pageWatchlist = watchlistRepository.findAll(pageable);
		List<Watchlist> list = pageWatchlist.getContent();
		assertEquals("Watchlist 1", list.get(0).getName());
		assertEquals("Watchlist 2", list.get(1).getName());
		assertEquals("Watchlist 3", list.get(2).getName());
	}

	@Test
	@Order(2)
	void testFindWatchlistCount() {
		long count = watchlistRepository.count();
		assertEquals(3L, count);
	}

	@Test
	@Order(3)
	void testFindWatchlistCountByName() {
		String watchlistName = "Watchlist 3";
		long count = watchlistRepository.countByName(watchlistName);
		assertEquals(1L, count);
	}

	@Test
	@Order(4)
	void testSaveWatchlist() {
		Watchlist watchlist4 = new Watchlist(4L, "Watchlist 4", "Save Test Remarks", "user4", new Date(), "user3",
				new Date());
		watchlistRepository.save(watchlist4);
		List<Watchlist> watchlists = watchlistRepository.findAll();
		assertEquals(4, watchlists.size());
	}

	@Test
	@Order(5)
	void testSaveWatchlist() {
		Watchlist watchlist4 = new Watchlist(4L, "Watchlist 4", "Save Test Remarks", "user4", new Date(), "user3",
				new Date());
		watchlistRepository.save(watchlist4);
		List<Watchlist> watchlists = watchlistRepository.findAll();
		assertEquals(4, watchlists.size());
	}

}

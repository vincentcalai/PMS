package com.pms.pmsapp.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.pmsapp.watchlist.data.Watchlist;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {

	long countByName(String watchlistName);
}

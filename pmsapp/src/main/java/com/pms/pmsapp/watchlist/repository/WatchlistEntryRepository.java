package com.pms.pmsapp.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.pmsapp.watchlist.data.WatchlistEntry;

public interface WatchlistEntryRepository extends JpaRepository<WatchlistEntry, Long> {

}

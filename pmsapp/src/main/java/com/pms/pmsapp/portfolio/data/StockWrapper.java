package com.pms.pmsapp.portfolio.data;

import java.time.LocalDateTime;

import yahoofinance.Stock;

public class StockWrapper {
	private final Stock stock;
	private final LocalDateTime lastAccessed;
	
	public StockWrapper(Stock stock) {
		this.stock = stock;
		this.lastAccessed = LocalDateTime.now();
	}
	
	public StockWrapper(Stock stock, LocalDateTime lastAccessed) {
		this.stock = stock;
		this.lastAccessed = lastAccessed;
	}
	
	public Stock getStock() {
		return stock;
	}
	
	public LocalDateTime getLastAccessed() {
		return lastAccessed;
	}
}

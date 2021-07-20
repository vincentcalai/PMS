package com.pms.pmsapp.common.web;

import java.util.ArrayList;
import java.util.List;

import com.pms.pmsapp.common.data.Forex;
import com.pms.pmsapp.common.data.Index;


public class HomeForm {
	
	private List<Index> indexList = new ArrayList<Index>();
	private List<Forex> forexList = new ArrayList<Forex>();
	
	public HomeForm() {
		
	}

	public List<Index> getIndexList() {
		return indexList;
	}

	public void setIndexList(List<Index> indexList) {
		this.indexList = indexList;
	}

	public List<Forex> getForexList() {
		return forexList;
	}

	public void setForexList(List<Forex> forexList) {
		this.forexList = forexList;
	}

}

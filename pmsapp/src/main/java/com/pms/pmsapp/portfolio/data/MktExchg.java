package com.pms.pmsapp.portfolio.data;

import javax.persistence.Entity;

@Entity
public class MktExchg {
	private String mktExchgName;
	private String mktExchgDesc;
	private String curr;
	
	public MktExchg() {
	}
	
	public MktExchg(String mktExchgName, String mktExchgDesc, String curr) {
		super();
		this.mktExchgName = mktExchgName;
		this.mktExchgDesc = mktExchgDesc;
		this.curr = curr;
	}

	public String getMktExchgName() {
		return mktExchgName;
	}

	public void setMktExchgName(String mktExchgName) {
		this.mktExchgName = mktExchgName;
	}

	public String getMktExchgDesc() {
		return mktExchgDesc;
	}

	public void setMktExchgDesc(String mktExchgDesc) {
		this.mktExchgDesc = mktExchgDesc;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	
	
}

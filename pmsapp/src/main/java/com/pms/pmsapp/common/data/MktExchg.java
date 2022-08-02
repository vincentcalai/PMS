package com.pms.pmsapp.common.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PMS_MKT_EXCHG")
public class MktExchg {
	private String mktExchgName;
	private String mktExchgDesc;
	private String curr;
	private String suffix;
	private String gphy;

	public MktExchg() {
	}

	public MktExchg(String mktExchgName, String mktExchgDesc, String curr, String suffix, String gphy) {
		super();
		this.mktExchgName = mktExchgName;
		this.mktExchgDesc = mktExchgDesc;
		this.curr = curr;
		this.suffix = suffix;
		this.gphy = gphy;
	}

	@Id
	@Column(name = "MKT_EXCHG_NAME", unique = true, nullable = false, length = 10)
	public String getMktExchgName() {
		return mktExchgName;
	}

	public void setMktExchgName(String mktExchgName) {
		this.mktExchgName = mktExchgName;
	}

	@Column(name = "MKT_EXCHG_DESC", nullable = true, length = 100)
	public String getMktExchgDesc() {
		return mktExchgDesc;
	}

	public void setMktExchgDesc(String mktExchgDesc) {
		this.mktExchgDesc = mktExchgDesc;
	}

	@Column(name = "CURR", nullable = false, length = 5)
	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	@Column(name = "SUFFIX", nullable = true, length = 5)
	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Column(name = "GPHY", nullable = true, length = 6)
	public String getGphy() {
		return gphy;
	}

	public void setGphy(String gphy) {
		this.gphy = gphy;
	}

}

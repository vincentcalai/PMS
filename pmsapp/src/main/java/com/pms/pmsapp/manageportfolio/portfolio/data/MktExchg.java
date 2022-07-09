package com.pms.pmsapp.manageportfolio.portfolio.data;

//@Entity
//@Table(name = "PMS_MKT_EXCHG")
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

//	@Column(name = "MKT_EXCHG_NAME", nullable = false, length = 10)
	public String getMktExchgName() {
		return mktExchgName;
	}

	public void setMktExchgName(String mktExchgName) {
		this.mktExchgName = mktExchgName;
	}

//	@Column(name = "MKT_EXCHG_DESC", nullable = true, length = 100)
	public String getMktExchgDesc() {
		return mktExchgDesc;
	}

	public void setMktExchgDesc(String mktExchgDesc) {
		this.mktExchgDesc = mktExchgDesc;
	}

//	@Column(name = "CURR", nullable = false, length = 5)
	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

}

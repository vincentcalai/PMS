package com.pms.pmsapp.fixture;

import java.util.ArrayList;
import java.util.List;

import com.pms.pmsapp.common.data.MktExchg;

public class MktExchgFixture {

	public static List<MktExchg> createMktExchgListFixture() {

		List<MktExchg> mktExchgList = new ArrayList<>();
		mktExchgList.add(new MktExchg("NYSE", "New York Stock Exchange", "USD", null, "US"));
		mktExchgList.add(new MktExchg("NASDAQ", "National Association of Securities Dealers Automated Quotations",
				"USD", null, "US"));
		mktExchgList.add(new MktExchg("HKEX", "Hong Kong Stock Exchange", "HKD", ".HK", "HK"));
		mktExchgList.add(new MktExchg("SGX", "Singapore Stock Exchange", "SGD", ".SI", "US"));
		mktExchgList.add(new MktExchg("OTC", "Over-The-Counter", "USD", null, "US"));

		return mktExchgList;
	}

}

package com.pms.pmsapp.util.constant;

import java.util.HashMap;
import java.util.Map;

public class ConstantUtil {
	public static final String IND_NO = "N";
	public static final String IND_YES = "Y";

	public static final String CURRENCY_SGD = "SGD";
	public static final String CURRENCY_USD = "USD";
	public static final String CURRENCY_HKD = "HKD";

	public static final String SELL_ACTION = "SELL";

	private static final String EXCHG_HKEX = "HKSE";
	private static final String EXCHG_SGX = "SES";
	private static final String EXCHG_NYSE = "NYSE";
	private static final String EXCHG_NYSE_ARCA = "NYSEArca";
	private static final String EXCHG_NASDAQ_GS = "NasdaqGS";
	private static final String EXCHG_NASDAQ_GM = "NasdaqGM";
	private static final String EXCHG_NASDAQ_CM = "NasdaqCM";
	private static final String EXCHG_OTC = "Other OTC";

	private static final String RENAM_EXCHG_HKEX = "HKEX";
	private static final String RENAM_EXCHG_SGX = "SGX";
	private static final String RENAM_EXCHG_NYSE = "NYSE";
	private static final String RENAM_EXCHG_NASDAQ = "NASDAQ";
	private static final String RENAM_EXCHG_OTC = "OTC";

	public static Map<String, String> exchgSuffmap;

	static {
		exchgSuffmap = new HashMap<>();
		exchgSuffmap.put(EXCHG_HKEX, RENAM_EXCHG_HKEX);
		exchgSuffmap.put(EXCHG_SGX, RENAM_EXCHG_SGX);
		exchgSuffmap.put(EXCHG_NYSE, RENAM_EXCHG_NYSE);
		exchgSuffmap.put(EXCHG_NYSE_ARCA, RENAM_EXCHG_NYSE);
		exchgSuffmap.put(EXCHG_NASDAQ_GS, RENAM_EXCHG_NASDAQ);
		exchgSuffmap.put(EXCHG_NASDAQ_GM, RENAM_EXCHG_NASDAQ);
		exchgSuffmap.put(EXCHG_NASDAQ_CM, RENAM_EXCHG_NASDAQ);
		exchgSuffmap.put(EXCHG_OTC, RENAM_EXCHG_OTC);
	}
}

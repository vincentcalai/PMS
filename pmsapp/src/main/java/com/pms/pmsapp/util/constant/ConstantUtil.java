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

	public static final String PNL_TYPE_ALL = "ALL";
	public static final String PNL_TYPE_UNREAL = "UNREALISED";
	public static final String PNL_TYPE_REAL = "REALISED";

	public static final String COMPLETED_CD = "C";
	public static final String FAILED_CD = "F";
	public static final String INPROGRESS_CD = "IP";
	public static final String PENDING_CD = "P";

	public static final String COMPLETED_DESC = "COMPLETED";
	public static final String FAILED_DESC = "FAILED";
	public static final String INPROGRESS_DESC = "IN PROGRESS";
	public static final String PENDING_DESC = "PENDING";

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

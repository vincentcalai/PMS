package com.pms.pmsapp.common.service;

import javax.servlet.http.HttpServletResponse;

public interface DownloadService {
	public void handleLoadPortTrans(Long id, HttpServletResponse response);
	public void handleLoadPortTransLog(Long id, HttpServletResponse response);
	public void handleGenTransReport(Long id, HttpServletResponse response);
	public void handleGenHoldReport(Long id, HttpServletResponse response);
	public void handleLoadDiv(Long id, HttpServletResponse response);
	public void handleLoadDivLog(Long id, HttpServletResponse response);
}

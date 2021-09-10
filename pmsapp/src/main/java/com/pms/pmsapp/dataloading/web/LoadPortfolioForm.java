package com.pms.pmsapp.dataloading.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.pms.pmsapp.dataloading.data.LoadPortUpload;

public class LoadPortfolioForm {
	private MultipartFile file;
	private String uploadType;
	private String portfolioName;
	private Map<String,String> portfolioNameMap;
	private List<String> userIdList;
	private String loadingStatus;
	private String errMsg;
	private String sysMsg;
	
	private List<LoadPortUpload> deleteList = new ArrayList<LoadPortUpload>();
	
	public LoadPortfolioForm() {
		
	}
	
	public LoadPortfolioForm(MultipartFile file, String uploadType, String portfolioName,
			Map<String, String> portfolioNameMap, List<String> userIdList, String loadingStatus,
			List<LoadPortUpload> deleteList, String errMsg, String sysMsg) {
		super();
		this.file = file;
		this.uploadType = uploadType;
		this.portfolioName = portfolioName;
		this.portfolioNameMap = portfolioNameMap;
		this.userIdList = userIdList;
		this.loadingStatus = loadingStatus;
		this.deleteList = deleteList;
		this.errMsg = errMsg;
		this.sysMsg = sysMsg;
	}
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getUploadType() {
		return uploadType;
	}

	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public Map<String, String> getPortfolioNameMap() {
		return portfolioNameMap;
	}

	public void setPortfolioNameMap(Map<String, String> portfolioNameMap) {
		this.portfolioNameMap = portfolioNameMap;
	}

	public List<String> getUserIdList() {
		return userIdList;
	}

	public void setUserIdList(List<String> userIdList) {
		this.userIdList = userIdList;
	}

	public String getLoadingStatus() {
		return loadingStatus;
	}

	public void setLoadingStatus(String loadingStatus) {
		this.loadingStatus = loadingStatus;
	}

	public List<LoadPortUpload> getDeleteList() {
		return deleteList;
	}

	public void setDeleteList(List<LoadPortUpload> deleteList) {
		this.deleteList = deleteList;
	}
	
	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getSysMsg() {
		return sysMsg;
	}

	public void setSysMsg(String sysMsg) {
		this.sysMsg = sysMsg;
	}

}

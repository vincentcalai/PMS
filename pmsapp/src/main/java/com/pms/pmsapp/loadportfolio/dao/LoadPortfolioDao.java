package com.pms.pmsapp.loadportfolio.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.pms.pmsapp.loadportfolio.data.LoadPortUpload;

public interface LoadPortfolioDao{
	public List<LoadPortUpload> getUploadList(String portfolioName, Pageable pageable);
	public List<String> getPortfolios();
	public int checkTmpltHeader(MultipartFile file);
	public Long loadData(MultipartFile file, String portfolioName, String username);
	public void processLoadData(MultipartFile file, Long id, String portfolioName);
	public LoadPortUpload getHistFileById(Long id);
	public void deleteUploadHist(List<Long> idList);
	public long getUploadListCount();
}

package com.pms.pmsapp.dataloading.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.pms.pmsapp.dataloading.data.LoadPortUpload;

public interface LoadPortfolioDao{
	List<LoadPortUpload> getUploadList(String portfolioName, Pageable pageable);
	List<String> getPortfolios();
	int checkTmpltHeader(MultipartFile file);
	Long loadData(MultipartFile file, String portfolioName, String username);
	void processLoadData(MultipartFile file, Long id, String portfolioName);
	LoadPortUpload getHistFileById(Long id);
	void deleteUploadHist(List<Long> idList);
	long getUploadListCount();
}

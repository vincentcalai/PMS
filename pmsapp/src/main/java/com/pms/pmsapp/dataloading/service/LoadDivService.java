package com.pms.pmsapp.dataloading.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.pms.pmsapp.dataloading.data.LoadDivUpload;

public interface LoadDivService{
	List<LoadDivUpload> getUploadList(String portfolioName, Pageable pageable);
	List<String> getPortfolios();
	int checkTmpltHeader(MultipartFile file);
	Long loadData(MultipartFile file, String portfolioName, String username);
	void processLoadData(MultipartFile file, Long id, String portfolioName);
	LoadDivUpload getHistFileById(Long id);
	void deleteUploadHist(List<Long> idList);
	long getUploadListCount();
}

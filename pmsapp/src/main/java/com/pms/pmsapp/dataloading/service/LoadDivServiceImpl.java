package com.pms.pmsapp.dataloading.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pms.pmsapp.dataloading.dao.LoadDivDao;
import com.pms.pmsapp.dataloading.data.LoadDivUpload;

@Service
public class LoadDivServiceImpl implements LoadDivService {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDivServiceImpl.class);
	
	@Autowired
	private LoadDivDao loadDivDao;

	public List<LoadDivUpload> getUploadList(String portfolioName, Pageable pageable) {
		return loadDivDao.getUploadList(portfolioName, pageable);
	}
	
	public List<String> getPortfolios() {
		return loadDivDao.getPortfolios();
	}
	
	public int checkTmpltHeader(MultipartFile file) {
		return loadDivDao.checkTmpltHeader(file);
	}
	
	public Long loadData(MultipartFile file, String portfolioName, String username) {
		return loadDivDao.loadData(file, portfolioName, username);
	}
	

	public void processLoadData(MultipartFile file, Long id, String portfolioName) {
		loadDivDao.processLoadData(file, id, portfolioName);
	}
	
	public LoadDivUpload getHistFileById(Long id) {
		return loadDivDao.getHistFileById(id);
	}
	
	public void deleteUploadHist(List<Long> idList) {
		loadDivDao.deleteUploadHist(idList);
	}

	@Override
	public long getUploadListCount() {
		return loadDivDao.getUploadListCount();
	}
}

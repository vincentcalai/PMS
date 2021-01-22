package com.pms.pmsapp.loadportfolio.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pms.pmsapp.loadportfolio.dao.LoadPortfolioDao;
import com.pms.pmsapp.loadportfolio.data.LoadPortUpload;

@Service
public class LoadPortfolioServiceImpl implements LoadPortfolioService {
	
	private static final Logger log = LoggerFactory.getLogger(LoadPortfolioServiceImpl.class);
	
	@Autowired
	private LoadPortfolioDao loadPortfolioDao;

	public List<LoadPortUpload> getUploadList(String portfolioName, Pageable pageable) {
		return loadPortfolioDao.getUploadList(portfolioName, pageable);
	}
	
	public List<String> getPortfolios() {
		return loadPortfolioDao.getPortfolios();
	}
	
	public int checkTmpltHeader(MultipartFile file) {
		return loadPortfolioDao.checkTmpltHeader(file);
	}
	
	public Long loadData(MultipartFile file, String portfolioName, String username) {
		return loadPortfolioDao.loadData(file, portfolioName, username);
	}
	

	public void processLoadData(MultipartFile file, Long id, String portfolioName) {
		loadPortfolioDao.processLoadData(file, id, portfolioName);
	}
	
	public LoadPortUpload getHistFileById(Long id) {
		return loadPortfolioDao.getHistFileById(id);
	}
	
	public void deleteUploadHist(List<Long> idList) {
		loadPortfolioDao.deleteUploadHist(idList);
	}

	@Override
	public long getUploadListCount() {
		return loadPortfolioDao.getUploadListCount();
	}
}

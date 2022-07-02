package com.pms.pmsapp.dataloading.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pms.pmsapp.dataloading.dao.LoadPortfolioDao;
import com.pms.pmsapp.dataloading.data.LoadPortUpload;
import com.pms.pmsapp.dataloading.web.LoadPortfolioForm;

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

	@Override
	public LoadPortfolioForm uploadFile(LoadPortfolioForm loadPortfolioForm, MultipartFile file, String username) {
		String fileName = file.getOriginalFilename();
		String fileExtension = "";
		String fileWithoutExt = "";
		String portfolioName = loadPortfolioForm.getPortfolioName();
		String errMsg = "";
		String sysMsg = "";

		int dotPosition = fileName.lastIndexOf('.');
		if (dotPosition > 0) {
			fileExtension = fileName.substring(dotPosition + 1);
			log.info("File extension: " + fileExtension);
		}

		fileWithoutExt = fileName.substring(0, dotPosition);
		log.info("File without extension: " + fileWithoutExt);

		if (!(fileExtension.equals("xls") || fileExtension.equals("xlsx"))) {
			errMsg = "File type is incorrect. Please upload '.xls' or '.xlsx' files only.";
		} else if (fileWithoutExt.length() > 80) {
			errMsg = "Name of uploaded file is too long. Uploaded file name length should be less than 80 characters.";
		} else {
			int tmpltHeaderCheck = 0;
			try {
				tmpltHeaderCheck = checkTmpltHeader(file);
				log.info("tmpltHeaderCheck: " + tmpltHeaderCheck);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			if (tmpltHeaderCheck == 0) {
				long id = loadData(file, portfolioName, username);
				sysMsg = "File has been loaded. Refresh to see the latest status change.";
				processLoadData(file, id, portfolioName);
				log.info("loading completed.");
			} else if (tmpltHeaderCheck == -1) {
				errMsg = "An incorrect file was uploaded. Please upload the correct file (Load Portfolio).";
			} else {
				errMsg = "An error occurred while uploading the file. Please contact the administrator.";
			}
		}

		loadPortfolioForm.setErrMsg(errMsg);
		loadPortfolioForm.setSysMsg(sysMsg);

		return loadPortfolioForm;
	}

	@Override
	public void deleteUploadPortfolio(LoadPortfolioForm loadPortfolioForm) {
		List<Long> idList = new ArrayList<Long>();
		List<LoadPortUpload> deleteList = loadPortfolioForm.getDeleteList();

		for (LoadPortUpload rec : deleteList) {
			Long id = rec.getUploadId();
			idList.add(id);
		}

		if (!idList.isEmpty()) {
			deleteUploadHist(idList);
		}
	}
}

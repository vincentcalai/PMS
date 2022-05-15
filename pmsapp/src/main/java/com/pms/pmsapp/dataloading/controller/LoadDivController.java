package com.pms.pmsapp.dataloading.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pms.pmsapp.dataloading.data.LoadDivUpload;
import com.pms.pmsapp.dataloading.data.LoadPortUpload;
import com.pms.pmsapp.dataloading.service.LoadDivService;
import com.pms.pmsapp.dataloading.web.LoadDivForm;
import com.pms.pmsapp.dataloading.web.LoadPortfolioForm;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class LoadDivController {

	private static final Logger log = LoggerFactory.getLogger(LoadDivController.class);

	private final String COMPLETED_CD = "C";
	private final String FAILED_CD = "F";
	private final String INPROGRESS_CD = "IP";
	private final String PENDING_CD = "P";

	private final String COMPLETED_DESC = "COMPLETED";
	private final String FAILED_DESC = "FAILED";
	private final String INPROGRESS_DESC = "IN PROGRESS";
	private final String PENDING_DESC = "PENDING";


	@Autowired
	private LoadDivService loadDivService;

	@RequestMapping(value="/loaddiv/getUploadList", method=RequestMethod.POST)
	public Page<LoadDivUpload> getUploadList(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestBody LoadDivForm loadPortfolioForm) {
		log.info("getUploadList in Controller");
		String portfolioName = loadPortfolioForm.getPortfolioName();

		Pageable pageable = PageRequest.of(page-1, size);

		List<LoadDivUpload> dtos = loadDivService.getUploadList(portfolioName, pageable);
		long totalRec = loadDivService.getUploadListCount();

		List<LoadDivUpload> loadDivList = new ArrayList<LoadDivUpload>();
		for(LoadDivUpload dto: dtos){
			LoadDivUpload record = new LoadDivUpload();
			record.setUploadId(dto.getUploadId());
			record.setPortfolioName(dto.getPortfolioName());
			record.setFileData(dto.getFileData());
			record.setFileName(dto.getFileName());
			record.setLogData(dto.getLogData());
			record.setLogName(dto.getLogName());
			record.setCreatedBy(dto.getCreatedBy());
			record.setCreatedDt(dto.getCreatedDt());
			if (COMPLETED_CD.equals(dto.getStatus()))
				record.setStatus(COMPLETED_DESC);
			else if (FAILED_CD.equals(dto.getStatus()))
				record.setStatus(FAILED_DESC);
			else if (PENDING_CD.equals(dto.getStatus()))
				record.setStatus(PENDING_DESC);
			else if (INPROGRESS_CD.equals(dto.getStatus()))
				record.setStatus(INPROGRESS_DESC);

			record.setFileData(null);
			record.setLogData(null);

			loadDivList.add(record);
		}

		PageImpl<LoadDivUpload> loadDivPage = new PageImpl(loadDivList, pageable, totalRec);
		return loadDivPage;
	}

	@RequestMapping(value="/loaddiv/init", method=RequestMethod.POST)
	public List<String> getPortfolios(@RequestBody LoadPortfolioForm loadPortfolioForm) {
		log.info("getPortfolios in Controller");
		List<String> portfolios = loadDivService.getPortfolios();
		return portfolios;
	}

	@RequestMapping(value="/loaddiv/uploadFile", method=RequestMethod.POST)
	public LoadPortfolioForm uploadFile(@RequestPart(value="param", required=true) LoadPortfolioForm loadPortfolioForm,
			@RequestPart(value="file", required = false) MultipartFile file, Authentication authentication) {
		log.info("uploadFile in Controller");
		String fileName = file.getOriginalFilename();
		String fileExtension = "";
		String fileWithoutExt = "";
		String portfolioName = loadPortfolioForm.getPortfolioName();
		String errMsg = "";
		String sysMsg = "";
		String username = "";

		username = authentication.getName();

		int dotPosition = fileName.lastIndexOf('.');
		if (dotPosition > 0) {
			fileExtension = fileName.substring(dotPosition+1);
		    log.info("File extension: " + fileExtension);
		}

		fileWithoutExt = fileName.substring(0, dotPosition);
			log.info("File without extension: " + fileWithoutExt);

		if(!(fileExtension.equals("xls") || fileExtension.equals("xlsx"))) {
			errMsg = "File type is incorrect. Please upload '.xls' or '.xlsx' files only.";
		}else if(fileWithoutExt.length() > 80 ) {
			errMsg = "Name of uploaded file is too long. Uploaded file name length should be less than 80 characters.";
		}else {
			int tmpltHeaderCheck = 0;
			try {
				tmpltHeaderCheck = loadDivService.checkTmpltHeader(file);
				log.info("tmpltHeaderCheck: " + tmpltHeaderCheck);
			}catch(Exception e) {
				log.error(e.getMessage());
			}
			if(tmpltHeaderCheck == 0) {
				long id = loadDivService.loadData(file, portfolioName, username);
				sysMsg = "File has been loaded. Refresh to see the latest status change.";
				loadDivService.processLoadData(file, id, portfolioName);
				log.info("loading completed.");
			} else if(tmpltHeaderCheck == -1) {
				errMsg = "An incorrect file was uploaded. Please upload the correct file (Load Portfolio).";
			} else {
				errMsg = "An error occurred while uploading the file. Please contact the administrator.";
			}
		}

		loadPortfolioForm.setErrMsg(errMsg);
		loadPortfolioForm.setSysMsg(sysMsg);

		return loadPortfolioForm;
	}

	@RequestMapping(value="/loaddiv/delete", method=RequestMethod.POST)
	public void deleteUpload(@RequestBody LoadPortfolioForm loadPortfolioForm) {
		log.info("deleteUpload in Controller");
		List<Long> idList = new ArrayList<Long>();
		List<LoadPortUpload> deleteList = loadPortfolioForm.getDeleteList();

		for(LoadPortUpload rec : deleteList) {
			Long id = rec.getUploadId();
			idList.add(id);
		}

		if(!idList.isEmpty()) {
			loadDivService.deleteUploadHist(idList);
		}

	}





}

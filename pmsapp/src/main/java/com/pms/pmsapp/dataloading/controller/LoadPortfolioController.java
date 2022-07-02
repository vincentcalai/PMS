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

import com.pms.pmsapp.dataloading.data.LoadPortUpload;
import com.pms.pmsapp.dataloading.service.LoadPortfolioService;
import com.pms.pmsapp.dataloading.web.LoadPortfolioForm;
import com.pms.pmsapp.util.constant.ConstantUtil;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class LoadPortfolioController {

	private static final Logger log = LoggerFactory.getLogger(LoadPortfolioController.class);

	@Autowired
	private LoadPortfolioService loadPortfolioService;

	@RequestMapping(value = "/loadportfolio/getUploadList", method = RequestMethod.POST)
	public Page<LoadPortUpload> getUploadList(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestBody LoadPortfolioForm loadPortfolioForm) {
		log.info("getUploadList in Controller");
		String portfolioName = loadPortfolioForm.getPortfolioName();

		Pageable pageable = PageRequest.of(page - 1, size);

		List<LoadPortUpload> dtos = loadPortfolioService.getUploadList(portfolioName, pageable);
		long totalRec = loadPortfolioService.getUploadListCount();

		List<LoadPortUpload> loadPortfolioList = new ArrayList<LoadPortUpload>();
		for (LoadPortUpload dto : dtos) {
			LoadPortUpload record = new LoadPortUpload();
			record.setUploadId(dto.getUploadId());
			record.setPortfolioName(dto.getPortfolioName());
			record.setFileData(dto.getFileData());
			record.setFileName(dto.getFileName());
			record.setLogData(dto.getLogData());
			record.setLogName(dto.getLogName());
			record.setCreatedBy(dto.getCreatedBy());
			record.setCreatedDt(dto.getCreatedDt());
			if (ConstantUtil.COMPLETED_CD.equals(dto.getStatus()))
				record.setStatus(ConstantUtil.COMPLETED_DESC);
			else if (ConstantUtil.FAILED_CD.equals(dto.getStatus()))
				record.setStatus(ConstantUtil.FAILED_DESC);
			else if (ConstantUtil.PENDING_CD.equals(dto.getStatus()))
				record.setStatus(ConstantUtil.PENDING_DESC);
			else if (ConstantUtil.INPROGRESS_CD.equals(dto.getStatus()))
				record.setStatus(ConstantUtil.INPROGRESS_DESC);

			record.setFileData(null);
			record.setLogData(null);

			loadPortfolioList.add(record);
		}

		// return loadPortfolioList;
		PageImpl<LoadPortUpload> loadPortfolioPage = new PageImpl(loadPortfolioList, pageable, totalRec);
		return loadPortfolioPage;
	}

	@RequestMapping(value = "/loadportfolio/init", method = RequestMethod.POST)
	public List<String> getPortfolios(@RequestBody LoadPortfolioForm loadPortfolioForm) {
		log.info("getPortfolios in Controller");
		return loadPortfolioService.getPortfolios();
	}

	@RequestMapping(value = "/loadportfolio/uploadFile", method = RequestMethod.POST)
	public LoadPortfolioForm uploadFile(
			@RequestPart(value = "param", required = true) LoadPortfolioForm loadPortfolioForm,
			@RequestPart(value = "file", required = false) MultipartFile file, Authentication authentication) {
		log.info("uploadFile in Controller");

		String username = authentication.getName();

		return loadPortfolioService.uploadFile(loadPortfolioForm, file, username);
	}

	@RequestMapping(value = "/loadportfolio/delete", method = RequestMethod.POST)
	public void deleteUpload(@RequestBody LoadPortfolioForm loadPortfolioForm) {
		log.info("deleteUpload in Controller");

		loadPortfolioService.deleteUploadPortfolio(loadPortfolioForm);
	}

}

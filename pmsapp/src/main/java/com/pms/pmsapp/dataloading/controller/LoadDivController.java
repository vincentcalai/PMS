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
import com.pms.pmsapp.dataloading.service.LoadDivService;
import com.pms.pmsapp.dataloading.web.LoadDivForm;
import com.pms.pmsapp.dataloading.web.LoadPortfolioForm;
import com.pms.pmsapp.util.constant.ConstantUtil;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class LoadDivController {

	private static final Logger log = LoggerFactory.getLogger(LoadDivController.class);

	@Autowired
	private LoadDivService loadDivService;

	@RequestMapping(value = "/loaddiv/getUploadList", method = RequestMethod.POST)
	public Page<LoadDivUpload> getUploadList(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestBody LoadDivForm loadPortfolioForm) {
		log.info("getUploadList in Controller");
		String portfolioName = loadPortfolioForm.getPortfolioName();

		Pageable pageable = PageRequest.of(page - 1, size);

		List<LoadDivUpload> dtos = loadDivService.getUploadList(portfolioName, pageable);
		long totalRec = loadDivService.getUploadListCount();

		List<LoadDivUpload> loadDivList = new ArrayList<LoadDivUpload>();
		for (LoadDivUpload dto : dtos) {
			LoadDivUpload record = new LoadDivUpload();
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

			loadDivList.add(record);
		}

		PageImpl<LoadDivUpload> loadDivPage = new PageImpl(loadDivList, pageable, totalRec);
		return loadDivPage;
	}

	@RequestMapping(value = "/loaddiv/init", method = RequestMethod.POST)
	public List<String> getPortfolios(@RequestBody LoadPortfolioForm loadPortfolioForm) {
		log.info("getPortfolios in Controller");
		return loadDivService.getPortfolios();
	}

	@RequestMapping(value = "/loaddiv/uploadFile", method = RequestMethod.POST)
	public LoadPortfolioForm uploadFile(
			@RequestPart(value = "param", required = true) LoadPortfolioForm loadPortfolioForm,
			@RequestPart(value = "file", required = false) MultipartFile file, Authentication authentication) {
		log.info("uploadFile in Controller");

		String username = authentication.getName();

		return loadDivService.uploadFile(loadPortfolioForm, file, username);
	}

	@RequestMapping(value = "/loaddiv/delete", method = RequestMethod.POST)
	public void deleteUpload(@RequestBody LoadPortfolioForm loadPortfolioForm) {
		log.info("deleteUpload in Controller");

		loadDivService.deleteUploadDiv(loadPortfolioForm);
	}

}

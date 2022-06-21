package com.pms.pmsapp.common;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.common.service.DownloadService;


@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class DownloadController {

	private static final Logger log = LoggerFactory.getLogger(DownloadController.class);

	@Autowired
	private DownloadService downloadService;
	

	@RequestMapping(value = "/downloadTmplt", method = RequestMethod.GET)
	public void downloadTmplt(String fileName, HttpServletResponse res) throws IOException, URISyntaxException {
		res.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		res.getOutputStream().write(contentOf("excel/" + fileName));
	}

	public byte[] contentOf(String fileName) throws IOException, URISyntaxException {
		log.info("download path: " + Paths.get(getClass().getClassLoader().getResource(fileName).toURI()));
		return Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(fileName).toURI()));
	}

	@RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
	public void downloadFile(Long fileId, HttpServletResponse res) throws IOException, URISyntaxException {
		//res.setHeader("Content-Disposition", "attachment; fileId=" + fileId);
		res.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
		downloadService.handleLoadPortTrans(fileId,res);
	}

	@RequestMapping(value = "/genTransReport", method = RequestMethod.GET)
	public void genTransReport(Long fileId, HttpServletResponse res) throws IOException, URISyntaxException {
		res.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
		downloadService.handleGenTransReport(fileId,res);
	}

	@RequestMapping(value = "/genHoldReport", method = RequestMethod.GET)
	public void genHoldReport(Long fileId, HttpServletResponse res) throws IOException, URISyntaxException {
		res.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
		downloadService.handleGenHoldReport(fileId,res);
	}

	@RequestMapping(value = "/downloadLogFile", method = RequestMethod.GET)
	public void downloadLogFile(Long fileId, HttpServletResponse res) throws IOException, URISyntaxException {
		res.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
		downloadService.handleLoadPortTransLog(fileId,res);
	}

	@RequestMapping(value = "/downloadDivUploadFile", method = RequestMethod.GET)
	public void downloadDivUploadFile(Long fileId, HttpServletResponse res) throws IOException, URISyntaxException {
		//res.setHeader("Content-Disposition", "attachment; fileId=" + fileId);
		res.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
		downloadService.handleLoadDiv(fileId,res);
	}

	@RequestMapping(value = "/downloadDivLogFile", method = RequestMethod.GET)
	public void downloadDivLogFile(Long fileId, HttpServletResponse res) throws IOException, URISyntaxException {
		res.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
		downloadService.handleLoadDivLog(fileId,res);
	}

	


}

package com.pms.pmsapp.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.dataloading.data.LoadDivUpload;
import com.pms.pmsapp.dataloading.data.LoadPortUpload;
import com.pms.pmsapp.dataloading.service.LoadDivService;
import com.pms.pmsapp.dataloading.service.LoadPortfolioService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;


@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class DownloadController {

	private static final Logger log = LoggerFactory.getLogger(DownloadController.class);

	@Autowired
	private LoadPortfolioService loadPortfolioService;

	@Autowired
	private LoadDivService loadDivService;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

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
		handleLoadPortTrans(fileId,res);
	}

	@RequestMapping(value = "/genTransReport", method = RequestMethod.GET)
	public void genTransReport(Long fileId, HttpServletResponse res) throws IOException, URISyntaxException {
		res.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
		handleGenTransReport(fileId,res);
	}

	@RequestMapping(value = "/genHoldReport", method = RequestMethod.GET)
	public void genHoldReport(Long fileId, HttpServletResponse res) throws IOException, URISyntaxException {
		res.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
		handleGenHoldReport(fileId,res);
	}

	@RequestMapping(value = "/downloadLogFile", method = RequestMethod.GET)
	public void downloadLogFile(Long fileId, HttpServletResponse res) throws IOException, URISyntaxException {
		res.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
		handleLoadPortTransLog(fileId,res);
	}

	@RequestMapping(value = "/downloadDivUploadFile", method = RequestMethod.GET)
	public void downloadDivUploadFile(Long fileId, HttpServletResponse res) throws IOException, URISyntaxException {
		//res.setHeader("Content-Disposition", "attachment; fileId=" + fileId);
		res.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
		handleLoadDiv(fileId,res);
	}

	@RequestMapping(value = "/downloadDivLogFile", method = RequestMethod.GET)
	public void downloadDivLogFile(Long fileId, HttpServletResponse res) throws IOException, URISyntaxException {
		res.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
		handleLoadDivLog(fileId,res);
	}

	private void handleLoadPortTrans(Long id, HttpServletResponse response) {
		LoadPortUpload fileLoad = null;

		try {
			fileLoad = loadPortfolioService.getHistFileById(id);
		} catch (Exception e) {
			log.error("", e);
		}

		try {
			if (fileLoad.getFileData() != null) {
				byte[] bytes = fileLoad.getFileData();

				response.setContentType("application/x-download");
				response.setHeader("Content-Disposition",
						"attachment; filename=" + fileLoad.getFileName() + ".xlsx");
				response.setContentLength(fileLoad.getFileData().length);
				response.getOutputStream().write(bytes);
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
		} catch (Exception e) {
			log.error("", e);
		}
	}

	private void handleLoadPortTransLog(Long id, HttpServletResponse response) {
		LoadPortUpload fileLoad = null;

		try {
			fileLoad = loadPortfolioService.getHistFileById(id);
		} catch (Exception e) {
			log.error("", e);
		}

		try {
			if (fileLoad.getLogData() != null) {

				Clob logData = fileLoad.getLogData();

				InputStream fis = logData.getAsciiStream();
				response.setContentType("application/x-download");
				response.setHeader("Content-Disposition", "attachment; filename=" + fileLoad.getLogName() + ".txt");
				response.setContentLength((int) logData.length());
				response.getOutputStream().write(IOUtils.toByteArray(fis));
				response.getOutputStream().flush();
				response.getOutputStream().close();
				fis.close();
			}
		} catch (Exception e) {
			log.error("", e);
		}
	}

	private void handleGenTransReport(Long id, HttpServletResponse response) {

		try {
			InputStream transactionReportStream = getClass().getResourceAsStream("/jrxml/transaction.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(transactionReportStream);

			Map<String, Object> params = new HashMap<>();
			params.put("portId", id);

			Connection conn = DriverManager.getConnection(url, username, password);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);

			String fileName = "transaction";
			File file = new File(fileName + ".xlsx");

			SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
			configuration.setOnePagePerSheet(true);
			configuration.setIgnoreGraphics(false);
			configuration.setIgnoreCellBorder(false);
			configuration.setWhitePageBackground(false);
			JRXlsxExporter  exporter = new JRXlsxExporter ();
		    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file.getAbsolutePath()));
		    exporter.setConfiguration(configuration);
		    exporter.exportReport();

			byte[] bytes = Files.readAllBytes(file.toPath());

			response.setContentType("application/x-download");
			response.setHeader("Content-Disposition",
					"attachment; filename=" + fileName + ".xlsx");
			response.setContentLength((int) file.length());
			response.getOutputStream().write(bytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (Exception e) {
			log.error("", e);
		}

	}

	private void handleGenHoldReport(Long id, HttpServletResponse response) {

		try {
			InputStream transactionReportStream = getClass().getResourceAsStream("/jrxml/holdings.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(transactionReportStream);

			Map<String, Object> params = new HashMap<>();
			params.put("portId", id);

			Connection conn = DriverManager.getConnection(url, username, password);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);

			String home = System.getProperty("user.home");
			String fileName = "holdings";
			File file = new File(fileName + ".xlsx");

			SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
			configuration.setOnePagePerSheet(true);
			configuration.setIgnoreGraphics(false);
			configuration.setIgnoreCellBorder(false);
			configuration.setWhitePageBackground(false);
			JRXlsxExporter  exporter = new JRXlsxExporter ();
		    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file.getAbsolutePath()));
		    exporter.setConfiguration(configuration);
		    exporter.exportReport();

			byte[] bytes = Files.readAllBytes(file.toPath());

			response.setContentType("application/x-download");
			response.setHeader("Content-Disposition",
					"attachment; filename=" + fileName + ".xlsx");
			response.setContentLength((int) file.length());
			response.getOutputStream().write(bytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (Exception e) {
			log.error("", e);
		}

	}

	private void handleLoadDiv(Long id, HttpServletResponse response) {
		LoadDivUpload fileLoad = null;

		try {
			fileLoad = loadDivService.getHistFileById(id);
		} catch (Exception e) {
			log.error("", e);
		}

		try {
			if (fileLoad.getFileData() != null) {
				byte[] bytes = fileLoad.getFileData();

				response.setContentType("application/x-download");
				response.setHeader("Content-Disposition",
						"attachment; filename=" + fileLoad.getFileName() + ".xlsx");
				response.setContentLength(fileLoad.getFileData().length);
				response.getOutputStream().write(bytes);
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
		} catch (Exception e) {
			log.error("", e);
		}
	}

	private void handleLoadDivLog(Long id, HttpServletResponse response) {
		LoadDivUpload fileLoad = null;

		try {
			fileLoad = loadDivService.getHistFileById(id);
		} catch (Exception e) {
			log.error("", e);
		}

		try {
			if (fileLoad.getLogData() != null) {

				Clob logData = fileLoad.getLogData();

				InputStream fis = logData.getAsciiStream();
				response.setContentType("application/x-download");
				response.setHeader("Content-Disposition", "attachment; filename=" + fileLoad.getLogName() + ".txt");
				response.setContentLength((int) logData.length());
				response.getOutputStream().write(IOUtils.toByteArray(fis));
				response.getOutputStream().flush();
				response.getOutputStream().close();
				fis.close();
			}
		} catch (Exception e) {
			log.error("", e);
		}
	}


}

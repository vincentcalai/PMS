package com.pms.pmsapp.common.service;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
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
import org.springframework.stereotype.Service;

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

@Service	
public class DownloadServiceImpl implements DownloadService{
	
	private static final Logger log = LoggerFactory.getLogger(DownloadServiceImpl.class);
	
	@Autowired
	private LoadPortfolioService loadPortfolioService ;
	
	@Autowired
	private LoadDivService loadDivService;
	
	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;
	
	public void handleLoadPortTrans(Long id, HttpServletResponse response) {
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

	public void handleLoadPortTransLog(Long id, HttpServletResponse response) {
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

	public void handleGenTransReport(Long id, HttpServletResponse response) {

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

	public void handleGenHoldReport(Long id, HttpServletResponse response) {

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

	public void handleLoadDiv(Long id, HttpServletResponse response) {
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

	public void handleLoadDivLog(Long id, HttpServletResponse response) {
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

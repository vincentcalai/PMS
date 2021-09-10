package com.pms.pmsapp.dataloading.data;

import java.sql.Clob;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class LoadDivUpload{

	private long uploadId;
	private String portfolioName;
	private byte[] fileData;
	private String fileName;
	private Clob logData;
	private String logName;
	private String createdBy;
	private Date createdDt;
	private String status;
	private String delInd;
	
	public LoadDivUpload() {
	}
	
	public LoadDivUpload(long uploadId) {
		this.uploadId = uploadId;
	}
	
	public LoadDivUpload(long uploadId, String portfolioName, byte[] fileData, String fileName, Clob logData,
			String logName, String createdBy, Date createdDt, String status, String delInd) {
		super();
		this.uploadId = uploadId;
		this.portfolioName = portfolioName;
		this.fileData = fileData;
		this.fileName = fileName;
		this.logData = logData;
		this.logName = logName;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
		this.status = status;
		this.delInd = delInd;
	}
	public long getUploadId() {
		return uploadId;
	}
	public void setUploadId(long uploadId) {
		this.uploadId = uploadId;
	}
	public String getPortfolioName() {
		return portfolioName;
	}
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Clob getLogData() {
		return logData;
	}
	public void setLogData(Clob logData) {
		this.logData = logData;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDelInd() {
		return delInd;
	}
	public void setDelInd(String delInd) {
		this.delInd = delInd;
	}
	
	
}

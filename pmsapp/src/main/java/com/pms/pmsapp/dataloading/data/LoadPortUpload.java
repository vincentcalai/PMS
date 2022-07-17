package com.pms.pmsapp.dataloading.data;

import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PMS_LOAD_PORT_UPLOAD")
@SequenceGenerator(name = "LoadPortUploadSeqGenerator", sequenceName = "SQ_PMS_LOAD_PORT_UPLOAD", allocationSize = 1)
public class LoadPortUpload {

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

	public LoadPortUpload() {
	}

	public LoadPortUpload(long uploadId) {
		this.uploadId = uploadId;
	}

	public LoadPortUpload(long uploadId, String portfolioName, byte[] fileData, String fileName, Clob logData,
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

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LoadPortUploadSeqGenerator")
	@Column(name = "UPLOAD_ID", unique = true, nullable = false)
	public long getUploadId() {
		return uploadId;
	}

	public void setUploadId(long uploadId) {
		this.uploadId = uploadId;
	}

	@Column(name = "PORT_NAME", nullable = false, length = 25)
	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	@Column(name = "FILE_DATA", nullable = true)
	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	@Column(name = "FILE_NAME", nullable = true, length = 87)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "LOG_DATA", nullable = true)
	public Clob getLogData() {
		return logData;
	}

	public void setLogData(Clob logData) {
		this.logData = logData;
	}

	@Column(name = "LOG_NAME", nullable = true, length = 87)
	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	@Column(name = "CREATED_BY", nullable = true, length = 20)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "CREATED_DT", nullable = true)
	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	@Column(name = "STATUS", nullable = true, length = 1)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "DEL_IND", nullable = true, length = 1)
	public String getDelInd() {
		return delInd;
	}

	public void setDelInd(String delInd) {
		this.delInd = delInd;
	}

}

package com.pms.pmsapp.dataloading.dao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionImpl;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.pms.pmsapp.dataloading.data.LoadPortUpload;
import com.pms.pmsapp.dataloading.data.LoadPortfolioTrans;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioHoldService;
import com.pms.pmsapp.sysadmin.service.UserService;
import com.pms.pmsapp.util.HibernateUtil;


@Repository
public class LoadPortfolioDaoImpl implements LoadPortfolioDao {

	private static final Logger log = LoggerFactory.getLogger(LoadPortfolioDaoImpl.class);

	private final String STOCK_NAME = "Stock Name";
	private final String STOCK_EXCHG = "Stock Exchange";
	private final String STOCK_SYMBOL = "Stock Symbol";
	private final String NO_OF_SHARE = "No. of Share";
	private final String TRANS_PRICE = "Transaction Price";
	private final String ACTION = "Action";
	private final String TRANS_CREATED_BY = "Transacted By";
	private final String TRANS_CREATED_DT = "Transaction Created Date";
	private final String REMARKS = "Remarks";

	private final String EXCHG_HKEX = "HKSE";
	private final String EXCHG_SGX = "SES";
	private final String EXCHG_NYSE = "NYSE";
	private final String EXCHG_NYSE_ARCA = "NYSEArca";
	private final String EXCHG_NASDAQ = "NasdaqGS";
	private final String EXCHG_OTC = "Other OTC";

	private final String RENAM_EXCHG_HKEX = "HKEX";
	private final String RENAM_EXCHG_SGX = "SGX";
	private final String RENAM_EXCHG_NYSE = "NYSE";
	private final String RENAM_EXCHG_NASDAQ = "NASDAQ";
	private final String RENAM_EXCHG_OTC = "OTC";

	private final String ACTION_BUY = "BUY";
	private final String ACTION_SELL = "SELL";

	private final String FAILED = "F";
	private final String COMPLETED = "C";
	private final String PENDING = "P";
	private final String NO = "N";

	private final String isNumberRegex = "\\d+";
	private final String priceRegex = "^\\d{0,8}(\\.\\d{1,3})?$";
	private final String dateRegex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

	@Autowired
	private PortfolioHoldService portfolioHoldService;

	@Autowired
	private UserService userService;

	public List<LoadPortUpload> getUploadList(String portfolioName, Pageable pageable) {
		log.info("getUploadList in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT * FROM PMS_LOAD_PORT_UPLOAD order by UPLOAD_ID desc";

			SQLQuery sqlQuery = session.createSQLQuery(sql);

			sqlQuery.addEntity(LoadPortUpload.class);

			sqlQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
			sqlQuery.setMaxResults(pageable.getPageSize());

			List<LoadPortUpload> loadPortfolioList = sqlQuery.list();

			return loadPortfolioList;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public List<String> getPortfolios() {
		String sqlQuery = "SELECT PORT_NAME FROM PMS_PORT order by ID";
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<String> portfolios = session.createSQLQuery(sqlQuery).list();
		return portfolios;
	}

	@Override
	public int checkTmpltHeader(MultipartFile file) {
	    try {
	    	InputStream is = new ByteArrayInputStream(file.getBytes());
			Workbook wb = WorkbookFactory.create(is);
			Sheet sheet = wb.getSheetAt(0);
			DataFormatter fmt = new DataFormatter();

			Row row = sheet.getRow(0);

			int index = 0;
//			boolean stockNameHeader = fmt.formatCellValue(row.getCell(index++)).toString().contains(STOCK_NAME);
//			boolean stockExchgHeader = fmt.formatCellValue(row.getCell(index++)).toString().contains(STOCK_EXCHG);
			boolean stockSymHeader = fmt.formatCellValue(row.getCell(index++)).contains(STOCK_SYMBOL);
			boolean noOfShareHeader = fmt.formatCellValue(row.getCell(index++)).contains(NO_OF_SHARE);
			boolean transPriceHeader = fmt.formatCellValue(row.getCell(index++)).contains(TRANS_PRICE);
			boolean actionHeader = fmt.formatCellValue(row.getCell(index++)).contains(ACTION);
			boolean createdByHeader = fmt.formatCellValue(row.getCell(index++)).contains(TRANS_CREATED_BY);
			boolean createdDateHeader = fmt.formatCellValue(row.getCell(index++)).contains(TRANS_CREATED_DT);
			boolean remarksHeader = fmt.formatCellValue(row.getCell(index++)).contains(REMARKS);

//			if(!stockNameHeader) {
//				return -1;
//			}
//			if(!stockExchgHeader) {
//				return -1;
//			}
			if(!stockSymHeader) {
				return -1;
			}
			if(!noOfShareHeader) {
				return -1;
			}
			if(!actionHeader) {
				return -1;
			}
			if(!transPriceHeader) {
				return -1;
			}
			if(!createdByHeader) {
				return -1;
			}
			if(!createdDateHeader) {
				return -1;
			}
			if(!remarksHeader) {
				return -1;
			}

			return 0;
	    } catch(Exception e){
	    	log.error(e.getMessage());
	    	return -2;
	    }
	}

	@Override
	public Long loadData(MultipartFile file, String portfolioName, String username) {
		String fileName = file.getOriginalFilename();
		int dotPosition = fileName.lastIndexOf('.');
		String fileWithoutExt = fileName.substring(0, dotPosition);

		LoadPortUpload dto = new LoadPortUpload();

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			dto.setPortfolioName(portfolioName);
			dto.setFileData(file.getBytes());
			dto.setFileName(fileWithoutExt);
			dto.setCreatedBy(username);
			dto.setCreatedDt(Calendar.getInstance().getTime());
			dto.setStatus(PENDING);
			dto.setDelInd(NO);

			Long id = (Long) session.save(dto);

			transaction.commit();
			return id;
		}catch(Exception e){
			log.error(e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@SuppressWarnings("unused")
	@Override
	@Async
	public void processLoadData(MultipartFile file, Long id, String portfolioName) {
		log.info("start Async processLoadData...");
		LoadPortUpload dto = getUploadId(id);
		String fileName = dto.getFileName();
		byte[] fileData = dto.getFileData();
		String logName = "output.log";
		Clob logData = null;

		String suffix = "";
		String stockSym = "";

		long rowNum = 0;
		int insertedRow = 0;
		int rowId = 0;

		boolean rowError = false;
		boolean rowListError = false;
		boolean deleteRow = false;

		Map<String, String> exchgSuffmap = new HashMap<String, String>();
		List<String> stockList = new ArrayList<String>();

		StringBuffer logDataSb = new StringBuffer();
		LoadPortfolioTrans portTrans = null;
		List<LoadPortfolioTrans> portTransList = new ArrayList<LoadPortfolioTrans>();
		logName = fileName;
		InputStream is = null;

		try{
			is = new ByteArrayInputStream(fileData);
			Workbook wb = WorkbookFactory.create(is);
			Sheet sheet = wb.getSheetAt(0);
			DataFormatter fmt = new DataFormatter();

//			int stockNameIdx = 0;
//			int stockExchgIdx = 1;
			int stockSymIdx = 0;
			int noOfShareIdx = 1;
			int transPriceIdx = 2;
			int actionIdx = 3;
			int createdByIdx = 4;
			int createdDtIdx = 5;

			for(int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) { //start data validation
				Row row = sheet.getRow(i);
				rowId = i + 1;
				if(row != null) {
//					if (row.getCell(stockNameIdx) == null){
//						logDataSb.append("ERROR - Row " + rowId + ", Stock Name cannot be blank \r\n");
//						rowError = true;
//					}
//
//					if (row.getCell(stockExchgIdx) == null){
//						logDataSb.append("ERROR - Row " + rowId + ", Stock Exchange cannot be blank \r\n");
//						rowError = true;
//					}

					if (row.getCell(stockSymIdx) == null){
						logDataSb.append("ERROR - Row " + rowId + ", Stock Symbol cannot be blank \r\n");
						rowError = true;
					}

					if (row.getCell(noOfShareIdx) == null){
						logDataSb.append("ERROR - Row " + rowId + ", No. of Share cannot be blank \r\n");
						rowError = true;
					} else if (!fmt.formatCellValue(row.getCell(noOfShareIdx)).matches(isNumberRegex)){
						logDataSb.append("ERROR - Row " + rowId + ", No. of Share should contain only numbers \r\n");
						rowError = true;
					}

					if (row.getCell(transPriceIdx) == null){
						logDataSb.append("ERROR - Row " + rowId + ", Transaction Price cannot be blank \r\n");
						rowError = true;
					} else if (!fmt.formatCellValue(row.getCell(transPriceIdx)).matches(priceRegex)){
						logDataSb.append("ERROR - Row " + rowId + ", Transaction Price format is invalid \r\n");
						rowError = true;
					}

					if (row.getCell(actionIdx) == null){
						logDataSb.append("ERROR - Row " + rowId + ", Action cannot be blank \r\n");
						rowError = true;
					} else if (!(fmt.formatCellValue(row.getCell(actionIdx)).equals(ACTION_BUY) || fmt.formatCellValue(row.getCell(actionIdx)).equals(ACTION_SELL))){
						logDataSb.append("ERROR - Row " + rowId + ", Action should be either BUY or SELL \r\n");
						rowError = true;
					}

					if (row.getCell(createdByIdx) == null){
						logDataSb.append("ERROR - Row " + rowId + ", Transacted By cannot be blank \r\n");
						rowError = true;
					} else if (!userService.checkUserExist(fmt.formatCellValue(row.getCell(createdByIdx)))) {
						logDataSb.append("ERROR - Row " + rowId + ", Transacted By user does not exist \r\n");
						rowError = true;
					}

					if (row.getCell(createdDtIdx) == null){
						logDataSb.append("ERROR - Row " + rowId + ", Transaction Created Date cannot be blank \r\n");
						rowError = true;
					} else if (!fmt.formatCellValue(row.getCell(createdDtIdx)).matches(dateRegex)){
						logDataSb.append("ERROR - Row " + rowId + ", Transaction Created Date format is invalid \r\n");
						rowError = true;
					}

					if (row.getCell(stockSymIdx) != null){
//						suffix = portfolioTransService.findSuffix(fmt.formatCellValue(row.getCell(stockExchgIdx)).toUpperCase());
//						 log.info("suffix: " + suffix);
//
//						 if(suffix != null) {
//							 stockSym = fmt.formatCellValue(row.getCell(stockSymIdx)).toUpperCase() + suffix;
//						 } else {
//							 stockSym = fmt.formatCellValue(row.getCell(stockSymIdx)).toUpperCase();
//						 }
						 //portfolioTrans.setStockSymbol(stockSym);
						 stockSym = fmt.formatCellValue(row.getCell(stockSymIdx)).toUpperCase();
						 StockWrapper stockWrapper = portfolioHoldService.findStock(stockSym);

						 if(stockWrapper == null || stockWrapper.getStock() == null) {
							 logDataSb.append("ERROR - Row " + rowId + ", Stock Symbol is invalid. \r\n");
							 rowError = true;
						 }
					}

				} else {
					logDataSb.append("ERROR - Row " + rowId + ", Loading fails because of blank rows. Please delete the blank rows after the last filed row by pressing 'Control', 'Shift', 'Down' and 'Delete'. \r\n");
					rowError = true;
				}
			}//end data validation

			if(rowError == false) {
				for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
					Row row = sheet.getRow(i);
					portTrans = new LoadPortfolioTrans();

					for (int j = 0;j < row.getLastCellNum(); j++) {//start of each row
						if (j == 0) {
							portTrans.setStockSymbol(fmt.formatCellValue(row.getCell(j)).toUpperCase());
						} else if (j == 1) {
							portTrans.setNoOfShare(Integer.parseInt(fmt.formatCellValue(row.getCell(j))));
						} else if (j == 2) {
							portTrans.setTransPrice(new BigDecimal(fmt.formatCellValue(row.getCell(j))));
						} else if (j == 3) {
							portTrans.setAction(fmt.formatCellValue(row.getCell(j)).toUpperCase());
						} else if (j == 4) {
							portTrans.setCreatedBy(fmt.formatCellValue(row.getCell(j)));
						} else if (j == 5) {
							portTrans.setCreatedDt(new SimpleDateFormat("dd/MM/yyyy").parse(fmt.formatCellValue(row.getCell(j))));
						} else if (j == 6) {
							portTrans.setRemarks(fmt.formatCellValue(row.getCell(j)));
						}
				    }//end of each row

					stockSym = portTrans.getStockSymbol();

					StockWrapper stockWrapper = portfolioHoldService.findStock(stockSym);

					exchgSuffmap.put(EXCHG_HKEX, RENAM_EXCHG_HKEX);
					exchgSuffmap.put(EXCHG_SGX, RENAM_EXCHG_SGX);
					exchgSuffmap.put(EXCHG_NYSE, RENAM_EXCHG_NYSE);
					exchgSuffmap.put(EXCHG_NYSE_ARCA, RENAM_EXCHG_NYSE);
					exchgSuffmap.put(EXCHG_OTC, RENAM_EXCHG_OTC);
					exchgSuffmap.put(EXCHG_NASDAQ, RENAM_EXCHG_NASDAQ);

					try {
						String stockName = stockWrapper.getStock().getName();
						String stockExchg = stockWrapper.getStock().getStockExchange();
//						BigDecimal lastTransPrice = stockWrapper.getStock().getQuote(true).getPrice();
//						log.info("Stock: " + stockSym + " Last Transacted Price: " + lastTransPrice);
//						stockMap.put(stockSym, lastTransPrice);
						stockList.add(stockSym);

						portTrans.setStockName(stockName);
						portTrans.setStockExchg(exchgSuffmap.get(stockExchg));
					} catch (Exception e) {
						logDataSb.append("ERROR - " + e + "\r\n");
						rowError = true;
						deleteRow = true;
						log.error(e.getMessage());
					}

					portTrans.setUploadId(id);

					portTransList.add(portTrans);
				}//end file processing

				try { //data persistence into database
					insertedRow = 0;

					Session session = HibernateUtil.getSessionFactory().openSession();
					Transaction transaction = session.beginTransaction();
					for(LoadPortfolioTrans trans : portTransList) {

						saveDto(trans);
						insertedRow++;

					}
					if(insertedRow > 0) {
						transaction.commit();
					} else {
						transaction.rollback();
					}


				}catch(Exception e){
					log.error(e.getMessage());
					throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
				}
			}
		} catch (Exception e) {
			log.error("", e);
			logDataSb.append("ERROR - Row " + rowNum + " " + e + "\r\n");
			rowError = true;
			deleteRow = true;
			log.error(e.getMessage());
		}

		//populate transactions data - call SP_PORT_TRANS_UPLOAD

		try{
			String errorMessage = "";
			if (rowError == false) {
				errorMessage = portTransUpload(id, portfolioName);
			}

			if (!errorMessage.isEmpty()){
				logDataSb.append("ERROR - \r\n" + errorMessage + "\r\n");
				rowError = true;
				deleteRow = true;
			} else {
				//update real time price
				for(String stock : stockList) {
					StockWrapper stockWrapper = portfolioHoldService.findStock(stock);
					try {
						BigDecimal lastTransPrice = stockWrapper.getStock().getQuote(true).getPrice();
						log.info("Stock: " + stock + " Last Transacted Price: " + lastTransPrice);
						portfolioHoldService.computeHoldingsJob(stock, lastTransPrice);
					} catch (Exception e) {
						log.error(e.getMessage());
						rowError = true;
						deleteRow = true;
					}
				}
			}
		} catch(Exception e) {
			log.error("portTransUpload SP error");
			logDataSb.append("ERROR - " + e + "\r\n");
			rowError = true;
			deleteRow = true;
			log.error("", e);
		}	finally{
			try{
				if (is != null)
					is.close();
			}
			catch (Exception e) {
				log.error("Error closing inputstream");
				log.error("", e);
			}
		}

		if(rowError == true) {
			dto.setStatus(FAILED);
			logDataSb.append("0 rows inserted \r\n");
			logDataSb.append("Job failed \r\n");
		} else {
			dto.setStatus(COMPLETED);
			logDataSb.append(insertedRow + " rows inserted\r\n");
			logDataSb.append("Job has been completed successfully \r\n");
			deleteRow = true;
		}

		Session session = HibernateUtil.getSessionFactory().openSession();

		logData = Hibernate.getLobCreator(session).createClob(logDataSb.toString());
		dto.setLogName(logName);
		dto.setLogData(logData);

		saveDto(dto);

//		if (deleteRow == true)
//			delFromPmsLoadPortTrans(id);
	}

	public LoadPortUpload getUploadId(Long id) {
		log.info("getUploadId in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT * FROM PMS_LOAD_PORT_UPLOAD where upload_id = :uploadId";

			NativeQuery sqlQuery = session.createSQLQuery(sql);

			sqlQuery.setParameter("uploadId",id);
			sqlQuery.addEntity(LoadPortUpload.class);

			LoadPortUpload upload = (LoadPortUpload) sqlQuery.uniqueResult();


			return upload;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	public void saveDto(Object object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		session.saveOrUpdate(object);

		transaction.commit();
		session.close();
	}

	public void delFromPmsLoadPortTrans(Long id){
		String sql = "delete from PMS_LOAD_PORT_TRANS where upload_id = :id";

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.createSQLQuery(sql).setParameter("id", id).executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public String portTransUpload(Long id, String portfolioName) {
		log.info("portTransUpload in DaoImpl..");

		String errorMsg = "";
		CallableStatement callableStatement = null;

			try {
				Session session = HibernateUtil.getSessionFactory().openSession();

				String callStoreProc = "{call SP_PORT_TRANS_UPLOAD(?,?,?)}";
				callableStatement = ((SessionImpl)session).connection().prepareCall(callStoreProc);
				callableStatement.setLong(1, id);
				callableStatement.setString(2, portfolioName);
				callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
				callableStatement.executeUpdate();
				errorMsg = callableStatement.getString(3) == null ? "" : callableStatement.getString(3);
				((SessionImpl)session).connection().commit();
			} catch (Exception e) {
				log.info(e.getMessage());
				throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
			}

		return errorMsg;
	}

	@Override
	public LoadPortUpload getHistFileById(Long id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT * FROM PMS_LOAD_PORT_UPLOAD where upload_id = :uploadId";

			NativeQuery sqlQuery = session.createSQLQuery(sql);

			sqlQuery.setParameter("uploadId",id);
			sqlQuery.addEntity(LoadPortUpload.class);

			LoadPortUpload upload = (LoadPortUpload) sqlQuery.uniqueResult();

			return upload;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			log.error(e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public void deleteUploadHist(List<Long> idList) {


		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			String sql = "delete from PMS_LOAD_PORT_UPLOAD where upload_id in (:idList)";

			NativeQuery query = session.createSQLQuery(sql);
			query.setParameterList("idList", idList);
			query.executeUpdate();

			transaction.commit();
			session.close();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

	@Override
	public long getUploadListCount() {
		log.info("getUploadListCount in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT count(*) FROM PMS_LOAD_PORT_UPLOAD order by UPLOAD_ID desc";

			SQLQuery sqlQuery = session.createSQLQuery(sql);

			long result = ((BigDecimal) sqlQuery.uniqueResult()).longValue();

			return result;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

}







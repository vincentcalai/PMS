package com.pms.pmsapp.dataloading.dao;

import com.pms.pmsapp.dataloading.data.LoadDiv;
import com.pms.pmsapp.dataloading.data.LoadDivUpload;
import com.pms.pmsapp.manageportfolio.dividend.data.Dividend;
import com.pms.pmsapp.manageportfolio.dividend.service.DividendService;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioHoldService;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioService;
import com.pms.pmsapp.sysadmin.service.UserService;
import com.pms.pmsapp.util.CommonUtils;
import com.pms.pmsapp.util.HibernateUtil;
import org.apache.poi.ss.usermodel.*;
import org.hibernate.*;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes2.HistoricalDividend;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.*;


@Repository
public class LoadDivDaoImpl implements LoadDivDao {

	private static final Logger log = LoggerFactory.getLogger(LoadDivDaoImpl.class);

	private final String STOCK_SYMBOL = "Stock Symbol";
	private final String NO_OF_SHARE = "No. of Share";
	private final String CURR_HOLD = "Currently Holding?";
	private final String PURCHASED_DATE = "Purchased Date";
	private final String SOLD_DATE = "Sold Date";
	private final String CREATED_BY = "Created By";

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

	private final String FAILED = "F";
	private final String COMPLETED = "C";
	private final String PENDING = "P";
	private final String YES = "Y";
	private final String NO = "N";

	private final String isNumberRegex = "\\d+";
	private final String priceRegex = "^\\d{0,8}(\\.\\d{1,3})?$";
	private final String dateRegex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

	@Autowired
	private PortfolioHoldService portfolioHoldService;

	@Autowired
	private PortfolioService portfolioService;

	@Autowired
	private UserService userService;

	@Autowired
	private DividendService dividendService;

	public List<LoadDivUpload> getUploadList(String portfolioName, Pageable pageable) {
		log.info("getUploadList in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT * FROM PMS_LOAD_DIV_UPLOAD order by UPLOAD_ID desc";

			SQLQuery sqlQuery = session.createSQLQuery(sql);

			sqlQuery.addEntity(LoadDivUpload.class);

			sqlQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
			sqlQuery.setMaxResults(pageable.getPageSize());

			List<LoadDivUpload> loadDivList = sqlQuery.list();

			return loadDivList;
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
			boolean stockSymHeader = fmt.formatCellValue(row.getCell(index++)).contains(STOCK_SYMBOL);
			boolean noOfShareHeader = fmt.formatCellValue(row.getCell(index++)).contains(NO_OF_SHARE);
			boolean currHoldHeader = fmt.formatCellValue(row.getCell(index++)).contains(CURR_HOLD);
			boolean purchasedDate = fmt.formatCellValue(row.getCell(index++)).contains(PURCHASED_DATE);
			boolean soldDate = fmt.formatCellValue(row.getCell(index++)).contains(SOLD_DATE);
			boolean createdBy = fmt.formatCellValue(row.getCell(index++)).contains(CREATED_BY);

			if(!stockSymHeader) {
				return -1;
			}
			if(!noOfShareHeader) {
				return -1;
			}
			if(!currHoldHeader) {
				return -1;
			}
			if(!purchasedDate) {
				return -1;
			}
			if(!soldDate) {
				return -1;
			}
			if(!createdBy) {
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

		LoadDivUpload dto = new LoadDivUpload();

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
		LoadDivUpload dto = getUploadId(id);
		String fileName = dto.getFileName();
		byte[] fileData = dto.getFileData();
		String logName = "output.log";
		Clob logData = null;

		String suffix = "";
		String stockSym = "";

		List<HistoricalDividend> dividendHist = null;
		Date divFromDate = null;
		Date divToDate = null;

		long rowNum = 0;
		int insertedRow = 0;
		int rowId = 0;

		boolean rowError = false;
		boolean rowListError = false;
		boolean deleteRow = false;

		Map<String, String> exchgSuffmap = new HashMap<String, String>();
		List<String> stockList = new ArrayList<String>();

		StringBuffer logDataSb = new StringBuffer();
		LoadDiv loadDiv = null;
		List<LoadDiv> loadDivList = new ArrayList<LoadDiv>();
		logName = fileName;
		InputStream is = null;

		try{
			is = new ByteArrayInputStream(fileData);
			Workbook wb = WorkbookFactory.create(is);
			Sheet sheet = wb.getSheetAt(0);
			DataFormatter fmt = new DataFormatter();

			int stockSymIdx = 0;
			int noOfShareIdx = 1;
			int currHoldIdx = 2;
			int datePurchased = 3;
			int dateSold = 4;
			int createdBy = 5;

			for(int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) { //start data validation
				Row row = sheet.getRow(i);
				rowId = i + 1;
				if(row != null) {

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

					if (row.getCell(currHoldIdx) == null){
						logDataSb.append("ERROR - Row " + rowId + ", Currently Holding cannot be blank \r\n");
						rowError = true;
					} else if (!(fmt.formatCellValue(row.getCell(currHoldIdx)).equals(YES) || fmt.formatCellValue(row.getCell(currHoldIdx)).equals(NO))){
						logDataSb.append("ERROR - Row " + rowId + ", Currently Holding format is invalid \r\n");
						rowError = true;
					}

					if (row.getCell(datePurchased) == null){
						logDataSb.append("ERROR - Row " + rowId + ", Purchased Date cannot be blank \r\n");
						rowError = true;
					} else if (!fmt.formatCellValue(row.getCell(datePurchased)).matches(dateRegex)){
						logDataSb.append("ERROR - Row " + rowId + ", Purchased Date format is invalid \r\n");
						rowError = true;
					}

					if (row.getCell(dateSold) == null && fmt.formatCellValue(row.getCell(currHoldIdx)).equals(NO)){
						logDataSb.append("ERROR - Row " + rowId + ", Sold Date cannot be blank if Current Holding Indicator is No \r\n");
						rowError = true;
					} else if (!fmt.formatCellValue(row.getCell(dateSold)).matches(dateRegex) && fmt.formatCellValue(row.getCell(currHoldIdx)).equals(NO)) {
						logDataSb.append("ERROR - Row " + rowId + ", Sold Date format is invalid \r\n");
						rowError = true;
					}

					if (row.getCell(createdBy) == null){
						logDataSb.append("ERROR - Row " + rowId + ", Created By cannot be blank \r\n");
						rowError = true;
					} else if (!userService.checkUserExist(fmt.formatCellValue(row.getCell(createdBy)))) {
						logDataSb.append("ERROR - Row " + rowId + ", Created By user does not exist \r\n");
						rowError = true;
					}

					if (row.getCell(stockSymIdx) != null){
						 stockSym = fmt.formatCellValue(row.getCell(stockSymIdx)).toUpperCase();
						 StockWrapper stockWrapper = portfolioHoldService.findStock(stockSym);

						 if(stockWrapper == null || stockWrapper.getStock() == null) {
							 logDataSb.append("ERROR - Row " + rowId + ", Stock Symbol is invalid. \r\n");
							 rowError = true;
						 }
					}

					//Date validation - Sold Date earlier than Purchase Date
					if(!fmt.formatCellValue(row.getCell(datePurchased)).equals("") && !fmt.formatCellValue(row.getCell(dateSold)).equals("")){
						Date pDate = new SimpleDateFormat("dd/MM/yyyy").parse(fmt.formatCellValue(row.getCell(datePurchased)));
						Date sDate = new SimpleDateFormat("dd/MM/yyyy").parse(fmt.formatCellValue(row.getCell(dateSold)));
						if(pDate.compareTo(sDate) > 0) {
							logDataSb.append("ERROR - Row " + rowId + ", Sold Date cannot be earlier than Purchase Date \r\n");
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
					loadDiv = new LoadDiv();
					String currHoldInd = "";

					for (int j = 0;j < row.getLastCellNum(); j++) {//start of each row
						if (j == 0) {
							loadDiv.setStockSym(fmt.formatCellValue(row.getCell(j)).toUpperCase());
						} else if (j == 1) {
							loadDiv.setNoOfShare(Integer.parseInt(fmt.formatCellValue(row.getCell(j))));
						} else if (j == 2) {
							loadDiv.setCurrHoldInd(fmt.formatCellValue(row.getCell(j)).toUpperCase());
							currHoldInd = fmt.formatCellValue(row.getCell(j)).toUpperCase();
						} else if (j == 3) {
							loadDiv.setDatePurchase(new SimpleDateFormat("dd/MM/yyyy").parse(fmt.formatCellValue(row.getCell(j))));
						} else if (j == 4) {
							if(currHoldInd.equals(YES)) {
								loadDiv.setDateSold(new Date());
							} else if (currHoldInd.equals(NO)&& !fmt.formatCellValue(row.getCell(j)).equals("")){
								loadDiv.setDateSold(new SimpleDateFormat("dd/MM/yyyy").parse(fmt.formatCellValue(row.getCell(j))));
							}
						} else if (j == 5) {
							loadDiv.setCreatedBy(fmt.formatCellValue(row.getCell(j)));
						}
				    }//end of each row

					stockSym = loadDiv.getStockSym();

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
						stockList.add(stockSym);

						loadDiv.setStockName(stockName);
						loadDiv.setStockExchg(exchgSuffmap.get(stockExchg));
					} catch (Exception e) {
						logDataSb.append("ERROR - " + e + "\r\n");
						rowError = true;
						deleteRow = true;
						log.error(e.getMessage());
					}

					loadDiv.setUploadId(id);

					loadDivList.add(loadDiv);
				}//end file processing

				try { //data persistence into database
					insertedRow = 0;

					long portId = portfolioService.getPortIdFromPortName(portfolioName);

					Session session = HibernateUtil.getSessionFactory().openSession();
					Transaction transaction = session.beginTransaction();
					for(LoadDiv div : loadDivList) {

						Dividend dividend = new Dividend();

						saveDto(div);
						insertedRow++;

						dividend.setPortId(portId);
						dividend.setNoOfShare(div.getNoOfShare());
						dividend.setStockSym(div.getStockSym());
						dividend.setStockExchg(div.getStockExchg());
						dividend.setStockName(div.getStockName());
						dividend.setDatePurchase(div.getDatePurchase());
						if(div.getCurrHoldInd() == YES) {
							dividend.setDateSold(new Date());
						} else {
							dividend.setDateSold(div.getDateSold());
						}

						dividend.setCurrHoldInd(div.getCurrHoldInd());
						dividend.setCreatedBy(div.getCreatedBy());
						long divRecId = dividendService.saveDivRec(dividend);

						try {
							divFromDate = div.getDatePurchase();
							divToDate = div.getDateSold();

							Stock stockObj = YahooFinance.get(div.getStockSym(), true);
							dividendHist = stockObj.getDividendHistory(
								CommonUtils.toCalendar(divFromDate), CommonUtils.toCalendar(divToDate));
						 } catch(Exception e) {
							e.printStackTrace();
							logDataSb.append("ERROR - Unable to retrieve stock symbol dividend details for " + div.getStockSym() + ".\r\n" + e + "\r\n");
						 }

						 if(dividendHist.size() != 0) {
							 for(HistoricalDividend rec :dividendHist) {
								 BigDecimal adjDiv = rec.getAdjDividend();
								 Date exDate = rec.getDate().getTime();
								 dividendService.populateDivRec(divRecId, exDate, adjDiv);
							 }
						 }

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

	}

	public LoadDivUpload getUploadId(Long id) {
		log.info("getUploadId in DaoImpl..");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT * FROM PMS_LOAD_DIV_UPLOAD where upload_id = :uploadId";

			NativeQuery sqlQuery = session.createSQLQuery(sql);

			sqlQuery.setParameter("uploadId",id);
			sqlQuery.addEntity(LoadDivUpload.class);

			LoadDivUpload upload = (LoadDivUpload) sqlQuery.uniqueResult();

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

	@Override
	public LoadDivUpload getHistFileById(Long id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			String sql = "SELECT * FROM PMS_LOAD_DIV_UPLOAD where upload_id = :uploadId";

			NativeQuery sqlQuery = session.createSQLQuery(sql);

			sqlQuery.setParameter("uploadId",id);
			sqlQuery.addEntity(LoadDivUpload.class);

			LoadDivUpload upload = (LoadDivUpload) sqlQuery.uniqueResult();

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

			String sql = "SELECT count(*) FROM PMS_LOAD_DIV_UPLOAD order by UPLOAD_ID desc";

			SQLQuery sqlQuery = session.createSQLQuery(sql);

			long result = ((BigDecimal) sqlQuery.uniqueResult()).longValue();

			return result;
		} catch (Exception e) {
			// convert to HibernateException then to DataAccessException
			throw SessionFactoryUtils.convertHibernateAccessException(new HibernateException(e.getMessage()));
		}
	}

}







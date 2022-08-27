package com.pms.pmsapp.manageportfolio.portfolio.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;
import com.pms.pmsapp.manageportfolio.portfolio.repository.PortfolioRepository;
import com.pms.pmsapp.manageportfolio.portfolio.repository.dao.PortfolioDao;
import com.pms.pmsapp.manageportfolio.portfolio.web.PortfolioForm;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	private static final Logger log = LoggerFactory.getLogger(PortfolioServiceImpl.class);

	@Autowired
	private PortfolioDao portfolioDao;

	@Autowired
	private PortfolioRepository portfolioRepository;

	public List<Portfolio> findAll(Pageable pageable) {
		log.info("findAll in ServiceImpl");
		return portfolioRepository.findAll();
	}

	public List<String> findAllPortfolioNames() {
		List<Portfolio> portfolioList = portfolioRepository.findAll();
		List<String> portfolioNameList = new ArrayList<>();
		portfolioList.forEach(portfolio -> portfolioNameList.add(portfolio.getPortfolioName()));
		return portfolioNameList;
	}

	public PortfolioForm addPortfolio(PortfolioForm portfolioForm, String username) {

		boolean portfolioExist = false;
		String portfolioName = portfolioForm.getPortfolioName();

		if (username != null) {
			portfolioForm.setCreatedBy(username);
			portfolioForm.setLastMdfyBy(username);
		}

		log.info("addPortfolio in Controller.. ");
		log.info("portfolioForm:  " + portfolioName);

		Long portfolioCount = checkPortfolioExist(portfolioName);
		portfolioExist = portfolioCount > 0 ? true : false;

		if (portfolioExist) {
			portfolioForm.setErrMsg("Portfolio name already exist. Please create portfolio with different name.");
		} else {

			Portfolio portfolio = new Portfolio();
			portfolio.setPortfolioName(portfolioName);
			portfolio.setCreatedBy(portfolioForm.getCreatedBy());
			portfolio.setCreatedDate(new Date());
			portfolio.setLastMdfyBy(portfolioForm.getLastMdfyBy());
			portfolio.setLastMdfyDt(new Date());
			portfolio.setRemarks(portfolioForm.getRemarks());

			portfolioRepository.save(portfolio);

			portfolioForm.setSystemMsg("Portfolio added Successfully.");
		}

		return portfolioForm;

	}

	public PortfolioForm updatePortfolio(PortfolioForm portfolioForm, String username) throws NoSuchElementException {

		boolean portfolioExist = false;
		Long portfolioId = portfolioForm.getId();
		String portfolioName = portfolioForm.getPortfolioName();

		if (username != null) {
			portfolioForm.setCreatedBy(username);
			portfolioForm.setLastMdfyBy(username);
		}

		Long portfolioCount = checkPortfolioExist(portfolioId, portfolioName);
		portfolioExist = portfolioCount > 0 ? true : false;

		if (portfolioExist) {
			portfolioForm.setErrMsg("Portfolio name already exist. Please update portfolio with different name.");
		} else {
			Portfolio portfolio = portfolioRepository.findById(portfolioId).get();
			portfolio.setPortfolioName(portfolioName);
			portfolio.setCreatedBy(portfolioForm.getCreatedBy());
			portfolio.setLastMdfyBy(portfolioForm.getLastMdfyBy());
			portfolio.setLastMdfyDt(new Date());
			portfolio.setRemarks(portfolioForm.getRemarks());

			portfolioRepository.save(portfolio);
			portfolioForm.setSystemMsg("Portfolio updated successfully.");
		}

		return portfolioForm;
	}

	public void deletePortfolio(long id) {
		portfolioDao.deletePortfolio(id);
	}

	public Long checkPortfolioExist(String portfolioName) {
		return portfolioRepository.countByPortfolioName(portfolioName);
	}

	public Long checkPortfolioExist(Long portfolioId, String portfolioName) {
		return portfolioRepository.checkPortfolioExist(portfolioId, portfolioName);
	}

	@Override
	public long findAllCount() {
		return portfolioRepository.count();
	}

	@Override
	public long getPortIdFromPortName(String portfolioName) {
		Portfolio portfolio = portfolioRepository.findByPortfolioName(portfolioName);
		return portfolio.getId();
	}

}

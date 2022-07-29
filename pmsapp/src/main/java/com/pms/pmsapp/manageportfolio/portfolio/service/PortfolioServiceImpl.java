package com.pms.pmsapp.manageportfolio.portfolio.service;

import java.util.Date;
import java.util.List;

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
		return portfolioDao.findAll(pageable);
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

		portfolioExist = checkPortfolioExist(portfolioName);
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

			// portfolioDao.addPortfolio(portfolioForm);
			portfolioRepository.save(portfolio);

			portfolioForm.setSystemMsg("Portfolio added Successfully.");
		}

		return portfolioForm;

	}

	public PortfolioForm updatePortfolio(PortfolioForm portfolioForm, String username) {

		boolean portfolioExist = false;
		Long portfolioId = portfolioForm.getId();
		String portfolioName = portfolioForm.getPortfolioName();

		if (username != null) {
			portfolioForm.setCreatedBy(username);
			portfolioForm.setLastMdfyBy(username);
		}

		portfolioExist = checkPortfolioExist(portfolioId, portfolioName);

		if (portfolioExist) {
			portfolioForm.setErrMsg("Portfolio name already exist. Please update portfolio with different name.");
		} else {
			Portfolio portfolio = new Portfolio();
			portfolio.setId(portfolioId);
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

	public boolean checkPortfolioExist(String portfolioName) {
		return portfolioDao.checkPortfolioExist(portfolioName);
	}

	public boolean checkPortfolioExist(Long portfolioId, String portfolioName) {
		return portfolioDao.checkPortfolioExist(portfolioId, portfolioName);
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

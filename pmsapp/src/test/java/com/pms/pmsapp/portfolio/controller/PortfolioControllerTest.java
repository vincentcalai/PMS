package com.pms.pmsapp.portfolio.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pms.pmsapp.manageportfolio.portfolio.controller.PortfolioController;
import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;
import com.pms.pmsapp.manageportfolio.portfolio.service.PortfolioService;
import com.pms.pmsapp.util.jwt.JwtTokenUtil;
import com.pms.pmsapp.util.jwt.JwtUnAuthorizedResponseAuthenticationEntryPoint;


@WebMvcTest(value = PortfolioController.class)
class PortfolioControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
//	@InjectMocks
//    PortfolioController portfolioController;
	
	@MockBean
	private PortfolioService portfolioService;
	
	@MockBean
	private JwtUnAuthorizedResponseAuthenticationEntryPoint jwtUnAuthorizedResponseAuthenticationEntryPoint;
	
	@MockBean
	private UserDetailsService userDetailsService;
	
	@MockBean
	private JwtTokenUtil jwtTokenUtil;
	

	@Test
	public void testFindAll() throws Exception {
		
		Date todayDate = new Date();
		
		Pageable pageable = PageRequest.of(0, 3);
		
		List<Portfolio> list = new ArrayList<Portfolio>();
		list.add(0, new Portfolio(Long.valueOf(1), "USA Portfolio", "testuser1", todayDate, "testuser1", todayDate, "remarks 1", "", ""));
		list.add(1, new Portfolio(Long.valueOf(2), "China Portfolio", "testuser2", todayDate, "testuser2", todayDate, "remarks 2", "", ""));
		list.add(2, new Portfolio(Long.valueOf(3), "SG Portfolio", "testuser3", todayDate, "testuser3", todayDate, "remarks 3", "", ""));
		
		long totalRec = 4;
		
		Mockito.when(portfolioService.findAll(pageable)).thenReturn(list);
		Mockito.when(portfolioService.findAllCount()).thenReturn(totalRec);
		
		String url = "/portfolio";
		
		mockMvc.perform(MockMvcRequestBuilders.get(url)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
	
	}
	
	@Test
	public void testAddPortfolio() throws Exception {
		
		Date todayDate = new Date();
		
		Portfolio portfolio = new Portfolio(Long.valueOf(1), "USA Portfolio", "testuser1", todayDate, "testuser1", todayDate, "remarks 1", "", "");

		Mockito.doNothing().when(portfolioService).addPortfolio(portfolio);

	    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/portfolio/add")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(this.objectMapper.writeValueAsString(portfolio));

	    mockMvc.perform(mockRequest)
	            .andExpect(MockMvcResultMatchers.status().isOk());
		
	}

}

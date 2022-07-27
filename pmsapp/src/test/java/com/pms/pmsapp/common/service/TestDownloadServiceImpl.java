package com.pms.pmsapp.common.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.rowset.serial.SerialClob;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletResponse;

import com.pms.pmsapp.TestWithSpringBoot;
import com.pms.pmsapp.dataloading.data.LoadPortUpload;
import com.pms.pmsapp.dataloading.service.LoadPortfolioService;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class TestDownloadServiceImpl extends TestWithSpringBoot {

	@InjectMocks
	private DownloadServiceImpl downloadServiceImpl;

	@Mock
	private LoadPortfolioService loadPortfolioService;

	private LoadPortUpload loadPortUploadObj1;
	private LoadPortUpload loadPortUploadObj2;

	@BeforeAll
	public void setup() throws Exception {

		loadPortUploadObj1 = new LoadPortUpload(1, "Test Portfolio 1", "Test Data 1".getBytes(), "Test File 1",
				new SerialClob("Test CLOB data 1".toCharArray()), "Test Log File 1", "user1", new Date(), "C", "N");
		loadPortUploadObj2 = new LoadPortUpload(2, "Test Portfolio 2", "Test Data 2".getBytes(), "Test File 2", null,
				"Test Log File 2", "user2", new Date(), "F", "N");

	}

	@AfterAll
	public void teardown() throws Exception {

	}

	@Test
	public void testHandleLoadPortTrans() throws UnsupportedEncodingException {

		MockHttpServletResponse response = new MockHttpServletResponse();

		when(loadPortfolioService.getHistFileById(anyLong())).thenReturn(loadPortUploadObj1);

		downloadServiceImpl.handleLoadPortTrans(1L, response);

		String output = response.getContentAsString();
		assertFalse(StringUtils.isBlank(output));
	}

	@Test
	public void testHandleLoadPortTransLog() throws UnsupportedEncodingException, SQLException {

		MockHttpServletResponse response = new MockHttpServletResponse();

		when(loadPortfolioService.getHistFileById(anyLong())).thenReturn(loadPortUploadObj2);

		downloadServiceImpl.handleLoadPortTransLog(2L, response);

//		String output = response.getContentAsString();
//		assertFalse(StringUtils.isBlank(output));
	}

	@Test
	public void testHandleGenTransReport() {
		MockHttpServletResponse response = new MockHttpServletResponse();

		// when(loadPortfolioService.getHistFileById(anyLong())).thenReturn(loadPortUploadObj2);

		downloadServiceImpl.handleGenTransReport(3L, response);
	}
}

package com.pms.pmsapp.common.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pms.pmsapp.common.data.MktExchg;
import com.pms.pmsapp.common.repository.MktExchgRepository;
import com.pms.pmsapp.fixture.MktExchgFixture;

@DataJpaTest
//@ContextConfiguration(classes = { PmsappApplication.class })
@TestInstance(Lifecycle.PER_CLASS)
public class TestMktExchgRepository {

	private List<MktExchg> mktExchgList;

	@Autowired
	private MktExchgRepository mktExchgRepository;

	@BeforeAll
	public void setup() throws Exception {

		mktExchgList = MktExchgFixture.createMktExchgListFixture();

		mktExchgRepository.saveAll(mktExchgList);

	}

	@AfterAll
	public void teardown() throws Exception {
		mktExchgRepository.deleteAll();
	}

	@Test
	public void testFindByMktExchgName_ShouldReturnSISuffix() {
		String stockExchg = "SGX";

		MktExchg mktExchg = mktExchgRepository.findByMktExchgName(stockExchg);

		assertEquals(mktExchg.getSuffix(), ".SI");
	}

	@Test
	public void testFindByMktExchgName_ShouldReturnNull() {
		String stockExchg = "NASDAQ";

		MktExchg mktExchg = mktExchgRepository.findByMktExchgName(stockExchg);

		assertEquals(mktExchg.getSuffix(), null);
	}

}

package com.pms.pmsapp.common.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.pms.pmsapp.PmsappApplication;
import com.pms.pmsapp.common.data.Index;
import com.pms.pmsapp.common.repository.ForexRepository;
import com.pms.pmsapp.common.repository.IndexRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = { HomeDaoImpl.class, PmsappApplication.class })
@TestInstance(Lifecycle.PER_CLASS)
public class HomeDaoImplTest {

	@Autowired
	HomeDaoImpl homeDaoImpl;

	@Autowired
	IndexRepository indexRespository;

	@Autowired
	ForexRepository forexRespository;

	@BeforeAll
	public void init() throws Exception {
		Index index = new Index(null, "^GSPC", "S&P 500", new BigDecimal(3911.74), new BigDecimal(116.01),
				new BigDecimal(3.06), new Date());
		indexRespository.save(index);
	}

	@AfterAll
	public void teardown() throws Exception {
		indexRespository.deleteAll();
	}

	@Test
	public void testFindAllIndex_ShouldReturnThreeResult() {

		List<Index> indexes = indexRespository.findAllIndex();
		assertEquals(1, indexes.size());
	}

}

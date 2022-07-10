package com.pms.pmsapp.common.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.pms.pmsapp.PmsappApplication;
import com.pms.pmsapp.common.data.Index;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = { HomeDaoImpl.class, PmsappApplication.class })
public class HomeDaoImplTest {

//	@Autowired
//	HomeDaoImpl homeDaoImpl;

	@Autowired
	HomeDaoImpl homeDaoImpl;

	@Autowired
	IndexRepository indexRespository;

	@Autowired
	ForexRepository forexRespository;

	@BeforeAll
	public static void init() throws Exception {

	}

	@Test
	public void testFindAllIndex_ShouldReturnThreeResult() {
		Index index = new Index(null, "^GSPC", "S&P 500", new BigDecimal(3911.74), new BigDecimal(116.01),
				new BigDecimal(3.06), new Date());
		indexRespository.save(index);

		List<Index> indexes = indexRespository.findAllIndex();
		assertEquals(1, indexes.size());
	}

}

package com.bonc.cron.cronTest;

import com.bonc.cron.cronTest.ceainject.dao.CEADao;
import com.bonc.cron.cronTest.ceainject.entity.CEAInfoPO;
import com.bonc.cron.cronTest.ceainject.entity.CEAInfoVO;
import com.bonc.cron.cronTest.ceainject.service.CEAService;
import com.bonc.cron.cronTest.result.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CornTestApplicationTests {

	@Autowired
	CEAService ceaService;

	@Autowired
	CEADao ceaDao;

	@Test
	void contextLoads() {

		Result<List<CEAInfoVO>> result = ceaService.getAllCEA();

		List<CEAInfoVO> resultData = result.getData();

		for (CEAInfoVO resultDatum : resultData) {
			System.out.println(resultDatum);
		}

	}

}

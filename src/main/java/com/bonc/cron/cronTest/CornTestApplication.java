package com.bonc.cron.cronTest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = "com.bonc.corn.cornTest.test.mapper")
public class CornTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CornTestApplication.class, args);
	}

}

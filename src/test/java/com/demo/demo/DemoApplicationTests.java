package com.demo.demo;

import com.demo.spring.DemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = DemoApplication.class)
@Transactional
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		// Add any necessary setup here
	}

	@Test
	public void testSparkSessionCreation() {
		// This test specifically checks SparkSession creation
		// You might need to mock or stub SparkSession creation here
	}
}


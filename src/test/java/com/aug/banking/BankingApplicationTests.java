package com.aug.banking;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class BankingApplicationTests {

	@Test
	void contextLoads() {
		long nombre = (long)Math.random()*((10000-0)+1);
		System.out.println("nombre "+nombre);
		assert(true);
	}

}

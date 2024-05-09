package com.fashionboutique.fashionstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestFashionStoreApplication {

	public static void main(String[] args) {
		SpringApplication.from(FashionStoreApplication::main).with(TestFashionStoreApplication.class).run(args);
	}

}

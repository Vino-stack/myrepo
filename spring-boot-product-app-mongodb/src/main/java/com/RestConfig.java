package com;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages={"com.atossyntel.cms.rest.controller"})
@Configuration
public class RestConfig {

	public RestConfig() {
		System.out.println("Rest Config created...");
	}
	
}

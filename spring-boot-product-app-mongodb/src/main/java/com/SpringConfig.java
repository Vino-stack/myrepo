package com;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages={"com.atossyntel.cms.spring.controller"})
@Configuration
public class SpringConfig {

	public SpringConfig() {
		System.out.println("Spring Config created...");
	}
	
}

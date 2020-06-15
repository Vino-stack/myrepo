package com.example.DbspringApp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages={"com.example.DbspringApp.controller"})
@Configuration
public class SpringConfig {

	public SpringConfig() {
		System.out.println("Spring Config created...");
	}
	
}

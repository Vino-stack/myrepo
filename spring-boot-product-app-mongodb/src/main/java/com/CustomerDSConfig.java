package com;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class CustomerDSConfig {
	
	public CustomerDSConfig() {
	System.out.println("####  CustomerDSConfig  created###");
	}

	
	@Bean
    public ServletRegistrationBean spring() {
        
		
		System.out.println("spring ds registered.....");
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet();   
      
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
                
	    applicationContext.register(SpringConfig.class);
	    
	   
		
        dispatcherServlet.setApplicationContext(applicationContext);
        
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/spring/*");
       
        servletRegistrationBean.setName("spring");
        return servletRegistrationBean;
    }
    @Bean
    public ServletRegistrationBean rest() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
    	System.out.println("rest  ds registered.....");
    	
        
    	applicationContext.register(RestConfig.class);
	    dispatcherServlet.setApplicationContext(applicationContext);
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/rest/*");
        servletRegistrationBean.setName("rest");
        return servletRegistrationBean;
    }

	
	
	
	
	
	
}

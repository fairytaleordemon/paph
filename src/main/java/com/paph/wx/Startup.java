package com.paph.wx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.yuanbosu.common.error.ErrorHandlerFilter;




@ComponentScan
@EnableAutoConfiguration
@EnableAsync
@EnableScheduling
public class Startup implements CommandLineRunner {
	
	Logger log = LoggerFactory.getLogger(Startup.class);
	
//	SalesInfoService sis = new SalesInfoServiceImpl();

	
	//@Bean
	public FilterRegistrationBean ErrorFilterRegistration () {
	    
		ErrorHandlerFilter filter = new ErrorHandlerFilter();
	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    
	    registration.setFilter(filter); 
	    registration.addUrlPatterns("*.json");
	   
	    
	    return registration ;
	}
	


	
	
	@Override
	public void run(String... arg0) throws Exception {
		log.info("[server]启动啦 ---------------------------");
		
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Startup.class, args);
		
	}
}

package com.haly.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MyConfiguration extends WebMvcConfigurationSupport {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
	    super.addCorsMappings(registry);
	    registry
	    		.addMapping("/user/**")
	            .allowedHeaders("*")
	            .allowedMethods("POST","GET")
	            .allowCredentials(false).maxAge(3600)
	            .allowedOrigins("*");
	}
}

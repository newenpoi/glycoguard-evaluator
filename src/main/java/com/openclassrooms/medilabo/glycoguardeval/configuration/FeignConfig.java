package com.openclassrooms.medilabo.glycoguardeval.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignConfig {
	
	@Bean
	public BasicAuthRequestInterceptor mBasicAuthRequestInterceptor()
	{
		return new BasicAuthRequestInterceptor("newenpoi", "azerty");
	}
}

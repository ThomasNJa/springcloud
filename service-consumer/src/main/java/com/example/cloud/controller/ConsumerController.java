package com.example.cloud.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@Configuration
public class ConsumerController {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping(value="/call/{id}")
	public String getPerson(@PathVariable String id) {
		String str = getRestTemplate().getForObject("http://service-provider/call/" + id, String.class);
		return str;
	}

}

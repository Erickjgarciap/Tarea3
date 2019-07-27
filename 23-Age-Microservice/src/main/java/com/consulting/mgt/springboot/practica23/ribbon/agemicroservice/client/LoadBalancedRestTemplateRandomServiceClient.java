package com.consulting.mgt.springboot.practica23.ribbon.agemicroservice.client;

import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Profile("load-balanced-rest-template")
public class LoadBalancedRestTemplateRandomServiceClient implements IRandomService{
	
	@Autowired
	private RestTemplate loadBalancedRestTemplate;
	
	
	 
	@Value("${ramdon-service-name:random-microservice}")
	private String serviceName;
	
	@Override
	@SneakyThrows
	public int getRandomValue() {
		// TODO Auto-generated method stub
		URI uri = new URI("http://" + serviceName +"/random-service/next");
		System.out.println("eee -----> " + uri.toString());
		Map<String, Object> mapResponse = loadBalancedRestTemplate.getForObject(uri, Map.class);
		log.info( "yyyyyy");
		log.info("load balanced {} response: {}", serviceName, mapResponse);
		return (int) mapResponse.get("random");
	}

}

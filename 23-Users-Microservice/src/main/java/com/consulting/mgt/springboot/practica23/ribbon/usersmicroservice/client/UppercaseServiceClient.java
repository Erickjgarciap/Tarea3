package com.consulting.mgt.springboot.practica23.ribbon.usersmicroservice.client;

import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Primary
//@Profile("balanced")
public class UppercaseServiceClient implements IUppercaseService {

	@Autowired
	private RestTemplate loadBalancedRestTemplate;

	@Value("${uppercase-service-name:uppercase-microservice}")
	private String serviceName;

	@Override
	@SneakyThrows
	public String toUppercase(String name) {

		// build URI using service-name
	      String decoded = URLDecoder.decode(name, "UTF-8");
	      log.info("load balanced " + decoded);
		URI uri = new URI("http://" + serviceName + "/uppercase-service/toUppercase/" + name);

		// getting map from loadBalanced RestTemplate
		String url = URLDecoder.decode(uri.toString(), "UTF-8");
		
		Map<String, Object> mapResponse = loadBalancedRestTemplate.getForObject(url, Map.class);

		log.info( "xxxxxx");
		log.info("load balanced {} response: {}", serviceName, mapResponse);

		return (String) mapResponse.get("uppercase");
	}

}

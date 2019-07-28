package com.consulting.mgt.springboot.practica23.ribbon.usersmicroservice.client;

import java.net.URI;
import java.net.URLDecoder;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
//@Primary
public class ApiRibonUpperCaseServiceCliente  implements IUppercaseService {
	
	

	private RestTemplate simpleresttemplate = new RestTemplate();
	
	@Autowired
	private LoadBalancerClient loadBalancer;

	@Value("${uppercase-service-name:uppercase-microservice}")
	private String serviceName;

	@Override
	@SneakyThrows
	public String toUppercase(String name) {
		// TODO Auto-generated method stub
		ServiceInstance instance = loadBalancer.choose(serviceName);
	    String decoded = URLDecoder.decode(name, "UTF-8");
	      log.info("load balanced " + decoded);
		URI uri = new URI(
				
			String.format("http://%s:%s/uppercase-service/toUppercase/%s",
					instance.getHost(),instance.getPort(),decoded));
		
			System.out.println(uri.toString());
			Map<String, Object> mapResponse = simpleresttemplate.getForObject(uri, Map.class);	
			
			log.info("[api ribbon]{} response: {}", serviceName, mapResponse);
			return (String) mapResponse.get("uppercase");
			
	}

}

package com.consulting.mgt.springboot.practica23.ribbon.agemicroservice.client;

import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Profile("ribbon-api")
public class RibbonApiRandomServiceClient implements IRandomService{
	
	
private RestTemplate simpleresttemplate = new RestTemplate();
	
@Autowired
private LoadBalancerClient loadBalancer;

	@Value("${ramdon-service-name:random-microservice}")
	private String serviceName;
	
	@Override
	@SneakyThrows
	public int getRandomValue() {
		// TODO Auto-generated method stub
		ServiceInstance instance = loadBalancer.choose(serviceName);
		URI uri = new URI(
				
				String.format("http://%s:%s/random-service/next",
						instance.getHost(),instance.getPort()));
		System.out.println(uri.toString());
		Map<String, Object> mapResponse = simpleresttemplate.getForObject(uri, Map.class);	
		log.info( "xxxxxx");
		log.info(" [api ribbon]random load balanced {} response: {}", serviceName, mapResponse);
		return (int) mapResponse.get("random");
	}

}

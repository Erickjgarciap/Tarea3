package com.consulting.mgt.springboot.practica23.ribbon.uppercasemicroservice.restcontroller;

import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.mgt.springboot.practica23.ribbon.uppercasemicroservice.MyListener;
import com.consulting.mgt.springboot.practica23.ribbon.uppercasemicroservice.service.UppercaseService;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ToUppercaseRestController {

	@Autowired
	private UppercaseService uppercaseService;
	@Autowired
	private Environment env;
	@SneakyThrows
	@GetMapping("/toUppercase/{name}")
	public Map<String, Object> toUppercase(@PathVariable String name) {

		log.info("sending toUppercase");

		Map<String, Object> map = new LinkedHashMap<>();
	      String decoded = URLDecoder.decode(name, "UTF-8");
		map.put("uppercase", uppercaseService.toUppercase(decoded));
		map.put("from", "http://" + env.getProperty("spring.application.name") + ":" + MyListener.APPLICATION_PORT);

		return map;
	}
}

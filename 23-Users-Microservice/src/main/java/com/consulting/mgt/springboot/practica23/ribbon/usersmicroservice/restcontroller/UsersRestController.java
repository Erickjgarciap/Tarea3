package com.consulting.mgt.springboot.practica23.ribbon.usersmicroservice.restcontroller;

import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.mgt.springboot.practica23.ribbon.usersmicroservice.model.User;
import com.consulting.mgt.springboot.practica23.ribbon.usersmicroservice.service.UsersService;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UsersRestController {

	@Autowired
	private UsersService userService;

	@SneakyThrows
	@GetMapping("/{name}")
	public User users(@PathVariable String name) {

		
		
		
		
		log.info("Sending User");
	      String decoded = URLDecoder.decode(name, "UTF-8");
	      log.info("aaaaaaa ------> " + decoded);
		return userService.getUser(decoded);
	}
}

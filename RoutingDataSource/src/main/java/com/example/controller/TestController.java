package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.RoutingDataSouceImpl;
import com.example.model.User;
import com.example.service.UserServer;

@RestController
public class TestController {
	
	private static Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private UserServer userServer;
	
	@GetMapping("/getRead")
	public List<User> getRead(){
		log.info("controller getRead");
		return userServer.getRead();
	}
	
	@GetMapping("/getWrite")
	public List<User> getWrite(){
		log.info("controller getWrite");
		return userServer.getWrite();
	}
}

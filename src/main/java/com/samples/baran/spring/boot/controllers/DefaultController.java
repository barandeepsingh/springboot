package com.samples.baran.spring.boot.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/default")
public class DefaultController {
	private Logger log = LoggerFactory.getLogger(DefaultController.class);
	@GetMapping("/getAuthorName")
	public String getAuthorName() {
		log.info("Calling endpoint getAuthorName");
		return "Barandeep Singh";
	}
}

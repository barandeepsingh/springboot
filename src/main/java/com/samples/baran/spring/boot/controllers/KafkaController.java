package com.samples.baran.spring.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samples.baran.spring.boot.service.kafka.KafkaProducerService;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {
	@Autowired
	private KafkaProducerService producerService;

	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
		this.producerService.sendMessage(message);
	}

}

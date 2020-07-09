package com.samples.baran.spring.boot.service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	private static final Logger log = LoggerFactory.getLogger(KafkaProducerService.class);
	private final String TOPIC = "spring_boot";
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		log.info("Sending message " + message);
		this.kafkaTemplate.send(TOPIC, message);

	}

}

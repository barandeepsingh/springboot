package com.samples.baran.spring.boot.service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumerService.class);

	@KafkaListener(topics = "spring_boot", groupId = "springBootGroup")
	public void consume(String message) {
		log.info(String.format("$$ -> Consumed Message -> %s", message));
	}

}

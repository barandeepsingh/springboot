package com.samples.baran.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.samples.baran.spring.boot.service.MessageService;

@SpringBootApplication
public class SpringBootPocsApplication {
	@Autowired
	private MessageService messageService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPocsApplication.class, args);
	}

	@Scheduled(fixedRateString = "${scheduledtask.delay}")
	void processMessages() {
		messageService.getAllMessagesToProcess().forEach(System.out::println);
	}
	@Scheduled(fixedRateString = "${scheduledtask.clearcache.delay}")
	void clearingMessageCacge() {
		System.out.println("Clearing cache");
		messageService.messageCache.clear();
	}
	
}

@Configuration
@EnableScheduling
//@ConditionalOnProperty(name="scheduling.enabled",matchIfMissing = true)
class MyScheduledTasks {

}
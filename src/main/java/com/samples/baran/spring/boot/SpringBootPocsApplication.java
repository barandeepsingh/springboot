package com.samples.baran.spring.boot;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.samples.baran.spring.boot.service.MessageService;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SpringBootApplication
public class SpringBootPocsApplication {
	Logger log = LoggerFactory.getLogger(SpringBootPocsApplication.class);
	@Autowired
	private MessageService messageService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPocsApplication.class, args);
	}

	@Scheduled(fixedRateString = "${scheduledtask.delay}")
	void processMessages() {
		messageService.getAllMessagesToProcess().forEach(log::info);
	}

	@Scheduled(fixedRateString = "${scheduledtask.clearcache.delay}")
	void clearingMessageCacge() {
		log.info("Clearing cache");
		messageService.getMessageCache().clear();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				// .apis(RequestHandlerSelectors.any())
				// .paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.samples.baran.spring.boot.controllers"))
				.paths(PathSelectors.ant("/api/*")).build().apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("Spring boot poc", "Spring boot poc description", "1.0", "Free to use",
				new springfox.documentation.service.Contact("Barandeep Singh", "http://github.com/barandeepsingh",
						"barandeepsingh@gmail.com"),
				"API License", "https://github.com/barandeepsingh", Collections.emptyList());
	}
}

@Configuration
@EnableScheduling
//@ConditionalOnProperty(name="scheduling.enabled",matchIfMissing = true)
class MyScheduledTasks {

}
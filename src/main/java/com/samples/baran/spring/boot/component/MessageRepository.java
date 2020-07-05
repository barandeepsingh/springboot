package com.samples.baran.spring.boot.component;

import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class MessageRepository {

	public Stream<String> getMessages() {
		return Stream.of("Message1", "Message2", "Message3");
	}

}

package com.samples.baran.spring.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samples.baran.spring.boot.component.MessageRepository;

@Service
public class MessageService {
	public List<String> messageCache = new ArrayList<>();
	@Autowired
	private MessageRepository repo;

	public Stream<String> getAllMessagesToProcess() {
		return repo.getMessages().filter(checkIfMessageProcessed).collect(Collectors.toList()).stream();
	}

	private final Predicate<String> checkIfMessageProcessed = message -> {
		AtomicBoolean result = new AtomicBoolean();
		if (messageCache.contains(message)) {
			System.out.println("Message present in cache " + message);
			result.set(true);
		} else {
			messageCache.add(message);
			System.out.println("Message is not present in cache " + message);
			result.set(false);
		}
		return !result.get();
	};
}

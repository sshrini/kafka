package com.sudeep.kafka.sender;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkaSender {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	//String kafkaTopic = "kafka-remote-test-topic";
	
	public void send(String message) {
	    
	    kafkaTemplate.sendDefault(message);
	}
}

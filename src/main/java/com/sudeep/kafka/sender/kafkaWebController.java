package com.sudeep.kafka.sender;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sudeep.kafka.reciever.*;
@RestController
@RequestMapping(value = "/kafka-send/")
public class kafkaWebController {
	@Autowired
	kafkaSender kafkasender;
	@Autowired
	kafkaReciever kafkareciever;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) throws Exception{
		kafkasender.send(message);
 
		return "Message sent to the Kafka Topic test-kafka-topic Successfully";
	}
	
	@GetMapping(value = "/reciever")
	public String reciever() throws Exception{
		kafkareciever.getLatch().await(10000, TimeUnit.MILLISECONDS);
		return kafkareciever.getPayload();
	}
}


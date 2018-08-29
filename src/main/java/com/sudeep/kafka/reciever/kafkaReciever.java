package com.sudeep.kafka.reciever;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaReciever {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(kafkaReciever.class);
 private String payload;
  private CountDownLatch latch = new CountDownLatch(1);

  public CountDownLatch getLatch() {
    return latch;
  }

  @KafkaListener(topics = "${kafka.topic.helloworld}")
  public void receive(String payload) {
    LOGGER.info("received payload='{}'", payload);
    this.payload=payload;
    latch.countDown();
  }
  public String getPayload()
  {
	  return this.payload;
  }
}
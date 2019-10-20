package com.bartoszgajda.springkafka;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class CollectionSocketHandler extends AbstractWebSocketHandler {
  private static final Logger logger = Logger.getLogger(CollectionSocketHandler.class.getName());
  private final KafkaProducer kafkaProducer;

  public CollectionSocketHandler(KafkaProducer kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  @Override
  public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
    logger.log(Level.INFO, "New RSVP:\n {0}", message.getPayload());
    kafkaProducer.sendMessage(message);
  }
}

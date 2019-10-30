package com.bartoszgajda.springkafka.service;

import com.bartoszgajda.springkafka.config.RsvpStreams;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class RsvpListener {
  private static final Logger logger = Logger.getLogger(RsvpListener.class.getName());

  @StreamListener(RsvpStreams.INPUT)
  public void handleRsvp(@Payload String rsvp) {
  }
}

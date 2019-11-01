package com.bartoszgajda.springkafka.service;

import com.bartoszgajda.springkafka.config.RsvpStreams;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class RsvpService {
  private static final Logger logger = Logger.getLogger(RsvpService.class.getName());
  private final RsvpStreams rsvpStreams;

  public RsvpService(RsvpStreams rsvpStreams) {
    this.rsvpStreams = rsvpStreams;
  }

  public void sendRsvp(final String rsvp) {
//    logger.log(Level.INFO, "RSVP To Kafka:\n {0}", rsvp);
    MessageChannel messageChannel = rsvpStreams.outboundRsvp();
    messageChannel.send(MessageBuilder.withPayload(rsvp).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
  }
}

package com.bartoszgajda.springkafka.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface RsvpStreams {
  String INPUT = "rsvp-in";
  String OUTPUT = "rsvp-out";

  @Input(INPUT)
  SubscribableChannel inboundRsvp();

  @Output(OUTPUT)
  MessageChannel outboundRsvp();
}

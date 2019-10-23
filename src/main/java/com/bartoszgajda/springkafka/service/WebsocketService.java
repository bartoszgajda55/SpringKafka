package com.bartoszgajda.springkafka.service;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Service
public class WebsocketService extends AbstractWebSocketHandler {
  private final RsvpService rsvpService;

  public WebsocketService(RsvpService rsvpService) {
    this.rsvpService = rsvpService;
  }

  @Override
  public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
    this.rsvpService.sendRsvp((String)message.getPayload());
  }
}

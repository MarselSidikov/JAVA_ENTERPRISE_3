package ru.itis.stomp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;

@Controller
public class MessagesController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/hello")
    public void receiveMessageFromClient(Message<String> message) {
        System.out.println(message);
        template.convertAndSend("/topic/chat", "Hello, " + message.getPayload());
    }

    @MessageMapping("/bye")
    @SendTo("/topic/chat")
    public TextMessage sendToTopic(Message<String> message) {
        return new TextMessage("Bye, " + message.getPayload());
    }
}

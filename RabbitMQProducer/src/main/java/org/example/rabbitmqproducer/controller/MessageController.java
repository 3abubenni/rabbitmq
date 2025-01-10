package org.example.rabbitmqproducer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.rabbitmqproducer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Tag(name = "Message Controller", description = "Controller to send message to RabbitMQ")
@RequestMapping("/message")
public class MessageController {

    private final MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }

    @Operation(description = "Send message to RabbitMQ")
    @ApiResponse(responseCode = "204")
    @PostMapping
    public ResponseEntity<Void> sendMessage(String message) {
        service.sendMessage(message);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Send message to RabbitMQ in queue with delay")
    @ApiResponse(responseCode = "204")
    @PostMapping("/with_delay")
    public ResponseEntity<Void> sendMessageWithDelay(String message) {
        service.sendMessageToQueueWithDelay(message);
        return ResponseEntity.noContent().build();
    }
}

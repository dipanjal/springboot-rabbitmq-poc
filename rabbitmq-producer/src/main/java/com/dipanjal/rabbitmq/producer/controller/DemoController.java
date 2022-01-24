package com.dipanjal.rabbitmq.producer.controller;

import com.dipanjal.rabbitmq.producer.model.CustomerMessage;
import com.dipanjal.rabbitmq.producer.model.request.MessageRequest;
import com.dipanjal.rabbitmq.producer.publisher.MessagePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final MessagePublisher<CustomerMessage> customerMessagePublisher;

    @GetMapping("/")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Up and Running");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> post(@RequestBody MessageRequest request) {
        CustomerMessage message = new CustomerMessage(request.getBody());
        customerMessagePublisher.publish(message);
        return ResponseEntity.ok("Message Send");
    }
}

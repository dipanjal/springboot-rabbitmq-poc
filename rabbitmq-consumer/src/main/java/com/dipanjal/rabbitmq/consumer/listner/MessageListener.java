package com.dipanjal.rabbitmq.consumer.listner;

import com.dipanjal.rabbitmq.consumer.config.RabbitMQConfig;
import com.dipanjal.rabbitmq.consumer.model.CustomerMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageListener {

    private final ObjectMapper mapper;

    public MessageListener() {
        this.mapper = new ObjectMapper();
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void customerMessageListener(CustomerMessage message) throws JsonProcessingException {
        String json = this.mapper.writeValueAsString(message);
        log.info("Message Received: {}", json);
    }
}

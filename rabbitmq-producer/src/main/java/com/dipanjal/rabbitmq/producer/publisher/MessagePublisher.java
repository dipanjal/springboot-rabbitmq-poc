package com.dipanjal.rabbitmq.producer.publisher;

import com.dipanjal.rabbitmq.producer.config.RabbitMQConfig;
import com.dipanjal.rabbitmq.producer.model.RabbitMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessagePublisher<T extends RabbitMessage> {

    private final RabbitTemplate rabbitTemplate;

    public boolean publish(T message) {
        message.setMessageId(UUID.randomUUID().toString());
        message.setDateTime(new Date());
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, message);
        log.info("Message Published | id: {}", message.getMessageId());
        return true;
    }
}

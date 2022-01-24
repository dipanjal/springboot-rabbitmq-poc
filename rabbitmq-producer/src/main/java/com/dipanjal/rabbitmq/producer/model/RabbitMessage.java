package com.dipanjal.rabbitmq.producer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RabbitMessage implements Serializable {
    private String messageId;
    private Date dateTime;
}

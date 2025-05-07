package com.store.auth.producers;

import com.store.auth.dto.AuthRecordDto;
import com.store.auth.dto.AuthRecordRabbitMQ;
import com.store.auth.models.UserAuthModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthProducer {

    final RabbitTemplate rabbitTemplate;

    public AuthProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.user.name}")
    private String routingKey;

    public void publishMessageEmail(UserAuthModel userAuthModel) {

        AuthRecordRabbitMQ authRecordRabbitMQ = new AuthRecordRabbitMQ(
                userAuthModel.getEmail(),
                userAuthModel.getName(),
                userAuthModel.getUserId());

        rabbitTemplate.convertAndSend("", routingKey, authRecordRabbitMQ);
    }

}

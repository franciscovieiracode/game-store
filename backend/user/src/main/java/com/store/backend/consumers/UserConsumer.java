package com.store.backend.consumers;

import com.store.backend.dto.UserRecordDto;
import com.store.backend.models.UserModel;
import com.store.backend.services.UserServices;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

    @Autowired
    UserServices userServices;

    @RabbitListener(queues = "${broker.queue.user.name}")
    public void listenUserQueue(@Payload UserRecordDto userRecordDto){

        userServices.save(userRecordDto);
    }
}

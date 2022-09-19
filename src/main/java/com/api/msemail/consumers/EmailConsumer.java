package com.api.msemail.consumers;

import com.api.msemail.dtos.EmailDto;
import com.api.msemail.models.EmailModel;
import com.api.msemail.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

//TODO Pontos de injeção Injeção de dependência
    @Autowired
    EmailService emailService;
//TODO Add Circuit breaker - resiliências
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
        public void listen(@Payload EmailDto emailDto){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);
        System.out.println("Email Status: " + emailModel.getStatusEmail().toString());
        }
}

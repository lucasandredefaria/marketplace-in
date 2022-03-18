package br.com.saraiva.marketplacein.queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String queue, Object message) throws JsonProcessingException {
        this.rabbitTemplate.convertAndSend(queue, message);
        log.info("Sending the message to the queue: {} - {}", queue, message);
    }

}

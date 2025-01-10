package org.example.rabbitmqproducer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final RabbitTemplate template;

    @Value("${rabbitmq.queue.name}")
    private String messageQueue;

    @Value("${rabbitmq.queue_with_delay.name}")
    private String messageWithDelayQueue;

    @Autowired
    public MessageService(RabbitTemplate template) {
        this.template = template;
    }

    /**
     * Отправляет сообщение в очередь
     * @param message Сообщение
     */
    public void sendMessage(String message) {
        template.convertAndSend(messageQueue, message);
    }

    /**
     * Посылает сообщение в очередь, которая обрабатывается слушателем с некоторой задержкой
     * @param message Сообщение
     */
    public void sendMessageToQueueWithDelay(String message) {
        template.convertAndSend(messageWithDelayQueue, message);
    }

}

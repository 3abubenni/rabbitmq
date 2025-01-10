package org.example.rabbitmqconsumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RabbitMQListener {

    private final static Random RANDOM = new Random();

    @RabbitListener(queues = "#{@environment.getProperty('rabbitmq.queue.name')}")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }

    @RabbitListener(queues = "#{@environment.getProperty('rabbitmq.queue_with_delay.name')}")
    public void receiveMessageWithDelay(String message) throws InterruptedException {
        var delay = RANDOM.nextInt(10000);
        Thread.sleep(delay);
        System.out.println("Received message: " + message + " with delay: " + delay);
    }

}

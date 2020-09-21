package ru.itis.example1;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

// читает сообщения из очереди
public class Consumer {
    private final static String QUEUE_1 = "queue_1";
    private final static String QUEUE_2 = "queue_2";
    private final static String QUEUE_3 = "queue_3";


    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            // читаем сообщения из очереди
            channel.basicConsume(QUEUE_2, false, (consumerTag, message) -> {
                System.out.println(consumerTag);
                System.out.println("Message FROM " + QUEUE_2 + " " + new String(message.getBody()));
            }, consumerTag -> {});
        } catch (IOException | TimeoutException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

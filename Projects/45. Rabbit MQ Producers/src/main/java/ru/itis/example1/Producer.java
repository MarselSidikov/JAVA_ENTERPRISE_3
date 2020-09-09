package ru.itis.example1;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

// приложение, которое отправляет сообщения в очереди
public class Producer {
    private final static String QUEUE_1 = "queue_1";
    private final static String QUEUE_2 = "queue_2";
    private final static String QUEUE_3 = "queue_3";


    public static void main(String[] args) {
        // создаем фабрику подключений
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // говорим, куда подключаться
        connectionFactory.setHost("localhost");

        try {
            Connection connection = connectionFactory.newConnection();
            // создаем канал
            Channel channel = connection.createChannel();
            channel.basicPublish("", QUEUE_1, null, "Hello to queue 1".getBytes());
            channel.basicPublish("", QUEUE_2, null, "Hello to queue 2".getBytes());
            channel.basicPublish("", QUEUE_3, null, "Hello to queue 3".getBytes());
        } catch (IOException | TimeoutException e) {
            throw new IllegalArgumentException(e);
        }
    }

}

package ru.itis.example6;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Client {
    // канал
    private Channel channel;
    // очередь, в котороую будут поступать ответы от сервера
    private String replyQueueName;
    // очередь в которую уходят задачи от клиента
    private final static String REQUEST_QUEUE_NAME = "calls";

    public Client() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try {
            Connection connection = factory.newConnection();
            // создаем канал
            channel = connection.createChannel();
            // создаем очередь для ответов конкретному клиенту
            replyQueueName = channel.queueDeclare("", false, true, false, null).getQueue();
        } catch (IOException | TimeoutException e) {
            throw new IllegalArgumentException();
        }
    }

    public Long downloadFileAndGetSize(String fileUrl) {
        // генерируем случайный ID
        String correlationId = UUID.randomUUID().toString();
        try {
            // формируем свойства, которые мы направим вместе с задачей (сообщением)
            BasicProperties properties = new BasicProperties.Builder()
                    .correlationId(correlationId)
                    .replyTo(replyQueueName)
                    .build();
            // публикуем задачу
            channel.basicPublish("", REQUEST_QUEUE_NAME, properties, fileUrl.getBytes());

            // класс, позволяющий отложить задачу в поток
            CompletableFuture<Long> result = new CompletableFuture<>();

            String consumerTag = channel.basicConsume(replyQueueName, true, (tag, message) -> {
                // смотрим, этот ответ был конкретно по этой задаче?
                if (message.getProperties().getCorrelationId().equals(correlationId)) {
                    // кладем результат (размер файла в result) и идем дальше
                    result.complete(Long.parseLong(new String(message.getBody())));
                }
            }, tag -> {});
            // вы не получите размер файла, пока у result не будет вызват complete
            Long value = result.get();
            channel.basicCancel(consumerTag);
            return value;
        } catch (IOException | InterruptedException | ExecutionException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

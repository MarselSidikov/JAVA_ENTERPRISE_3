package ru.itis.chat.controllers;

import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.chat.dto.MessageDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MessagesController {
    private static final Map<String, List<MessageDto>> messages = new HashMap<>();

    // получили сообщение от какой либо страницы - мы его разошлем во все другие страницы
    @PostMapping("/messages")
    public ResponseEntity<Object> receiveMessage(@RequestBody MessageDto message) {
        // если сообщений с этой или для этой страницы еще не было
        if (!messages.containsKey(message.getPageId())) {
            // добавляем эту страницу в Map-у страниц
            messages.put(message.getPageId(), new ArrayList<>());
        }
        // полученное сообщение добавляем для всех открытых страниц нашего приложения
        for (List<MessageDto> pageMessages : messages.values()) {
            // перед тем как положить сообщение для какой-либо страницы
            // мы список сообщений блокируем
            synchronized (pageMessages) {
                // добавляем сообщение
                pageMessages.add(message);
                // говорим, что другие потоки могут воспользоваться этим списком
                pageMessages.notifyAll();
            }
        }

        return ResponseEntity.ok().build();
    }

    // получить все сообщения для текущего запроса
    @SneakyThrows
    @GetMapping("/messages")
    public ResponseEntity<List<MessageDto>> getMessagesForPage(@RequestParam("pageId") String pageId) {
        // получили список сообшений для страницы и заблокировали его
        synchronized (messages.get(pageId)) {
            // если нет сообщений уходим в ожидание
            if (messages.get(pageId).isEmpty()) {
                messages.get(pageId).wait();
            }
        }

        // если сообщения есть - то кладем их в новых список
        List<MessageDto> response = new ArrayList<>(messages.get(pageId));
        // удаляем сообщения из мапы
        messages.get(pageId).clear();
        return ResponseEntity.ok(response);
    }
}

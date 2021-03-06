package ru.itis.files.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.itis.files.dto.FileInfo;
import ru.itis.files.services.FileMimeService;

/**
 * 19.02.2021
 * files-service
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class MimesController {
    @Autowired
    private FileMimeService fileMimesService;

    @GetMapping(value = "/files/mimes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<FileInfo> getFiles() {
        return fileMimesService.getMimes();
    }
}

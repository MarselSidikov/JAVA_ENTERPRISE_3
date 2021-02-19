package ru.itis.files.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.itis.files.dto.FileInfo;
import ru.itis.files.services.FileSizeService;

import java.time.Duration;

/**
 * 19.02.2021
 * files-service
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class SizesController {
    @Autowired
    private FileSizeService filesSizeService;

    @GetMapping(value = "/files/sizes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<FileInfo> getFiles() {
        return filesSizeService.getSizes();
    }
}

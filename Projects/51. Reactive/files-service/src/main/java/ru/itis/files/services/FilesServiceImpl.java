package ru.itis.files.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ru.itis.files.dto.FileInfo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 19.02.2021
 * files-service
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class FilesServiceImpl implements FilesService {
    @Override
    public Flux<FileInfo> getFiles() {
        return Flux.using(() -> Files.lines(Paths.get("images.txt")), Flux::fromStream,
                Stream::close).map(fileUrl -> FileInfo.builder()
                .url(fileUrl)
                .build());
    }
}

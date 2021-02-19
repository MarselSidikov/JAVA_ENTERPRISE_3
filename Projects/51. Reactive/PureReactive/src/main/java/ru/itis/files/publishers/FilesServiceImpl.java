package ru.itis.files.publishers;

import reactor.core.publisher.Flux;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * 19.02.2021
 * PureReactive
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class FilesServiceImpl implements FilesService {
    @Override
    public Flux<String> getFileUrls() {
        return Flux.using(() -> Files.lines(Paths.get("images.txt")), Flux::fromStream,
                Stream::close);
    }
}

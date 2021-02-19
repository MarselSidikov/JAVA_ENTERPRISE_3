package ru.itis.files.publishers;

import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 19.02.2021
 * PureReactive
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface FilesService {
    Flux<String> getFileUrls();
}

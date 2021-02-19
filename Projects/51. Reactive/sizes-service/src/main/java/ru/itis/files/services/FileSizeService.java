package ru.itis.files.services;

import reactor.core.publisher.Flux;
import ru.itis.files.dto.FileInfo;

/**
 * 19.02.2021
 * files-service
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface FileSizeService {
    Flux<FileInfo> getSizes();
}

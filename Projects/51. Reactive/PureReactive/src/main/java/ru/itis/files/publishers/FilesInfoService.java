package ru.itis.files.publishers;

import reactor.core.publisher.Flux;
import ru.itis.files.dto.FileInfo;

/**
 * 19.02.2021
 * PureReactive
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface FilesInfoService {
    Flux<FileInfo> getSizes(Flux<String> urls);
    Flux<FileInfo> getMimes(Flux<String> urls);
    Flux<FileInfo> getCompleted(Flux<FileInfo> sizes, Flux<FileInfo> mimes);
}

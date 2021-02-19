package ru.itis.files.app;

import reactor.core.publisher.Flux;
import ru.itis.files.dto.FileInfo;
import ru.itis.files.publishers.FilesInfoService;
import ru.itis.files.publishers.FilesService;
import ru.itis.files.publishers.FilesServiceImpl;
import ru.itis.files.publishers.FilesInfoServiceImpl;

/**
 * 19.02.2021
 * PureReactive
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        FilesService filesService = new FilesServiceImpl();
        FilesInfoService filesInfoService = new FilesInfoServiceImpl();

        Flux<String> urls = filesService.getFileUrls();
        Flux<FileInfo> sizes = filesInfoService.getSizes(urls);
        Flux<FileInfo> mimes = filesInfoService.getMimes(urls);
        Flux<FileInfo> completed = filesInfoService.getCompleted(sizes, mimes);

        completed.subscribe(System.out::println);

        Thread.sleep(40000);
    }
}

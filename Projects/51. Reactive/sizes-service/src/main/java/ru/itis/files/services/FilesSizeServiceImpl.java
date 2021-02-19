package ru.itis.files.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.itis.files.dto.FileInfo;

import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
public class FilesSizeServiceImpl implements FileSizeService {

    @Autowired
    private WebClient webClient;

    @Value("${files.service.url}")
    private String fileServiceUrl;

    @Override
    public Flux<FileInfo> getSizes() {
        Flux<FileInfo> urls = webClient.get()
                .uri(fileServiceUrl)
                .retrieve()
                .bodyToFlux(FileInfo.class);

        return Flux.create(
                emitter -> urls.subscribe(file -> emitter.next(getSize(file))));
    }

    private FileInfo getSize(FileInfo file) {
        FileInfo fileInfo = FileInfo.builder()
                .url(file.getUrl())
                .isAvailable(true)
                .build();

        URL url;
        try {
            url = new URL(file.getUrl());
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
        // create a connection
        HttpURLConnection connection;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.getInputStream();
            BigInteger size = BigInteger.valueOf(connection.getContentLength());
            connection.getInputStream().close();
            fileInfo.setSize(size.longValue());

            if (fileInfo.getSize() == -1) {
                fileInfo.setAvailable(false);
            }
        } catch (Exception e) {
            fileInfo.setAvailable(false);
        }
        return fileInfo;
    }
}

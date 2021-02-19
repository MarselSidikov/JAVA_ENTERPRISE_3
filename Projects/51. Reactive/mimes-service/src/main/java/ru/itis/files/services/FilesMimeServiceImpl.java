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
import java.net.URLConnection;

/**
 * 19.02.2021
 * files-service
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class FilesMimeServiceImpl implements FileMimeService {

    @Autowired
    private WebClient webClient;

    @Value("${files.service.url}")
    private String fileServiceUrl;

    @Override
    public Flux<FileInfo> getMimes() {
        Flux<FileInfo> urls = webClient.get()
                .uri(fileServiceUrl)
                .retrieve()
                .bodyToFlux(FileInfo.class);

        return Flux.create(
                emitter -> urls.subscribe(file -> emitter.next(getMime(file))));
    }

    private FileInfo getMime(FileInfo file) {
        FileInfo fileInfo = FileInfo
                .builder()
                .isAvailable(true)
                .url(file.getUrl())
                .build();
        try {
            URL url = new URL(file.getUrl());
            URLConnection urlConnection;
            urlConnection = url.openConnection();
            fileInfo.setMIME(urlConnection.getContentType());
        } catch (Exception e) {
            fileInfo.setAvailable(false);
        }
        return fileInfo;
    }
}

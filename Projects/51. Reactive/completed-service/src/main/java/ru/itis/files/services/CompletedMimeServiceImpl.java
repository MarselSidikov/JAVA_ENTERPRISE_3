package ru.itis.files.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.itis.files.dto.FileInfo;

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
public class CompletedMimeServiceImpl implements CompletedService {

    @Autowired
    private WebClient webClient;

    @Value("${mimes.service.url}")
    private String mimesServiceUrl;

    @Value("${sizes.service.url}")
    private String sizesServiceUrl;

    @Override
    public Flux<FileInfo> getCompleted() {

        Flux<FileInfo> sizes = webClient.get()
                .uri(sizesServiceUrl)
                .retrieve()
                .bodyToFlux(FileInfo.class);

        Flux<FileInfo> mimes = webClient.get()
                .uri(mimesServiceUrl)
                .retrieve()
                .bodyToFlux(FileInfo.class);

        return Flux.zip(sizes, mimes, (size, mime) -> {
            if (size.isAvailable() && mime.isAvailable() &&
                    size.getUrl().equals(mime.getUrl())) {
                return FileInfo.builder()
                        .url(size.getUrl())
                        .MIME(mime.getMIME())
                        .size(size.getSize())
                        .isCompleted(true)
                        .build();
            } else {
                return FileInfo.builder()
                        .isCompleted(false)
                        .build();
            }
        }).filter(FileInfo::isCompleted);

    }
}

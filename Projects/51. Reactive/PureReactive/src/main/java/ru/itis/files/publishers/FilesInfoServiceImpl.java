package ru.itis.files.publishers;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import ru.itis.files.dto.FileInfo;
import ru.itis.files.utils.FileUtils;

import java.util.function.BiFunction;

/**
 * 19.02.2021
 * PureReactive
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class FilesInfoServiceImpl implements FilesInfoService {

    private FileUtils fileUtils = new FileUtils();

    private final Scheduler sizesScheduler = Schedulers.newParallel("SIZES");
    private final Scheduler mimesScheduler = Schedulers.newParallel("MIMES");

    @Override
    public Flux<FileInfo> getSizes(Flux<String> urls) {
        return Flux.create(emitter ->
                urls.publishOn(sizesScheduler).subscribe(url ->
                        emitter.next(fileUtils.getSize(url))));
    }

    @Override
    public Flux<FileInfo> getMimes(Flux<String> urls) {
        return Flux.create(emitter ->
                urls.publishOn(mimesScheduler).subscribe(url ->
                        emitter.next(fileUtils.getMime(url))));
    }

    @Override
    public Flux<FileInfo> getCompleted(Flux<FileInfo> sizes, Flux<FileInfo> mimes) {
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

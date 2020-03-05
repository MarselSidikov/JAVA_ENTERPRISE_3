package ru.itis.servlets.models;

import lombok.*;

/**
 * 01.12.2017
 * FileInfo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder()
public class FileInfo {

    private Long id;
    // название файла в хранилище
    private String storageFileName;
    // название файла оригинальное
    private String originalFileName;
    // размер файла
    private Long size;
    // тип файла (MIME)
    private String type;
    // по какому URL можно получить файл
    private String url;
}

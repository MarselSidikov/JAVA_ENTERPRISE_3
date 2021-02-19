package ru.itis.files.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 19.02.2021
 * PureReactive
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileInfo {
    private String url;
    private Long size;
    private String MIME;
    private boolean isAvailable;
    private boolean isCompleted;
}

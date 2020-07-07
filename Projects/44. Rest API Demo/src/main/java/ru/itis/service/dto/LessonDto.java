package ru.itis.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.service.models.Lesson;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 03.07.2020
 * 44. Rest API Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonDto {
    @ApiModelProperty(notes = "Идентификатор урока")
    private Long id;
    @ApiModelProperty(notes = "Название урока", required = true)
    private String name;

    public static LessonDto from(Lesson lesson) {
        return LessonDto.builder()
                .id(lesson.getId())
                .name(lesson.getName())
                .build();
    }

    public static List<LessonDto> from(List<Lesson> lessons) {
        return lessons.stream().map(LessonDto::from).collect(Collectors.toList());
    }
}

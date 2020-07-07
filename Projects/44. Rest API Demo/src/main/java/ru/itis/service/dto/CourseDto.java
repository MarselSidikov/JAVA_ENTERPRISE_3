package ru.itis.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.service.models.Course;

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
public class CourseDto {
    private Long id;
    private String title;

    public static CourseDto from(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .build();
    }

    public static List<CourseDto> from(List<Course> courses) {
        return courses.stream().map(CourseDto::from).collect(Collectors.toList());
    }
}

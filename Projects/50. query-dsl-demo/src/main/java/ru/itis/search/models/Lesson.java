package ru.itis.search.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

/**
 * 26.08.2017
 * Lesson
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder()
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalTime startTime;
    private LocalTime finishTime;
}

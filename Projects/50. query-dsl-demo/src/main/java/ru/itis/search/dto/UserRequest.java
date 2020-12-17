package ru.itis.search.dto;

import lombok.Data;

/**
 * 17.12.2020
 * 50. query-dsl-demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
public class UserRequest {
    private String firstName;
    private String lastName;
    private String courseName;
}

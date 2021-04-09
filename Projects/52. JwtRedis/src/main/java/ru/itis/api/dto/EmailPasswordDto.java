package ru.itis.api.dto;

import lombok.Data;

/**
 * 05.04.2021
 * 21. REST API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
public class EmailPasswordDto {
    private String email;
    private String password;
}

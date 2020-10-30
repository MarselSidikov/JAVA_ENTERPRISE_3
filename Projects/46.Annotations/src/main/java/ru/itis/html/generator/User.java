package ru.itis.html.generator;

/**
 * 30.10.2020
 * 46. Annotations
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@HtmlForm(method = "post", action = "/users")
public class User {
    @HtmlInput(type = "text", name = "first_name", placeholder = "Имя")
    private String firstName;
    @HtmlInput(type = "text", name = "last_name", placeholder = "Фамилия")
    private String lastName;
    @HtmlInput(type = "email", name = "email", placeholder = "Email")
    private String email;
    @HtmlInput(type = "password", name = "password", placeholder = "Пароль")
    private String password;
}

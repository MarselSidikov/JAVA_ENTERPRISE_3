package ru.itis.dto;

public class User {
    private Long id;
    private String password;

    public User(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

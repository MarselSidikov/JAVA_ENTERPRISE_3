package ru.itis.models;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Boolean isMan;

    public User(Long id, String firstName, String lastName, Integer age, Boolean isMan) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isMan = isMan;
    }

    public User(String firstName, String lastName, Integer age, Boolean isMan) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isMan = isMan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getMan() {
        return isMan;
    }

    public void setMan(Boolean man) {
        isMan = man;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", isMan=" + isMan +
                '}';
    }
}

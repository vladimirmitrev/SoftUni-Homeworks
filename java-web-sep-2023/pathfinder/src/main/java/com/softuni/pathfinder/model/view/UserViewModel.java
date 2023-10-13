package com.softuni.pathfinder.model.view;

import com.softuni.pathfinder.model.entity.enums.LevelEnum;

public class UserViewModel {


    private String username;
    private String email;
    private String fullName;
    private Integer age;
    private String level;

    public UserViewModel(String username, String email, String fullName, Integer age, String level) {
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.age = age;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}

package com.softuni.coffeeshop.model.binding;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {

    @NotEmpty
    @Size(min = 5, max = 20)
    private String username;
    @NotEmpty
    @Size(min = 3)
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

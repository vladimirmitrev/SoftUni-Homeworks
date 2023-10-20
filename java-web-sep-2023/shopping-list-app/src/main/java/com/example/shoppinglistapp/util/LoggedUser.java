package com.example.shoppinglistapp.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {

    private Long id;
    private String username;
    private boolean isLogged;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void login(String username) {
        this.username = username;
        this.isLogged = true;
    }
    public void logout() {
        this.id = null;
        this.username = null;
        this.isLogged = false;
    }
}

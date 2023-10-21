package com.dictionaryapp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;


import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Length(min = 3, max = 20)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @OneToMany(mappedBy = "addedBy")
    private List<Word> addedWords;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Word> getAddedWords() {
        return addedWords;
    }

    public void setAddedWords(List<Word> addedWords) {
        this.addedWords = addedWords;
    }
}

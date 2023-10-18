package com.likebookapp.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {


    @Column(nullable = false, unique = true)
    @Length(min = 3, max = 20)
    private String username;
    @Column(nullable = false)
    @Length(min = 3, max = 20)
    private String password;
    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @OneToMany(mappedBy = "creator")
    private List<Post> posts;

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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

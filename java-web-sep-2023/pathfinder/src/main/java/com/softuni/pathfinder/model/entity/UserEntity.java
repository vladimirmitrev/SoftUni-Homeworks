package com.softuni.pathfinder.model.entity;

import com.softuni.pathfinder.model.entity.enums.LevelEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String fullName;
//    @Column(nullable = false, unique = true)
    private Integer age;
    private String email;
    @Enumerated(EnumType.STRING)
    private LevelEnum level;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<RoleEntity> roles;

    public UserEntity() {
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }


    public Set<RoleEntity> getRole() {
        return roles;
    }

    public void setRole(Set<RoleEntity> role) {
        this.roles = role;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

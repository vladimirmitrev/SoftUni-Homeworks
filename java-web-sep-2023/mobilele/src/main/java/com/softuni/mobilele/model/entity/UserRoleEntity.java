package com.softuni.mobilele.model.entity;

import com.softuni.mobilele.model.enums.RoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoleEntity extends BaseEntity{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}

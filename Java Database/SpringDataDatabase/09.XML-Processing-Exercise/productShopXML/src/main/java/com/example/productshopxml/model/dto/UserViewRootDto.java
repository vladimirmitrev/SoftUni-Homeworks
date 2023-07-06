package com.example.productshopxml.model.dto.seed._4dto;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserViewRootDto {

    @XmlAttribute(name = "count")
    private int usersCount;

    @XmlElement(name = "user")
    private List<UserFirstAndLastNameAgeDto> users;

    public UserViewRootDto(List<UserFirstAndLastNameAgeDto> users) {
        this.users = users;
        this.usersCount = users.size();
    }


    public UserViewRootDto() {
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public List<UserFirstAndLastNameAgeDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserFirstAndLastNameAgeDto> users) {
        this.users = users;
    }
}

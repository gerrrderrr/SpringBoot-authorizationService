package ru.netology.authorizationservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class User {
    private final String name;
    private final String password;
    private List<Authorities> authorities;

    public User(String name, String password, List<Authorities> authorities) {
        this.name = name;
        this.password = password;
        this.authorities = authorities;
    }
}

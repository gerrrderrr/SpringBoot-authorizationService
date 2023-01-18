package ru.netology.authorizationservice.user;

import ru.netology.authorizationservice.authorities.Authorities;

import java.util.ArrayList;
import java.util.List;

public class UserMainInfo {
    private String name;
    private String password;
    private List<Authorities> authorities;

    public UserMainInfo(String name, String password) {
        this.name = name;
        this.password = password;
        authorities = new ArrayList<>();
    }

    public boolean isPasswordCorrect(String password) {
        return this.getPassword().equals(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "UserMainInfo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}

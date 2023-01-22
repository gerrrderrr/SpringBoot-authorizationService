package ru.netology.authorizationservice.exceptions;

public class UserExist extends RuntimeException {
    public UserExist(String msg) {
        super(msg);
    }
}

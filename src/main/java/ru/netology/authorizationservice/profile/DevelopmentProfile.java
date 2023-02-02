package ru.netology.authorizationservice.profile;

public class DevelopmentProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Welcome to Dev profile";
    }
}

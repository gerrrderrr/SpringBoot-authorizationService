package ru.netology.authorizationservice.profile;

public class ProductionProfile implements SystemProfile{
    @Override
    public String getProfile() {
        return "Welcome to Prod profile";
    }
}

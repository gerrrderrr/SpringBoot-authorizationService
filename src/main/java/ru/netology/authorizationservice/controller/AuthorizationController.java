package ru.netology.authorizationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorizationservice.dto.UserDto;
import ru.netology.authorizationservice.model.Authorities;
import ru.netology.authorizationservice.profile.SystemProfile;
import ru.netology.authorizationservice.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;
    private final SystemProfile profile;

    public AuthorizationController(AuthorizationService service, SystemProfile profile) {
        this.service = service;
        this.profile = profile;
    }

    @GetMapping("/profile")
    public String getProfile() {
        return profile.getProfile();
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid UserDto userDto) {
        return service.getAuthorities(userDto);
    }

    @PostMapping("/signup")
    public String signup(@RequestBody @Valid UserDto userDto) {
        return service.signup(userDto);
    }
}
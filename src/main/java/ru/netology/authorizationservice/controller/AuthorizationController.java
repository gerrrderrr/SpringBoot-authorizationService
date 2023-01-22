package ru.netology.authorizationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorizationservice.dto.UserDto;
import ru.netology.authorizationservice.model.Authorities;
import ru.netology.authorizationservice.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid UserDto userDto) {
        return service.getAuthorities(userDto);
    }

    @PostMapping("/signup")
    public String signup(@Valid UserDto userDto) {
        return service.signup(userDto);
    }
}
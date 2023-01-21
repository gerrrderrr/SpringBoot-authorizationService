package ru.netology.authorizationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorizationservice.authorities.Authorities;
import ru.netology.authorizationservice.service.AuthorizationService;
import ru.netology.authorizationservice.user.UserDto;

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
}
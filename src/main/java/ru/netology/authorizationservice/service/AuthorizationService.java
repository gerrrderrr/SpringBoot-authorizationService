package ru.netology.authorizationservice.service;

import org.springframework.stereotype.Service;
import ru.netology.authorizationservice.authorities.Authorities;
import ru.netology.authorizationservice.exceptions.UnauthorizedUser;
import ru.netology.authorizationservice.repository.UserRepository;
import ru.netology.authorizationservice.user.UserDto;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(UserDto userDto) {
        if (userRepository.isUserExists(userDto)) {
            return userRepository.getUserAuthorities(userDto);
        } else {
            throw new UnauthorizedUser("User " + userDto.getUser() + " doesn't exist");
        }
    }
}

package ru.netology.authorizationservice.service;

import org.springframework.stereotype.Service;
import ru.netology.authorizationservice.dto.UserDto;
import ru.netology.authorizationservice.exceptions.UnauthorizedUser;
import ru.netology.authorizationservice.exceptions.UserExist;
import ru.netology.authorizationservice.model.Authorities;
import ru.netology.authorizationservice.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(UserDto userDto) {
        if (userRepository.isUserSignedUp(userDto)) {
            return userRepository.getUserAuthorities(userDto);
        } else {
            throw new UnauthorizedUser("User " + userDto.getName() + " doesn't exist");
        }
    }

    public String signup(UserDto userDto) {
        if (!userRepository.isUserNameExist(userDto)) {
            return userRepository.signup(userDto);
        } else {
            throw new UserExist("User with this name already exists");
        }
    }
}

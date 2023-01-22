package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.dto.UserDto;
import ru.netology.authorizationservice.exceptions.IncorrectPassword;
import ru.netology.authorizationservice.model.Authorities;
import ru.netology.authorizationservice.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public List<Authorities> getUserAuthorities(UserDto userDto) {
        return users.get(userDto.getName()).getAuthorities();
    }

    public String signup(UserDto userDto) {
        String username = userDto.getName();
        String password = userDto.getPassword();
        users.put(username, new User(username, password, Arrays.asList(Authorities.READ, Authorities.DELETE, Authorities.WRITE)));
        return "User " + username + " was successfully signed up";
    }

    public boolean isUserSignedUp(UserDto userDto) {
        return isUserNameExist(userDto) && isPasswordCorrect(userDto);
    }

    public boolean isUserNameExist(UserDto userDto) {
        return users.containsKey(userDto.getName());
    }

    private boolean isPasswordCorrect(UserDto userDto) {
        if (users.get(userDto.getName()).getPassword().equals(userDto.getPassword())) {
            return true;
        } else {
            throw new IncorrectPassword("Wrong password");
        }
    }
}
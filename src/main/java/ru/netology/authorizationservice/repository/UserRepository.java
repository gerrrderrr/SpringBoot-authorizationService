package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.authorities.Authorities;
import ru.netology.authorizationservice.user.UserDto;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<UserDto, List<Authorities>> users = new ConcurrentHashMap<>();

    public List<Authorities> getUserAuthorities(UserDto userDto) {
        return users.get(userDto);
    }

    public boolean isUserExists(UserDto userDto) {
        return users.containsKey(userDto);
    }
}
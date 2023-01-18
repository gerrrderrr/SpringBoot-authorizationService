package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.authorities.Authorities;
import ru.netology.authorizationservice.user.UserMainInfo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<String, UserMainInfo> users = new ConcurrentHashMap<>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (isUserExists(user)) {
            UserMainInfo searchedUser = getUser(user);
            return searchedUser.isPasswordCorrect(password) ? searchedUser.getAuthorities() : null;
        }
        return null;
    }

    private boolean isUserExists(String user) {
        return users.containsKey(user);
    }

    private UserMainInfo getUser(String user) {
        return users.get(user);
    }

    private void addToMapOfUsers(UserMainInfo userMainInfo) {
        users.put(userMainInfo.getName(), userMainInfo);
    }
}
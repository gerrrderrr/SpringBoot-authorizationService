package ru.netology.authorizationservice.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {
    @NotBlank(message = "Empty field")
    @Size(min = 2, max = 20, message = "The number of characters in the username must be between 2 and 20")
    private String user;
    @NotBlank(message = "Empty field")
    @Size(min = 10, max = 25, message = "The number of characters in the password must be between 10 and 25")
    private String password;

    public UserDto(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public UserDto() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

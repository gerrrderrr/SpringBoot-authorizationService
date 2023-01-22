package ru.netology.authorizationservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDto {
    @NotBlank(message = "Empty field")
    @Size(min = 2, max = 20, message = "The number of characters in the username must be between 2 and 20")
    private String name;
    @NotBlank(message = "Empty field")
    @Size(min = 10, max = 25, message = "The number of characters in the password must be between 10 and 25")
    private String password;

    public UserDto(String user, String password) {
        this.name = user;
        this.password = password;
    }
}

package ru.netology.authorizationservice.exceptions;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class InvalidCredentials extends MethodArgumentNotValidException {
    public InvalidCredentials(MethodParameter parameter, BindingResult bindingResult) {
        super(parameter, bindingResult);
    }
}

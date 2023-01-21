package ru.netology.authorizationservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.authorizationservice.exceptions.InvalidCredentials;
import ru.netology.authorizationservice.exceptions.UnauthorizedUser;

import java.util.Objects;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials e) {
        StringBuilder msg = new StringBuilder();
        for (FieldError error : e.getFieldErrors()) {
            String value = Objects.requireNonNull(error.getRejectedValue()).toString();
            String field = error.getField();
            String defaultErrorMsg = error.getDefaultMessage();
            msg.append("Entered incorrect ")
                    .append(field)
                    .append("(")
                    .append(value)
                    .append("): ")
                    .append(defaultErrorMsg)
                    .append("\n");
        }
        return new ResponseEntity<>(msg.toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}

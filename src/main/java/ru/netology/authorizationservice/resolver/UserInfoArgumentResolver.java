package ru.netology.authorizationservice.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.netology.authorizationservice.exceptions.InvalidCredentials;
import ru.netology.authorizationservice.dto.UserDto;

public class UserInfoArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(UserDto.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        String user = webRequest.getParameter("user");
        String password = webRequest.getParameter("password");
        UserDto userDto = new UserDto(user, password);
        WebDataBinder webDataBinder = createWebDataBinder(binderFactory, webRequest, userDto);
        webDataBinder.validate();
        BindingResult bindingResult = webDataBinder.getBindingResult();
        checkBindingResultForErrors(parameter, bindingResult);
        return userDto;
    }

    private WebDataBinder createWebDataBinder(WebDataBinderFactory factory, NativeWebRequest webRequest, UserDto userDto) {
        WebDataBinder webDataBinder;
        try {
            webDataBinder = factory.createBinder(webRequest, userDto, "defaultName");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return webDataBinder;
    }

    private void checkBindingResultForErrors(MethodParameter parameter, BindingResult bindingResult) throws InvalidCredentials {
        if (bindingResult.getErrorCount() > 0) {
            throw new InvalidCredentials(parameter, bindingResult);
        }
    }
}

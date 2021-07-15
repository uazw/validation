package io.github.uazw.validation.controller;

import org.springframework.util.ObjectUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.util.stream.Collectors.joining;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String handle(MethodArgumentNotValidException ex) {
        var allErrors = ex.getAllErrors();
        return allErrors.stream().filter(FieldError.class::isInstance)
                .map(this::errorMessage).collect(joining(", "));
    }

    private String errorMessage(ObjectError error) {
        var fieldError = (FieldError) error;
        return String.format("field %s wrong, and origin value is %s",
                fieldError.getField(), ObjectUtils.nullSafeToString(fieldError.getRejectedValue()));
    }
}

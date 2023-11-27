package com.betek.interactivetInnovationEducation.configuration;

import com.betek.interactivetInnovationEducation.domain.exceptions.BadPostDeleteIntentException;
import com.betek.interactivetInnovationEducation.domain.exceptions.HomeCategoriesFilterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.betek.interactivetInnovationEducation.configuration.Constants.DIFFERENT_POST_DELETE_ERROR;
import static com.betek.interactivetInnovationEducation.configuration.Constants.HOME_CATEGORIES_FILTER_EXCEPTION;
import static com.betek.interactivetInnovationEducation.configuration.Constants.RESPONSE_ERROR_MESSAGE_KEY;
import static com.betek.interactivetInnovationEducation.configuration.Constants.WRONG_CREDENTIALS_MESSAGE;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errorMessages = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                errorMessages.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
            } else {
                errorMessages.add(error.getDefaultMessage());
            }
        }
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Map<String, String>> handleAuthenticationException(AuthenticationException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, WRONG_CREDENTIALS_MESSAGE));
    }

    @ExceptionHandler(BadPostDeleteIntentException.class)
    public ResponseEntity<Map<String, String>> handleBadPostDeleteIntentException(BadPostDeleteIntentException badPostDeleteIntentException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, DIFFERENT_POST_DELETE_ERROR));
    }

    @ExceptionHandler(HomeCategoriesFilterException.class)
    public ResponseEntity<Map<String, String>> handleHomeCategoriesFilterException(HomeCategoriesFilterException homeCategoriesFilterException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, HOME_CATEGORIES_FILTER_EXCEPTION));
    }
}

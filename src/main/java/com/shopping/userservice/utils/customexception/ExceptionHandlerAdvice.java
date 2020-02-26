package com.shopping.userservice.utils.customexception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ShoppingException.class)
    public final ResponseEntity handleCustomException(ShoppingException exception, WebRequest request) {

        log.error("Error {}", exception);
        String responseMessage = "A User already exists";
        String[] splittedByIndex = StringUtils.split(exception.getMessage(), " index: credentials.");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("ResponseType", "Non-Reactive");
        httpHeaders.add("HttpStatus", "404");
        if (splittedByIndex != null) {
            String[] splittedByDupKey = StringUtils.split(splittedByIndex[1], " dup key");
            if (splittedByDupKey != null) {
                responseMessage += " with the same " + splittedByDupKey[0];
                return ResponseEntity.ok(new ErrorDetails(responseMessage, LocalDateTime.now()));
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDetails(exception.getMessage(), LocalDateTime.now()));

    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity handleAllExceptions(Exception exception, WebRequest request) {
        log.error("Error {}", exception);
        ErrorDetails error = new ErrorDetails("Something went wrong, please try again", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);

    }

}

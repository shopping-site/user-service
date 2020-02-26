package com.shopping.userservice.utils.customexception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorDetails {

    private String message;
    private LocalDateTime timestamp;


    public ErrorDetails(String message, LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

}

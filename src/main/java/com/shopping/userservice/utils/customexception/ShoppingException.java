package com.shopping.userservice.utils.customexception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ShoppingException extends RuntimeException {
    private String message;
}

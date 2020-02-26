package com.shopping.userservice.utils.customexception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class ResponseMessage< T > {

    private String message;
    private HttpStatus httpStatus;

    public ResponseMessage(String message, HttpStatus ok) {
        this.message=message;
        this.httpStatus=ok;

    }




}

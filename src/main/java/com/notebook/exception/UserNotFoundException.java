package com.notebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UserNotFoundException extends BaseException {

    public UserNotFoundException(String message, String detail, int code) {
        super(message, detail, code);
    }
}



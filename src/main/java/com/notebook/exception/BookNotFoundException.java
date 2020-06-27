package com.notebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class BookNotFoundException extends BaseException{


    public BookNotFoundException(String message, String detail, int code) {
        super(message, detail, code);
    }
}


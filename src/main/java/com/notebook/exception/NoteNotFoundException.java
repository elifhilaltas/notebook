package com.notebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class NoteNotFoundException extends BaseException{

    public NoteNotFoundException(String message, String detail, int code) {
        super(message, detail, code);
    }
}

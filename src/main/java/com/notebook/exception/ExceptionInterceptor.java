package com.notebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleAllExceptions(UserNotFoundException ex) {

        CustomExceptionSchema exceptionResponse =
                new CustomExceptionSchema(
                        ex.getMessage(), ex.getDetail(), ex.getCode());
        return new ResponseEntity(exceptionResponse, HttpStatus.UNAUTHORIZED);

    }
    @ExceptionHandler(BookNotFoundException.class)
    public final ResponseEntity<Object> handleAllExceptions(BookNotFoundException ex) {

        CustomExceptionSchema exceptionResponse =
                new CustomExceptionSchema(
                        ex.getMessage(), ex.getDetail(), ex.getCode());
        return new ResponseEntity(exceptionResponse, HttpStatus.UNAUTHORIZED);

    }
    @ExceptionHandler(NoteNotFoundException.class)
    public final ResponseEntity<Object> handleAllExceptions(NoteNotFoundException ex) {

        CustomExceptionSchema exceptionResponse =
                new CustomExceptionSchema(
                        ex.getMessage(), ex.getDetail(), ex.getCode());
        return new ResponseEntity(exceptionResponse, HttpStatus.UNAUTHORIZED);

    }
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex) {

    CustomExceptionSchema exceptionResponse =
                new CustomExceptionSchema(
                        ex.getMessage(), ex.getDetail(), ex.getCode());
        return new ResponseEntity(exceptionResponse, HttpStatus.OK);

    }
}
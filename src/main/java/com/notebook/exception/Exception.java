package com.notebook.exception;

        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class Exception extends BaseException {

    public Exception(String message, String detail, int code) {
        super(message, detail, code);
    }
}

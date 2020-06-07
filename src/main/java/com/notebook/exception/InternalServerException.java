package com.notebook.exception;

        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends RuntimeException {
    private String message;
    private String detail;
    private int code;


    public InternalServerException(String message, String detail, int code) {
        this.message = message;
        this.detail = detail;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

package com.notebook.exception;

public class CustomExceptionSchema {
    private String message;
    private String detail;
    private int code;

    protected CustomExceptionSchema(){}

    public CustomExceptionSchema(String message, String detail, int code) {
        this.message = message;
        this.detail = detail;
        this.code = code;
    }

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

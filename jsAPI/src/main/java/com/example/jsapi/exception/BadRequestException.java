package com.example.jsapi.exception;

public class BadRequestException extends  RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}

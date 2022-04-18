package com.example.sinhvienapi.exception;

// Định Nghĩa lỗi bad request
public class BadRequestException extends  RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
package com.example.jsapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHande {
    // Xử lý riêng badrequest Exception
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handelBadRequesException(BadRequestException exception){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }


    // Xử lý chung với các exception còn lại
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handelOtherException(BadRequestException exception){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

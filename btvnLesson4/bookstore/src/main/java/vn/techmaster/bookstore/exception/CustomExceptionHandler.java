package vn.techmaster.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
       @ExceptionHandler(NotFoundException.class)
       public ErrorMessage handlerNotFoundException(NotFoundException ex ,WebRequest req)
       {
              return new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
       }
       
}

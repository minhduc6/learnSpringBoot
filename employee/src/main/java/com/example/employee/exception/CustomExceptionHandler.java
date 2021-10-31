package com.example.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;


@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(ResourceNotFoundEx.class)
    public String handlerNotFoundException(ResourceNotFoundEx ex , WebRequest rq,Model model)
    {
          MessageError ms = new MessageError(ex.getMessage(),HttpStatus.NOT_FOUND);
          model.addAttribute("message", ms.getMessage());
          return "error";
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(value = HttpStatus.PAYLOAD_TOO_LARGE)
    public String handlerMaxSizeFileException(MultipartException ex , WebRequest rq,Model model)
    {
          MessageError messageError = new MessageError("Faild upload file because file larger", HttpStatus.PAYLOAD_TOO_LARGE);
          System.out.println(messageError.getMessage());
          model.addAttribute("message",messageError.getMessage());
          return "error";
    }
    
}

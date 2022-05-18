package vn.techmaster.demosession.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import vn.techmaster.demosession.exception.UserException;

@ControllerAdvice // Hỗ trợ lấy ra lỗi và hiển thị lên trên màn hình
public class ControllerHandleException {
    @ExceptionHandler(UserException.class)
    public String handleExceptionByUser(UserException e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "error";
    }
}

package vn.techmaster.demosession.exception;

public class UserException extends RuntimeException { // RuntimeException : Bắt lỗi khi ứng dụng chạy

    public UserException(String arg0) {
        super(arg0);
    }
    
}

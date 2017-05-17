package me.myarmy.api.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Manki Kim on 2017-05-17.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "NotFound Error")
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() { super(); }
    public UserNotFoundException(String message) { super(message); }
    public UserNotFoundException(String message, Throwable cause) { super(message, cause); }
    public UserNotFoundException(Throwable cause) { super(cause); }
}

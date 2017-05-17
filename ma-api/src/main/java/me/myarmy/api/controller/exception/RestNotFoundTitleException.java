package me.myarmy.api.controller.exception;

/**
 * Created by Manki Kim on 2017-04-12.
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "Forbidden Error")
public class RestNotFoundTitleException extends RuntimeException {

    public RestNotFoundTitleException() { super(); }
    public RestNotFoundTitleException(String message) { super(message); }
    public RestNotFoundTitleException(String message, Throwable cause) { super(message, cause); }
    public RestNotFoundTitleException(Throwable cause) { super(cause); }
}

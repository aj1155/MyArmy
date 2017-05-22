package me.myarmy.api.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Manki kim on 2017-05-22.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "NotFound Error")
public class ResumeNotFoundException extends RuntimeException {
    public ResumeNotFoundException() { super(); }
    public ResumeNotFoundException(String message) { super(message); }
    public ResumeNotFoundException(String message, Throwable cause) { super(message, cause); }
    public ResumeNotFoundException(Throwable cause) { super(cause); }
}

package me.myarmy.api.controller.exception;

/**
 * Created by Manki Kim on 2017-02-23.
 */
public class InvalidStatusException extends RuntimeException {
    public InvalidStatusException() { super(); }
    public InvalidStatusException(String message) { super(message); }
    public InvalidStatusException(String message, Throwable cause) { super(message, cause); }
    public InvalidStatusException(Throwable cause) { super(cause); }
}

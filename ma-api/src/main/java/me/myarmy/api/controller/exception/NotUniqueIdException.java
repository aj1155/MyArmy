package me.myarmy.api.controller.exception;

/**
 * Created by Manki Kim on 2017-04-17.
 */
public class NotUniqueIdException extends RuntimeException {
    public NotUniqueIdException() { super(); }
    public NotUniqueIdException(String message) { super(message); }
    public NotUniqueIdException(String message, Throwable cause) { super(message, cause); }
    public NotUniqueIdException(Throwable cause) { super(cause); }
}

package com.webapp.blog.exception;

public class UserException extends RuntimeException {
    public UserException(String message) {
        super("USER DOESNst EXISTS ");
    }
}

package com.example.LoginApp.exception;

public class UnauthorizedUserException extends Throwable {
    public UnauthorizedUserException(String user_is_not_authenticated) {
        super(user_is_not_authenticated);
    }
}

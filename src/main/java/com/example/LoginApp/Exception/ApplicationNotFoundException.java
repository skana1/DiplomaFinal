package com.example.LoginApp.Exception;

public class ApplicationNotFoundException extends RuntimeException {
    public ApplicationNotFoundException(String message) {
        super(message);
    }
}

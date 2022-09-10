package com.example.usersservice.domain.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException() {
        super("User already exists");
    }
}

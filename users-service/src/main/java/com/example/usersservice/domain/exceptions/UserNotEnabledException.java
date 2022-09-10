package com.example.usersservice.domain.exceptions;

public class UserNotEnabledException extends RuntimeException{
    public UserNotEnabledException() {
        super(String.format("User not enabled!"));
    }
}
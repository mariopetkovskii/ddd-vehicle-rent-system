package com.example.usersservice.domain.exceptions;

public class AccessForbiddenException extends RuntimeException{
    public AccessForbiddenException() {
        super("Access forbidden");
    }
}

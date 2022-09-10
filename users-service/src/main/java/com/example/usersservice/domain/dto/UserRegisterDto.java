package com.example.usersservice.domain.dto;

import lombok.Getter;

@Getter
public class UserRegisterDto {
    String firstName;
    String lastName;
    String email;
    String password;
    String confirmPassword;
}

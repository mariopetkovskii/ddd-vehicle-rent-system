package com.example.usersservice.domain.dto;

import lombok.Data;
import lombok.Setter;

@Data
public class UserInfoDto {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
}

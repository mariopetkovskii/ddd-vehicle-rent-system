package com.example.usersservice.domain.dto;

import ddd.sharedkernel.domain.valueobjects.financial.Money;
import lombok.Data;
import lombok.Setter;

@Data
public class UserInfoDto {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private Money money;
    private Integer numOfRents;
}

package com.example.usersservice.domain.models;

import ddd.sharedkernel.domain.base.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

public enum Role implements GrantedAuthority {

    ROLE_ADMIN, ROLE_USER;


    @Override
    public String getAuthority() {
        return name();
    }
}
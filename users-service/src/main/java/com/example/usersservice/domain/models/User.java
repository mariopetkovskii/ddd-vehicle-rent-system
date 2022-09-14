package com.example.usersservice.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ddd.sharedkernel.domain.base.AbstractEntity;
import ddd.sharedkernel.domain.valueobjects.financial.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users_system")
public class User extends AbstractEntity<UserId> {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;
    @Column(name = "enabled")
    private Boolean isEnabled;

    @Column(name = "date_created")
    private OffsetDateTime dateCreated;

    @Column(name = "date_modified")
    private OffsetDateTime dateModified;

    private Role role;

    private Money money;

    private Integer numberOfRents;
    public User(){
        super(UserId.randomId(UserId.class));
    }

    public User(String firstName, String lastName, String email, String password) {
        super(UserId.randomId(UserId.class));
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isEnabled = true;
        this.dateCreated = OffsetDateTime.now();
        this.dateModified = OffsetDateTime.now();
        this.role = Role.ROLE_USER;
        this.money = Money.valueOf(0);
        this.numberOfRents = 0;
    }

    public void addNumOfRent(){
        this.numberOfRents += 1;
    }


}
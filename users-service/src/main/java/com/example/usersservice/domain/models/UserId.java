package com.example.usersservice.domain.models;

import ddd.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class UserId extends DomainObjectId {
    private UserId(){
        super(UserId.randomId(UserId.class).getId());
    }

    public UserId(@NonNull String uuid){
        super(uuid);
    }

    public static UserId of(String uuid){
        return new UserId(uuid);
    }

}

package ddd.rentmanagement.domain.model;

import ddd.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class RentId extends DomainObjectId {
    private RentId(){
        super(RentId.randomId(RentId.class).getId());
    }

    public RentId(@NonNull String uuid){
        super(uuid);
    }
}

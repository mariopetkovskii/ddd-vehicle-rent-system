package ddd.rentmanagement.domain.valueobjects;

import ddd.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Embeddable
public class UserId extends DomainObjectId {
    public UserId(){
        super(UserId.randomId(UserId.class).getId());
    }

    public UserId(@NonNull String uuid){
        super(uuid);
    }
}

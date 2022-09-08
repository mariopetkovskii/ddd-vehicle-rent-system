package ddd.rentmanagement.domain.valueobjects;

import ddd.rentmanagement.domain.model.RentId;
import ddd.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Embeddable
public class VehicleId extends DomainObjectId {
    private VehicleId(){
        super(VehicleId.randomId(VehicleId.class).getId());
    }

    public VehicleId(@NonNull String uuid){
        super(uuid);
    }
}

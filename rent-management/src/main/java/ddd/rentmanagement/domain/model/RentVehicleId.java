package ddd.rentmanagement.domain.model;

import ddd.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class RentVehicleId extends DomainObjectId {
    private RentVehicleId(){
        super(RentVehicleId.randomId(RentVehicleId.class).getId());
    }

    public RentVehicleId(@NonNull String uuid) {
        super(uuid);
    }
}

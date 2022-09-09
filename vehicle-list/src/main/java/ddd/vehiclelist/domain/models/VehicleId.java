package ddd.vehiclelist.domain.models;

import ddd.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class VehicleId extends DomainObjectId {
    private VehicleId(){
        super(VehicleId.randomId(VehicleId.class).getId());
    }

    public VehicleId(@NonNull String uuid){
        super(uuid);
    }

    public static VehicleId of(String uuid){
        return new VehicleId(uuid);
    }
}

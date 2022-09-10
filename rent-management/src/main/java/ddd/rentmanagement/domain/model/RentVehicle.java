package ddd.rentmanagement.domain.model;


import ddd.rentmanagement.domain.valueobjects.VehicleId;
import ddd.sharedkernel.domain.base.AbstractEntity;
import ddd.sharedkernel.domain.base.DomainObjectId;
import ddd.sharedkernel.domain.valueobjects.NumberOfRents;
import ddd.sharedkernel.domain.valueobjects.financial.Money;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "vehicle_rent")
@Getter
public class RentVehicle extends AbstractEntity<RentVehicleId> {

    private Money rentPrice;

    @Column(name = "days_rent", nullable = false)
    private Number daysRent;

    @AttributeOverride(name = "id", column = @Column(name="vehicle_id", nullable = false))
    private VehicleId vehicleId;


    private Instant rentedOn;

    public RentVehicle(@NonNull VehicleId vehicleId, @NonNull Money rentPrice, Number daysRent){
        super(DomainObjectId.randomId(RentVehicleId.class));
        this.vehicleId = vehicleId;
        this.rentPrice = rentPrice;
        this.daysRent = daysRent;
        this.rentedOn = Instant.now();
    }

    public RentVehicle(){
        super(DomainObjectId.randomId(RentVehicleId.class));
    }

    public Money subtotal(){
        return rentPrice.multiply(daysRent.intValue());
    }

}

package ddd.rentmanagement.domain.model;


import ddd.rentmanagement.domain.valueobjects.VehicleId;
import ddd.sharedkernel.domain.base.AbstractEntity;
import ddd.sharedkernel.domain.valueobjects.NumberOfRents;
import ddd.sharedkernel.domain.valueobjects.financial.Money;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_rent")
public class RentVehicle extends AbstractEntity<RentVehicleId> {

    private Money rentPrice;

    @Column(name = "days_rent", nullable = false)
    private Number daysRent;

    @AttributeOverride(name = "id", column = @Column(name="vehicle_id", nullable = false))
    private VehicleId vehicleId;

}

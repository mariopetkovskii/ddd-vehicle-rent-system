package ddd.vehiclelist.domain.models;

import ddd.sharedkernel.domain.base.AbstractEntity;
import ddd.sharedkernel.domain.valueobjects.NumberOfRents;
import ddd.sharedkernel.domain.valueobjects.financial.Money;
import ddd.vehiclelist.domain.valueobjects.Brand;
import ddd.vehiclelist.domain.valueobjects.Name;
import ddd.vehiclelist.domain.valueobjects.Type;
import lombok.Getter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
@Getter
public class Vehicle extends AbstractEntity<VehicleId> {

    private Name name;
    private Brand brand;
    private Money price;
    private Type type;
    @AttributeOverride(name = "number", column = @Column(name = "number_of_rents"))
    private NumberOfRents numOfRents;


}

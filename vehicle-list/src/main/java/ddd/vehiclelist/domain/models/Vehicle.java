package ddd.vehiclelist.domain.models;

import ddd.sharedkernel.domain.base.AbstractEntity;
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
    private int numOfRents;

    public Vehicle(){
        super(VehicleId.randomId(VehicleId.class));
    }

    public static Vehicle build(Name name, Brand brand, Money price, Type type){
        Vehicle vehicle = new Vehicle();
        vehicle.brand = brand;
        vehicle.name = name;
        vehicle.price = price;
        vehicle.type = type;
        vehicle.numOfRents = 0;
        return vehicle;
    }

    public void addRent(){
        this.numOfRents -= 1;
    }

    public void removeRent(){
        this.numOfRents += 1;
    }


}

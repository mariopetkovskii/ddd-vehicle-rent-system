package ddd.rentmanagement.domain.model;

import ddd.rentmanagement.domain.valueobjects.Vehicle;
import ddd.sharedkernel.domain.base.AbstractEntity;
import ddd.sharedkernel.domain.valueobjects.financial.Money;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="rents")
@Getter
public class Rent extends AbstractEntity<RentId> {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RentVehicle> rentVehicleSet;

    public Rent() {
        super(RentId.randomId(RentId.class));
        this.rentVehicleSet = new HashSet<>();
    }

    public Money total(){
        return this.rentVehicleSet.stream()
                .map(RentVehicle::subtotal)
                .reduce(new Money(0.), Money::add);
    }

    public RentVehicle addVehicle(@NonNull Vehicle vehicle, int rentDays){
        Objects.requireNonNull(vehicle, "vehicle must not be null");
        var item = new RentVehicle(vehicle.getId(), vehicle.getPrice(), rentDays);
        this.rentVehicleSet.add(item);
        return item;
    }

    public void removeVehicle(@NonNull RentVehicleId rentVehicleId){
        Objects.requireNonNull(rentVehicleId, "rent vehicle id must not be null");
        this.rentVehicleSet.removeIf(v -> v.getId().equals(rentVehicleId));
    }

}
